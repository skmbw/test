package com.vteba.user.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.collect.Maps;
import com.vteba.tx.generic.Page;
import com.vteba.user.dao.UserDao;
import com.vteba.user.model.User;
import com.vteba.web.servlet.AutowiredHttpServlet;

/**
 * 用户servlet
 * @author yinlei
 * @since 2014-7-4
 */
@Controller
public class UserServlet extends AutowiredHttpServlet {
    
    private static final long serialVersionUID = -231244380014950424L;

    @Autowired
    private UserDao userDaoImpl;
    
    public void servlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setAge(14);
        user.setEmail("email@126.com");
        user.setPassword("123456");
        user.setState(true);
        user.setUserName("yinlei");
        
        Long id = userDaoImpl.save(user);
        System.out.println(id);
        
        user = userDaoImpl.get(id);
        System.out.println(user);
        
        user = userDaoImpl.unique(user);
        System.out.println(user);
        
        User entity = new User();
        entity.setId(id);
        entity.setAge(19);
        entity.setEmail("yinlei@126.com");
        int i = userDaoImpl.update(entity);
        System.out.println("更新条数：" + i);
        
        User criteria = new User();
        criteria.setId(5L);
        entity.setId(null);
        i = userDaoImpl.updateBatch(entity, criteria);
        System.out.println("updateBatch：" + i);
        
        Page<User> page = new Page<User>();
        Map<String, String> orders = Maps.newHashMap();
        orders.put("user_name", "desc");
        orders.put("email", "asc");
        page.setOrders(orders);
        
        User params = new User();
        params.setAge(14);
        params.setState(true);
        page = userDaoImpl.queryForPage(page, params);
        System.out.println(page);
        
        String sql = "select * from user where age = ? and state = 1";
        userDaoImpl.queryForPage(page, sql, 14);
        
        userDaoImpl.query(sql, 14);
        
        userDaoImpl.query(params);
        
        sql = "select * from user where age = :age and state = 1";;
        userDaoImpl.query(sql, params);
        
        userDaoImpl.queryList(sql, params);
        
        userDaoImpl.queryPageList(page, sql, params);
        
        sql = "select * from user where age = ? and state = 1";
        userDaoImpl.queryPageList(page, sql, User.class, 14);
        
        sql = "select age from user where id = ?";
        userDaoImpl.queryForObject(sql, Integer.class, 3);
        
        sql = "select age from user where id = :id";
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("id", 14);
        userDaoImpl.queryForObject(sql, paramMap, Integer.class);
        
//        int ii = userDaoImpl.delete(id);
//        System.out.println("删除条数：" + ii);
        
//        entity.setId(id);
//        i = userDaoImpl.deleteBatch(entity);
//        System.out.println("批量删除实体数：" + i);
        
//        sql = "delete from user where id = ? and age = ?";
//        i = userDaoImpl.deleteBatch(sql, id, 19);
//        System.out.println("批量删除实体数：" + i);
    }
}
