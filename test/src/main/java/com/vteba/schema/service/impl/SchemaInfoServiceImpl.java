package com.vteba.schema.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.vteba.schema.dao.SchemaInfoDao;
import com.vteba.schema.model.SchemaInfo;
import com.vteba.schema.service.spi.SchemaInfoService;
import com.vteba.service.context.spring.ApplicationContextHolder;
import com.vteba.tx.jdbc.datasource.MultiDataSourceTransactionManager;
import com.vteba.tx.jdbc.params.DeleteBean;
import com.vteba.tx.jdbc.params.QueryBean;
import com.vteba.tx.jdbc.params.UpdateBean;

/**
 * schema配置信息相关的service业务实现。
 * @author yinlei
 * @date 2014-10-11 14:51:55
 */
@Named
public class SchemaInfoServiceImpl implements SchemaInfoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SchemaInfoServiceImpl.class);
	
	private static final String SQL_SESSION_FACTORY = "SqlSessionFactory";
	
	@Inject
	private SchemaInfoDao schemaInfoDao;
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplateProxy;
	
	@Inject
	private MultiDataSourceTransactionManager chainedTransactionManager;

	public boolean createSchema(SchemaInfo schemaInfo) {
		schemaInfo = schemaInfoDao.get(schemaInfo.getSchemaId());
		
		String beanName = schemaInfo.getPeerName() + SQL_SESSION_FACTORY;
		SqlSessionFactoryBean skmbwSqlSessionFactory = ApplicationContextHolder.getFactoryBean(beanName);
		
		DruidDataSource peerDataSource = (DruidDataSource) skmbwSqlSessionFactory.getDataSource();
		DruidDataSource dataSource = peerDataSource.cloneDruidDataSource();
		String jdbcUrl = schemaInfo.getJdbcUrl();
//		jdbcUrl = jdbcUrl.substring(0, StringUtils.lastIndexOf(jdbcUrl, "/") + 1);// java原生的按正则表达式处理了
//		jdbcUrl += schemaInfo.getPeerName();
		dataSource.setUrl(schemaInfo.getJdbcUrl());
		
		try {
			dataSource.init();
		} catch (SQLException e) {
			LOGGER.error("动态创建数据源错误，jdbc_url=[{}]。", jdbcUrl, e);
			return false;
		}
		
		// 手动生成SqlSessionFactory
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setConfigLocation(skmbwSqlSessionFactory.getConfigLocation());
		factoryBean.setMapperLocations(skmbwSqlSessionFactory.getMapperLocations());
		
		SqlSessionFactory sqlSessionFactory = null;
		try {
			factoryBean.afterPropertiesSet();
			sqlSessionFactory = factoryBean.getObject();
		} catch (Exception e) {
			LOGGER.error("动态创建SqlSessionFactory错误，jdbc_url=[{}]。", jdbcUrl, e);
			return false;
		}
		// 添加事务管理器
		DataSourceTransactionManager dsTransactionManager = new DataSourceTransactionManager(dataSource);
		chainedTransactionManager.addTransactionManager(schemaInfo.getSchemaName(), dsTransactionManager);
		
		// 添加SqlSessionFactory
		Map<String, SqlSessionFactory> maps = sqlSessionTemplateProxy.getProxySqlSessionFactory();
		maps.put(schemaInfo.getSchemaName(), sqlSessionFactory);
		return true;
	}
	
	/**
	 * 动态移除某一应用的分区schema数据源
	 * @param schemaInfo 移除条件
	 * @return true成功，false失败
	 */
	public boolean removeSchema(SchemaInfo schemaInfo) {
		schemaInfo = schemaInfoDao.get(schemaInfo.getSchemaId());
		Map<String, SqlSessionFactory> maps = sqlSessionTemplateProxy.getProxySqlSessionFactory();
		
		String schema = schemaInfo.getSchemaName();
		SqlSessionFactory sqlSessionFactory = maps.remove(schema);// 移除对应的SqlSessionFactory
		
		DruidDataSource ds = (DruidDataSource) sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
		ds.close();
		
		sqlSessionFactory = null;
		
		chainedTransactionManager.removeTransactionManager(schema);
		
		return true;
	}
	
	@Override
	public int count(QueryBean params) {
		return schemaInfoDao.count(params);
	}

	@Override
	public int deleteBatch(DeleteBean params) {
		return schemaInfoDao.deleteBatch(params);
	}

	@Override
	public int deleteById(Long id) {
		return schemaInfoDao.deleteById(id);
	}

	@Override
	public int save(SchemaInfo record) {
		return schemaInfoDao.save(record);
	}

	@Override
	public List<SchemaInfo> queryForList(QueryBean params) {
		return schemaInfoDao.queryForList(params);
	}

	@Override
	public SchemaInfo get(Long id) {
		return schemaInfoDao.get(id);
	}

	@Override
	public int updateBatch(UpdateBean params) {
		return schemaInfoDao.updateBatch(params);
	}

	@Override
	public int updateById(UpdateBean params) {
		return schemaInfoDao.updateById(params);
	}

    @Override
    public int countBy(QueryBean params) {
        return schemaInfoDao.countBy(params);
    }

    @Override
    public int deleteBulks(DeleteBean params) {
        return schemaInfoDao.deleteBulks(params);
    }

    @Override
    public List<SchemaInfo> queryList(QueryBean params) {
        return schemaInfoDao.queryList(params);
    }

    @Override
    public List<SchemaInfo> pagedForList(QueryBean params) {
        return schemaInfoDao.pagedForList(params);
    }

    @Override
    public List<SchemaInfo> pagedList(QueryBean params) {
//    	SchemaInfo schemaInfo = (SchemaInfo) params.getParams();
//    	createSchema(schemaInfo);
        return schemaInfoDao.pagedList(params);
    }

    @Override
    public int updateBulks(UpdateBean params) {
        return schemaInfoDao.updateBulks(params);
    }

}
