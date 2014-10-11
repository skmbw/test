package com.vteba.schema.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.tx.jdbc.params.DeleteBean;
import com.vteba.tx.jdbc.params.QueryBean;
import com.vteba.tx.jdbc.params.UpdateBean;

import com.vteba.schema.dao.SchemaInfoDao;
import com.vteba.schema.model.SchemaInfo;
import com.vteba.schema.service.spi.SchemaInfoService;

/**
 * schema配置信息相关的service业务实现。
 * @author yinlei
 * @date 2014-10-11 14:51:55
 */
@Named
public class SchemaInfoServiceImpl implements SchemaInfoService {
	
	@Inject
	private SchemaInfoDao schemaInfoDao;

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
        return schemaInfoDao.pagedList(params);
    }

    @Override
    public int updateBulks(UpdateBean params) {
        return schemaInfoDao.updateBulks(params);
    }

}
