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

import com.alibaba.druid.pool.DruidDataSource;
import com.vteba.schema.dao.SchemaInfoDao;
import com.vteba.schema.model.SchemaInfo;
import com.vteba.schema.service.spi.SchemaInfoService;
import com.vteba.service.context.spring.ApplicationContextHolder;
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
	
	@Inject
	private SchemaInfoDao schemaInfoDao;
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplateProxy;

	public boolean createSchema(SchemaInfo schemaInfo) {
		
		Map<String, SqlSessionFactory> maps = sqlSessionTemplateProxy.getProxySqlSessionFactory();
		SqlSessionFactoryBean skmbwSqlSessionFactory = ApplicationContextHolder.getBean("&skmbwSqlSessionFactory");
		
		DruidDataSource skmbwDataSource = (DruidDataSource) skmbwSqlSessionFactory.getDataSource();
		DruidDataSource skmbw3DataSource = skmbwDataSource.cloneDruidDataSource();
		String jdbcUrl = skmbw3DataSource.getUrl();
		jdbcUrl = jdbcUrl + 3;
		skmbw3DataSource.setUrl(jdbcUrl);
		
		try {
			skmbw3DataSource.init();
		} catch (SQLException e) {
			LOGGER.error("动态创建数据源错误，jdbc_url=[{}]。", jdbcUrl, e);
			return false;
		}
		
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(skmbw3DataSource);
		factoryBean.setConfigLocation(skmbwSqlSessionFactory.getConfigLocation());
		factoryBean.setMapperLocations(skmbwSqlSessionFactory.getMapperLocations());
		
		SqlSessionFactory skmbw3SqlSessionFactory = null;
		try {
			factoryBean.afterPropertiesSet();
			skmbw3SqlSessionFactory = factoryBean.getObject();
		} catch (Exception e) {
			LOGGER.error("动态创建SqlSessionFactory错误，jdbc_url=[{}]。", jdbcUrl, e);
			return false;
		}
		
		maps.put("skmbw3", skmbw3SqlSessionFactory);
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
    	SchemaInfo schemaInfo = (SchemaInfo) params.getParams();
    	createSchema(schemaInfo);
        return schemaInfoDao.pagedList(params);
    }

    @Override
    public int updateBulks(UpdateBean params) {
        return schemaInfoDao.updateBulks(params);
    }

}
