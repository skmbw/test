package com.vteba.table.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.common.exception.NonUniqueException;
import com.vteba.tx.jdbc.params.DeleteBean;
import com.vteba.tx.jdbc.params.QueryBean;
import com.vteba.tx.jdbc.params.UpdateBean;

import com.vteba.table.dao.ShardsTableDao;
import com.vteba.table.model.ShardsTable;
import com.vteba.table.service.spi.ShardsTableService;

/**
 * 分区表配置信息相关的service业务实现。
 * @author yinlei
 * @date 2014-10-31 15:51:24
 */
@Named
public class ShardsTableServiceImpl implements ShardsTableService {
	
	@Inject
	private ShardsTableDao shardsTableDao;

	@Override
	public int count(QueryBean params) {
		return shardsTableDao.count(params);
	}

	@Override
	public int deleteBatch(DeleteBean params) {
		return shardsTableDao.deleteBatch(params);
	}

	@Override
	public int deleteById(Integer id) {
		return shardsTableDao.deleteById(id);
	}

	@Override
	public int save(ShardsTable record) {
		return shardsTableDao.save(record);
	}

	@Override
	public List<ShardsTable> queryForList(QueryBean params) {
		return shardsTableDao.queryForList(params);
	}

	@Override
	public ShardsTable get(Integer id) {
		return shardsTableDao.get(id);
	}

	@Override
	public int updateBatch(UpdateBean params) {
		return shardsTableDao.updateBatch(params);
	}

	@Override
	public int updateById(UpdateBean params) {
		return shardsTableDao.updateById(params);
	}

    @Override
    public int countBy(QueryBean params) {
        return shardsTableDao.countBy(params);
    }

    @Override
    public int deleteBulks(DeleteBean params) {
        return shardsTableDao.deleteBulks(params);
    }

    @Override
    public List<ShardsTable> queryList(QueryBean params) {
        return shardsTableDao.queryList(params);
    }

    @Override
    public List<ShardsTable> pagedForList(QueryBean params) {
        return shardsTableDao.pagedForList(params);
    }

    @Override
    public List<ShardsTable> pagedList(QueryBean params) {
        return shardsTableDao.pagedList(params);
    }

    @Override
    public int updateBulks(UpdateBean params) {
        return shardsTableDao.updateBulks(params);
    }

    @Override
    public ShardsTable unique(QueryBean params) {
    	List<ShardsTable> result = queryList(params);
    	if (result == null || result.size() == 0) {
    		return null;
    	} else if (result != null && result.size() >= 2) {
    		throw new NonUniqueException("查询数据，结果不唯一。");
    	}
    	return result.get(0);
    }
    
    @Override
    public ShardsTable unique(ShardsTable appInfo) {
    	QueryBean params = new QueryBean();
    	params.setParams(appInfo);
    	return unique(params);
    }
}
