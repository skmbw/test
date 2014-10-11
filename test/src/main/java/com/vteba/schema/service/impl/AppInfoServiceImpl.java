package com.vteba.schema.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.tx.jdbc.params.DeleteBean;
import com.vteba.tx.jdbc.params.QueryBean;
import com.vteba.tx.jdbc.params.UpdateBean;

import com.vteba.schema.dao.AppInfoDao;
import com.vteba.schema.model.AppInfo;
import com.vteba.schema.service.spi.AppInfoService;

/**
 * 应用配置信息相关的service业务实现。
 * @author yinlei
 * @date 2014-10-11 11:13:49
 */
@Named
public class AppInfoServiceImpl implements AppInfoService {
	
	@Inject
	private AppInfoDao appInfoDao;

	@Override
	public int count(QueryBean params) {
		return appInfoDao.count(params);
	}

	@Override
	public int deleteBatch(DeleteBean params) {
		return appInfoDao.deleteBatch(params);
	}

	@Override
	public int deleteById(Long id) {
		return appInfoDao.deleteById(id);
	}

	@Override
	public int save(AppInfo record) {
		return appInfoDao.save(record);
	}

	@Override
	public List<AppInfo> queryForList(QueryBean params) {
		return appInfoDao.queryForList(params);
	}

	@Override
	public AppInfo get(Long id) {
		return appInfoDao.get(id);
	}

	@Override
	public int updateBatch(UpdateBean params) {
		return appInfoDao.updateBatch(params);
	}

	@Override
	public int updateById(UpdateBean params) {
		return appInfoDao.updateById(params);
	}

    @Override
    public int countBy(QueryBean params) {
        return appInfoDao.countBy(params);
    }

    @Override
    public int deleteBulks(DeleteBean params) {
        return appInfoDao.deleteBulks(params);
    }

    @Override
    public List<AppInfo> queryList(QueryBean params) {
        return appInfoDao.queryList(params);
    }

    @Override
    public List<AppInfo> pagedForList(QueryBean params) {
        return appInfoDao.pagedForList(params);
    }

    @Override
    public List<AppInfo> pagedList(QueryBean params) {
        return appInfoDao.pagedList(params);
    }

    @Override
    public int updateBulks(UpdateBean params) {
        return appInfoDao.updateBulks(params);
    }

}
