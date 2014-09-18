package com.vteba.user2.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.user2.dao.UserDao;
import com.vteba.user2.model.User;
import com.vteba.user2.model.UserBean;
import com.vteba.user2.service.spi.UserService;

/**
 * 系统用户相关的service业务实现。
 * @author yinlei
 * @date 2014-9-18 10:11:32
 */
@Named
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDao userDao;

	@Override
	public int count(UserBean params) {
		return userDao.count(params);
	}

	@Override
	public int deleteBatch(UserBean params) {
		return userDao.deleteBatch(params);
	}

	@Override
	public int deleteById(String id) {
		return userDao.deleteById(id);
	}

	@Override
	public int save(User record) {
	    User user = new User();
        user.setId("33");
        Date date = new Date();
        user.setCreateDate(date);
        user.setUserName("尹雷2");
        userDao.updateById(user);
        
        User params = new User();
        params.setUserName("尹雷2");
        //params.setCreateDate(date);
        params.setState(true);
        user.setId(null);
        userDao.updateBulks(user, params);
        
        UserBean userBean = new UserBean();
        userBean.createCriteria().andUserAccountEqualTo("yinlei@126.com");
        userDao.updateBatch(user, userBean);
        
        userDao.deleteBatch(userBean);
        userDao.deleteBulks(params);
	    
		return userDao.save(record);
	}

	@Override
	public List<User> queryForList(UserBean userBean) {
	    User user = new User();
        user.setUserName("尹雷");
        user.setUserAccount("tong@126.com");
        userDao.queryList(user);
        
        userDao.countBy(user);
        
        userDao.get("33");
        
        User params = new User();
        params.setUserName("好好2");
        params.setStart(0);
        userDao.pagedList(params);
        
        userBean = new UserBean();
        userBean.createCriteria().andUserAccountEqualTo("tongku@126.com");
        
        userDao.count(userBean);
        userDao.pagedForList(userBean);
	    
		return userDao.queryForList(userBean);
	}

	@Override
	public User get(String id) {
		return userDao.get(id);
	}

	@Override
	public int updateBatch(User record, UserBean params) {
		return userDao.updateBatch(record, params);
	}

	@Override
	public int updateById(User record) {
		return userDao.updateById(record);
	}

    @Override
    public int countBy(User params) {
        return userDao.countBy(params);
    }

    @Override
    public int deleteBulks(User params) {
        return userDao.deleteBulks(params);
    }

    @Override
    public List<User> queryList(User params) {
        return userDao.queryList(params);
    }

    @Override
    public List<User> pagedForList(UserBean params) {
        return userDao.pagedForList(params);
    }

    @Override
    public List<User> pagedList(User params) {
        return userDao.pagedList(params);
    }

    @Override
    public int updateBulks(User record, User params) {
        return userDao.updateBulks(record, params);
    }

}
