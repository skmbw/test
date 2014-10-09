package com.vteba.user2.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.table.dao.ShardsTableDao;
import com.vteba.table.model.ShardsTable;
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
	private ShardsTableDao shardsTableDao;

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
		ShardsTable table = new ShardsTable();
		table.setCreateDate(new Date());
		//table.setId(uuidKeyGenerator.nextInt());
		table.setCurrentTable("shards_table");
		table.setDbschema("skmbw");
		table.setStrategy("month");
		table.setTableName("shards2_table_201410m" + uuidKeyGenerator.next());
		shardsTableDao.save(table);
		
		record.setId(uuidKeyGenerator.next());
//		User user = new User();
//		user.setId("76a729c7-657e-43f4-b384-06df62f82d9f_201409m");
//		Date date = new Date();
//		user.setCreateDate(date);
//		user.setUserName("尹雷2");
//		UpdateBean updateBean = new UpdateBean();
//		updateBean.setRecord(user);
//		updateBean.setKeyValue("76a729c7-657e-43f4-b384-06df62f82d9f_201409m");
//		userDao.updateById(updateBean);
//
//		User params = new User();
//		params.setUserName("yinlei2");
//		user.setId(null);
//		
//		UpdateBean bulkUpdateBean = new UpdateBean(user, params, "76a729c7-657e-43f4-b384-06df62f82d9f_201409m");
//		userDao.updateBulks(bulkUpdateBean);
//
//		UserBean userBean = new UserBean();
//		userBean.createCriteria().andUserAccountEqualTo("yinlei@126.com");
//		UpdateBean batchUpdateBean = new UpdateBean(user, userBean, "76a729c7-657e-43f4-b384-06df62f82d9f_201409m");
//		userDao.updateBatch(batchUpdateBean);
//
//		DeleteBean bulkDeleteBean = new DeleteBean(201409, 201409, params);
//		DeleteBean batchDeleteBean = new DeleteBean(201409, 201409, userBean);
//		
//		userDao.deleteBatch(batchDeleteBean);
//		userDao.deleteBulks(bulkDeleteBean);
//		if (new Random().nextInt() - 100 < 1) {
//			throw new RuntimeException("");
//		}
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
//		 User user = new User();
//		 user.setUserName("yinlei1");
//		 user.setUserAccount("tongku@126.com");
//		 QueryBean userQueryBean = new QueryBean(201409, 201409, user);
//		 userDao.queryList(userQueryBean);
//		
//		 userQueryBean.setStats(true);
//		 userDao.countBy(userQueryBean);
//		
//		 userDao.get("76a729c7-657e-43f4-b384-06df62f82d9f_201409m");
//		
//		 User params2 = new User();
//		 params2.setUserName("yinlei2");
//		 QueryBean userQueryBean2 = new QueryBean(201409, 201410, params2);
//		 userQueryBean2.setDistinct(true);
//		 userQueryBean2.setOrderBy("user_name desc");
//		 userQueryBean2.setPageSize(20);
//		 userDao.pagedList(userQueryBean2);
//		
//		 UserBean userBean = new UserBean();
//		 userBean.createCriteria().andUserAccountEqualTo("tongku@126.com");
//		 
//		 QueryBean criteriaBean = new QueryBean(201409, 201410, userBean);
//		 criteriaBean.setStats(true);
//		 userDao.count(criteriaBean);
//		 
//		 criteriaBean.setStats(false);
//		 criteriaBean.setDistinct(true);
//		 criteriaBean.setPageNo(2);
//		 criteriaBean.setEndDate(201409);
//		
//		 userDao.pagedForList(criteriaBean);

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
