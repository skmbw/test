package com.vteba.table.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.common.exception.NonUniqueException;
import com.vteba.tx.jdbc.params.DeleteBean;
import com.vteba.tx.jdbc.params.QueryBean;
import com.vteba.tx.jdbc.params.UpdateBean;

import com.vteba.table.dao.TableDetailDao;
import com.vteba.table.model.TableDetail;
import com.vteba.table.service.spi.TableDetailService;

/**
 * 分区表明细信息相关的service业务实现。
 * @author yinlei
 * @date 2014-10-31 15:51:23
 */
@Named
public class TableDetailServiceImpl implements TableDetailService {
	
	@Inject
	private TableDetailDao tableDetailDao;

	@Override
	public int count(QueryBean params) {
		return tableDetailDao.count(params);
	}

	@Override
	public int deleteBatch(DeleteBean params) {
		return tableDetailDao.deleteBatch(params);
	}

	@Override
	public int deleteById(Long id) {
		return tableDetailDao.deleteById(id);
	}

	@Override
	public int save(TableDetail record) {
		return tableDetailDao.save(record);
	}

	@Override
	public List<TableDetail> queryForList(QueryBean params) {
		return tableDetailDao.queryForList(params);
	}

	@Override
	public TableDetail get(Long id) {
		return tableDetailDao.get(id);
	}

	@Override
	public int updateBatch(UpdateBean params) {
		return tableDetailDao.updateBatch(params);
	}

	@Override
	public int updateById(UpdateBean params) {
		return tableDetailDao.updateById(params);
	}

    @Override
    public int countBy(QueryBean params) {
        return tableDetailDao.countBy(params);
    }

    @Override
    public int deleteBulks(DeleteBean params) {
        return tableDetailDao.deleteBulks(params);
    }

    @Override
    public List<TableDetail> queryList(QueryBean params) {
        return tableDetailDao.queryList(params);
    }

    @Override
    public List<TableDetail> pagedForList(QueryBean params) {
        return tableDetailDao.pagedForList(params);
    }

    @Override
    public List<TableDetail> pagedList(QueryBean params) {
        return tableDetailDao.pagedList(params);
    }

    @Override
    public int updateBulks(UpdateBean params) {
        return tableDetailDao.updateBulks(params);
    }

    @Override
    public TableDetail unique(QueryBean params) {
    	List<TableDetail> result = queryList(params);
    	if (result == null || result.size() == 0) {
    		return null;
    	} else if (result != null && result.size() >= 2) {
    		throw new NonUniqueException("查询数据，结果不唯一。");
    	}
    	return result.get(0);
    }
    
    @Override
    public TableDetail unique(TableDetail appInfo) {
    	QueryBean params = new QueryBean();
    	params.setParams(appInfo);
    	return unique(params);
    }
}
