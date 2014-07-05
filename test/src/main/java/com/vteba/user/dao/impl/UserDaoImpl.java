package com.vteba.user.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vteba.tx.jdbc.spring.SpringJdbcTemplate;
import com.vteba.tx.jdbc.spring.impl.SpringGenericDaoImpl;
import com.vteba.user.dao.UserDao;
import com.vteba.user.model.EmpUser;
import com.vteba.user.model.User;

/**
 * UserDao实现
 * @author  yinlei 
 * @since 2014-7-4
 */
@Repository
public class UserDaoImpl extends SpringGenericDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl() {
        super();
    }

    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Autowired
    @Override
    public void setSpringJdbcTemplate(SpringJdbcTemplate skmbwJdbcTemplate) {
        this.springJdbcTemplate = skmbwJdbcTemplate;
    }

    @Override
    public EmpUser mapRows(ResultSet rs, String sql, Class<?> clazz) throws SQLException {
        // TODO Auto-generated method stub
        if (clazz == User.class) {
            
        } else if (clazz == EmpUser.class) {
            
        }
        
        return null;
    }

//    @Override
//    public User mapRows(ResultSet rs, int rowNum) throws SQLException {
//        User user = new User();
//        user.setUserName(rs.getString("user_name"));
//        user.setAge(rs.getInt("age"));
//        user.setEmail(rs.getString("email"));
//        user.setId(rs.getLong("id"));
//        user.setPassword(rs.getString("password"));
//        user.setState(rs.getBoolean("state"));
//        return user;
//    }
//
//    @Override
//    public Map<String, Object> mapBean(User entity, boolean prefix, Map<String, Object> params) {
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//        if (entity != null) {
//            if (prefix) {
//                if (entity.getUserName() != null) {
//                    resultMap.put("_user_name", entity.getUserName());
//                    params.put("_user_name", entity.getUserName());
//                }
//                if (entity.getAge() != null) {
//                    resultMap.put("_age", entity.getAge());
//                    params.put("_age", entity.getAge());
//                }
//                if (entity.getEmail() != null) {
//                    resultMap.put("_email", entity.getEmail());
//                    params.put("_email", entity.getEmail());
//                }
//                if (entity.getPassword() != null) {
//                    resultMap.put("_password", entity.getPassword());
//                    params.put("_password", entity.getPassword());
//                }
//                resultMap.put("_state", entity.isState() ? 1 : 0);
//                params.put("_state", entity.isState() ? 1 : 0);
//            } else {
//                if (entity.getUserName() != null) {
//                    resultMap.put("user_name", entity.getUserName());
//                }
//                if (entity.getAge() != null) {
//                    resultMap.put("age", entity.getAge());
//                }
//                if (entity.getId() != null) {
//                    resultMap.put("id", entity.getId());
//                }
//                if (entity.getEmail() != null) {
//                    resultMap.put("email", entity.getEmail());
//                }
//                if (entity.getPassword() != null) {
//                    resultMap.put("password", entity.getPassword());
//                }
//                resultMap.put("state", entity.isState() ? 1 : 0);
//            }
//        }
//        return resultMap;
//    }

    

}
