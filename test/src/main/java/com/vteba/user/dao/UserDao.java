package com.vteba.user.dao;

import com.vteba.tx.jdbc.spring.spi.SpringGenericDao;
import com.vteba.user.model.User;


public interface UserDao extends SpringGenericDao<User, Long> {

}
