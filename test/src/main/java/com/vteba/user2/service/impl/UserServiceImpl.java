package com.vteba.user2.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.tx.jdbc.params.DeleteBean;
import com.vteba.tx.jdbc.params.QueryBean;
import com.vteba.tx.jdbc.params.UpdateBean;
import com.vteba.tx.jdbc.sequence.KeyGenerator;
import com.vteba.user2.dao.UserDao;
import com.vteba.user2.model.User;
import com.vteba.user2.model.UserBean;
import com.vteba.user2.service.spi.UserService;

/**
 * 系统用户相关的service业务实现。
 * 
 * @author yinlei
 * @date 2014-9-18 10:11:32
 */
@Named
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao userDao;

	@Inject
	private KeyGenerator uuidKeyGenerator;

	@Override
	public int count(UserBean params) {
		QueryBean queryBean = new QueryBean();
		queryBean.setParams(params);
		return userDao.count(queryBean);
	}

	@Override
	public int deleteBatch(UserBean params) {
		DeleteBean deleteBean = new DeleteBean();
		deleteBean.setParams(params);
		return userDao.deleteBatch(deleteBean);
	}

	@Override
	public int deleteById(String id) {
		return userDao.deleteById(id);
	}

	@Override
	public int save(User record) {
		record.setId(uuidKeyGenerator.next());
//		User user = new User();
//		user.setId("76a729c7-657e-43f4-b384-06df62f82d9f_201409m");
//		Date date = new Date();
//		user.setCreateDate(date);
//		user.setUserName("尹雷2");
//		// userDao.updateById(user);
//
//		User params = new User();
//		params.setUserName("尹雷2");
//		// params.setCreateDate(date);
//		params.setState(true);
//		user.setId(null);
//		userDao.updateBulks(user, params);
//
//		UserBean userBean = new UserBean();
//		userBean.createCriteria().andUserAccountEqualTo("yinlei@126.com");
//		userDao.updateBatch(user, userBean);
//
//		userDao.deleteBatch(userBean);
//		userDao.deleteBulks(params);

		return userDao.save(record);
	}

	@Override
	public List<User> queryForList(UserBean userBean) {
		QueryBean queryBean = new QueryBean();
		queryBean.setParams(userBean);
		return userDao.queryForList(queryBean);
	}

	@Override
	public User get(String id) {
		return userDao.get(id);
	}

	@Override
	public int updateBatch(User record, UserBean params) {
		UpdateBean updateBean = new UpdateBean();
		updateBean.setRecord(record);
		updateBean.setParams(params);
		return userDao.updateBatch(updateBean);
	}

	@Override
	public int updateById(User record) {
		UpdateBean updateBean = new UpdateBean();
		updateBean.setRecord(record);
		return userDao.updateById(updateBean);
	}

	@Override
	public int countBy(User params) {
		QueryBean queryBean = new QueryBean();
		queryBean.setParams(params);
		return userDao.countBy(queryBean);
	}

	@Override
	public int deleteBulks(User params) {
		DeleteBean deleteBean = new DeleteBean();
		deleteBean.setParams(params);
		return userDao.deleteBulks(deleteBean);
	}

	@Override
	public List<User> queryList(User params) {
		QueryBean queryBean = new QueryBean();
		queryBean.setParams(params);
		return userDao.queryList(queryBean);
	}

	@Override
	public List<User> pagedForList(UserBean params) {
		QueryBean queryBean = new QueryBean();
		queryBean.setParams(params);
		return userDao.pagedForList(queryBean);
	}

	@Override
	public List<User> pagedList(User params) {
		 User user = new User();
		 user.setUserName("yinlei1");
		 user.setUserAccount("tongku@126.com");
		 QueryBean userQueryBean = new QueryBean(201409, 201409, user);
		 userDao.queryList(userQueryBean);
		
		 userDao.countBy(userQueryBean);
		
		 userDao.get("76a729c7-657e-43f4-b384-06df62f82d9f_201409m");
		
		 User params2 = new User();
		 params2.setUserName("yinlei2");
		 QueryBean userQueryBean2 = new QueryBean(201409, 201409, params2);
		 userQueryBean2.setDistinct(true);
		 userQueryBean2.setOrderBy("user_name desc");
		 userQueryBean2.setPageSize(20);
		 userDao.pagedList(userQueryBean2);
		
		 UserBean userBean = new UserBean();
		 userBean.createCriteria().andUserAccountEqualTo("tongku@126.com");
		 
		 QueryBean criteriaBean = new QueryBean(201409, 201409, userBean);
		 userDao.count(criteriaBean);
		 
		 criteriaBean.setDistinct(true);
		 criteriaBean.setPageNo(2);
		 criteriaBean.setEndDate(201409);
		
		 userDao.pagedForList(criteriaBean);

		params.setUserAccount("tongku@126.com");
		QueryBean queryBean = new QueryBean();
		queryBean.setParams(params);
		return userDao.pagedList(queryBean);
	}

	@Override
	public int updateBulks(User record, User params) {
		UpdateBean updateBean = new UpdateBean();
		updateBean.setRecord(record);
		updateBean.setParams(params);
		return userDao.updateBulks(updateBean);
	}

}
