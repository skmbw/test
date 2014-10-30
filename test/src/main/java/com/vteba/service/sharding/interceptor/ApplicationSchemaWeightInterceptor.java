package com.vteba.service.sharding.interceptor;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vteba.schema.model.AppInfo;
import com.vteba.schema.model.SchemaInfo;
import com.vteba.schema.service.spi.AppInfoService;
import com.vteba.schema.service.spi.SchemaInfoService;
import com.vteba.service.tenant.SchemaWeightHolder;
import com.vteba.service.tenant.annotation.Application;
import com.vteba.service.tenant.annotation.Schema;
import com.vteba.tx.jdbc.params.QueryBean;

/**
 * 解析注解@Application。回去当前应用的名字，然后根据应用的配置，回去改应用
 * 连接的分区数据库，如果有权重，根据权重获取对应的数据库schema
 * @author yinlei
 * @date 2013-8-16
 */
@Named
public class ApplicationSchemaWeightInterceptor implements MethodInterceptor{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationSchemaWeightInterceptor.class);

	@Inject
	private AppInfoService appInfoService;
	
	@Inject
	private SchemaInfoService schemaInfoService;
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object object = invocation.getThis();//获得被拦截的目标对象
		Class<?> proxyClass = object.getClass();
		Class<?>[] classes = proxyClass.getInterfaces();// 因为我们知道，代理的就是MyBatis的Mapper借口
		if (classes != null) {
			Class<?> clazz = classes[0];
			Application app = clazz.getAnnotation(Application.class);
			if (app != null) {// 多个对等数据库的应用，分区应用
				String name = app.name();
				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("ApplicationSchemaWeight，APP是：[{}]。", name);
				}
				
				// 根据应用名，获取应用信息
				AppInfo appInfo = new AppInfo();
				appInfo.setAppName(name);
				appInfo = appInfoService.unique(appInfo);
				
				// 获取该应用下面所分配的schema，数据库
				QueryBean params = new QueryBean();
				
				SchemaInfo schemaInfo = new SchemaInfo();
				schemaInfo.setAppId(appInfo.getAppId());
				
				params.setParams(schemaInfo);
				
				List<SchemaInfo> schemaInfoList = schemaInfoService.queryList(params);
				int sum = 0;
				// 获取总的权重
				for (SchemaInfo bean : schemaInfoList) {
					sum += bean.getWeight();
				}
				
				// 选取随机权重
				Random random = new Random();
				int weight = random.nextInt(sum);
				
				String schema = null;
				
				// 根据权重随机数，获取对应的schema
				sum = 0;
				for (SchemaInfo bean : schemaInfoList) {
					sum += bean.getWeight();
					if (weight <= sum) {
						schema = bean.getSchemaName();
						break;
					}
				}
				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("根据权重选择的schema是=[{}]", schema);
				}
				// 设置对应的schema
				SchemaWeightHolder.putSchema(schema);
				
			} else {// 单数据库应用，非分区数据库应用，切换其schema（之所以要切换，是因为分区应用可能切到其他库中了）
				Schema schema = clazz.getAnnotation(Schema.class);
				if (schema != null) {
					SchemaWeightHolder.putSchema(schema.name());
				}
			}
		}
		return invocation.proceed();
	}

}
