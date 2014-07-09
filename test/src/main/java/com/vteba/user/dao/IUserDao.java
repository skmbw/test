package com.vteba.user.dao;

import com.vteba.tx.hibernate.IHibernateGenericDao;
import com.vteba.user.model.User;


public interface IUserDao extends IHibernateGenericDao<User, Long> {

}
