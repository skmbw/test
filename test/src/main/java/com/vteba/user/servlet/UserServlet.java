package com.vteba.user.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.collect.Maps;
import com.vteba.tx.generic.Order;
import com.vteba.tx.generic.Page;
import com.vteba.tx.jdbc.sequence.KeyGenerator;
import com.vteba.user.dao.IUserDao;
import com.vteba.user.dao.UserDao;
import com.vteba.user.model.User;
import com.vteba.utils.ofbiz.LangUtils;
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
    
    @Autowired
    private IUserDao iuserDaoImpl;
    
    @Autowired
    private KeyGenerator singleTableGenerator;
    
    public void servlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String incre = singleTableGenerator.nextString();
        System.out.println(incre);
        
        
        String userName = request.getParameter("userName");
        System.out.println(userName);
        User user = new User();
        user.setAge(14);
        user.setEmail("email@126.com");
        user.setPassword("123456");
        user.setState(true);
        user.setUserName("yinlei");
        long dd = System.currentTimeMillis();
        long id = userDaoImpl.save(user);
        System.out.println("save时间：" + (System.currentTimeMillis() - dd));
        //System.out.println(id);
        
        long dd2 = System.currentTimeMillis();
        user = userDaoImpl.get(id);
        System.out.println("get时间：" + (System.currentTimeMillis() - dd2));
        //System.out.println(user);
        
        user = userDaoImpl.unique(user);
        //System.out.println(user);
        
        User entity = new User();
        entity.setId(id);
        entity.setAge(19);
        entity.setEmail("yinlei@126.com");
        long d = System.currentTimeMillis();
        int i = userDaoImpl.update(entity);
        System.out.println("update时间：" + (System.currentTimeMillis() - d));
        System.out.println("更新条数：" + i);
        
        User criteria = new User();
        criteria.setId(5L);
        entity.setId(null);
        long d1 = System.currentTimeMillis();
        i = userDaoImpl.updateBatch(entity, criteria);
        System.out.println("updateBatch时间：" + (System.currentTimeMillis() - d1));
        //System.out.println("updateBatch：" + i);
        
        Page<User> page = new Page<User>();
//        Map<String, String> orders = Maps.newHashMap();
//        orders.put("user_name", "desc");
//        orders.put("email", "asc");
        page.setOrders(LangUtils.toMap("user_name", Order.DESC, "email", Order.ASC));
        
        User params = new User();
        params.setAge(14);
        params.setState(true);
        long d2 = System.currentTimeMillis();
        page = userDaoImpl.queryForPage(page, params);
        System.out.println("queryForPage时间：" + (System.currentTimeMillis() - d2));
        //System.out.println(page);
        
        String sql = "select * from user where age = ? and state = 1";
        userDaoImpl.queryForPage(page, sql, 14);
        
        userDaoImpl.query(sql, 14);
        long d3 = System.currentTimeMillis();
        userDaoImpl.query(params);
        System.out.println("query时间：" + (System.currentTimeMillis() - d3));
        sql = "select * from user where age = :age and state = 1";;
        userDaoImpl.query(sql, params);
        
        long d4 = System.currentTimeMillis();
        userDaoImpl.queryList(sql, params);
        System.out.println("queryList时间：" + (System.currentTimeMillis() - d4));
        userDaoImpl.queryPageList(page, sql, params);
        
        sql = "select * from user where age = ? and state = 1";
        userDaoImpl.queryPageList(page, sql, User.class, 14);
        
        sql = "select age from user where id = ?";
        userDaoImpl.queryForObject(sql, Integer.class, 3);
        
        sql = "select age from user where id = :id";
        long d5 = System.currentTimeMillis();
        userDaoImpl.queryForObject(sql, LangUtils.toMap("id", 14), Integer.class);
        System.out.println("queryForObject时间：" + (System.currentTimeMillis() - d5));
//        int ii = userDaoImpl.delete(id);
//        System.out.println("删除条数：" + ii);
        
//        entity.setId(id);
//        i = userDaoImpl.deleteBatch(entity);
//        System.out.println("批量删除实体数：" + i);
        
//        sql = "delete from user where id = ? and age = ?";
//        i = userDaoImpl.deleteBatch(sql, id, 19);
//        System.out.println("批量删除实体数：" + i);
        
//        String hql = "select a.userName, a.age from User a ";
//        IUserDaoImpl real = (IUserDaoImpl) iuserDaoImpl;
//        real.getListByHql(hql, EmpUser.class);
        
        iuserDaoImpl.getEntityList(LangUtils.toMap("userName", "yinlei"));
        
        User user2 = new User();
        user2.setUserName("yinlei");
        iuserDaoImpl.getEntityList(params);
        
        iuserDaoImpl.getEntityList("userName", "yinlei");
        
        iuserDaoImpl.getEntityList(LangUtils.toMap("userName", "yinlei"), LangUtils.toMap("userName", "desc"));
        
        iuserDaoImpl.getEntityList(user2, LangUtils.toMap("userName", "asc", "age", "desc"));
        
        iuserDaoImpl.getEntityList("userName", "yinlei", "age", 15, LangUtils.toMap("userName", "asc", "age", "desc"));
        
        iuserDaoImpl.queryForPage(page, params);
        
        iuserDaoImpl.queryForPage(page, user2);
        
        User user3 = new User();
        user3.setId(1232L);
        iuserDaoImpl.deleteBatch(user3);
        
        iuserDaoImpl.deleteBatch(LangUtils.toMap("id", 567L));
        
        User user4 = new User();
        user4.setId(12L);
        iuserDaoImpl.uniqueResult(user4);
        
        iuserDaoImpl.uniqueResult(LangUtils.toMap("id", 51116L));
        
        iuserDaoImpl.uniqueResult("id", 313L);
        
        User setValue = new User();
        setValue.setUserName("OK");
        setValue.setAge(23);
        iuserDaoImpl.updateBatch(setValue, user3);
        
        iuserDaoImpl.updateBatch(setValue, LangUtils.toMap("id", 33L));
        
        iuserDaoImpl.pagedQueryList(page, params);
        
        iuserDaoImpl.pagedQueryList(page, LangUtils.toMap("userName", "yinlei"));
        
        iuserDaoImpl.getListByLike("userName", "yin");
        iuserDaoImpl.getListByLike(setValue);
        iuserDaoImpl.getListByLike(setValue, LangUtils.toMap("userName", "desc"));
        
//        IUserDaoImpl real = (IUserDaoImpl)iuserDaoImpl;
//        String hql = "select sum(User.age) count from User User";
//        real.hqlQueryForObject(hql, Integer.class);
    }
    
    public static void main(String[] a) {
        Map<String, String> map = Maps.newHashMap();
        
        putMap(map);
    }
    
    public static void putMap(Map<String, ?> map) {
        //map.put("", 2L);
    }
}
