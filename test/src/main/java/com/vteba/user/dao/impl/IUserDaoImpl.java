package com.vteba.user.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.user.dao.IUserDao;
import com.vteba.user.model.User;

@Named
public class IUserDaoImpl extends HibernateGenericDaoImpl<User, Long> implements IUserDao {

    @Inject
    @Override
    public void setSessionFactory(SessionFactory skmbwSessionFactory) {
        this.sessionFactory = skmbwSessionFactory;
    }

}
