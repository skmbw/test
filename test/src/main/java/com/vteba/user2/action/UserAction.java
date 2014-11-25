package com.vteba.user2.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.user2.model.User;
import com.vteba.user2.service.spi.UserService;
import com.vteba.web.action.GenericAction;
import com.vteba.web.action.JsonBean;

/**
 * 系统用户控制器
 * @author yinlei
 * @date 2014-9-18 10:11:32
 */
@Controller
@RequestMapping("/user")
public class UserAction extends GenericAction<User> {
	@Inject
	private UserService userServiceImpl;
	
//	@Inject
//	private SpringJdbcTemplate skmbwJdbcTemplate;
	
	/**
     * 获得系统用户List，初始化列表页。
     * @param model 参数
     * @return 系统用户List
     */
    @RequestMapping("/initial")
    public String initial(User model, Map<String, Object> maps) {
    	List<User> list = userServiceImpl.pagedList(model);
    	// mysql每秒插入记录大约54左右，开启事务。mybatis插入大约30笔，因为uuid消耗了性能
//    	User user = new User();
//    	user.setCompany("IBM232");
//    	user.setPassword("12121");
//    	user.setState(true);
//    	Date date = new Date();
//    	user.setCreateDate(date);
//    	long d = System.currentTimeMillis();
//    	for (int i = 0; i < 100; i++) {
//    		userServiceImpl.save(user);
//    	}
    	
//    	List<Object[]> argsList = new ArrayList<Object[]>();
//    	for (int i = 0; i < 100; i++) {
//    		Object[] args = new Object[5];
//    		args[0] = i;
//    		args[1] = "IBM232";
//    		args[2] = "12121";
//    		args[3] = 1;
//    		args[4] = date;
//    		argsList.add(args);
//    	}
//    	long d = System.currentTimeMillis();
//        
//        String sql = "insert into user(id, company, password, state, create_date) values(?,?,?,?,?)";
//        skmbwJdbcTemplate.batchUpdate(sql, argsList);
//        System.out.println(System.currentTimeMillis() - d);
//        user.setCreateDate(null);
//        userServiceImpl.deleteBulks(user);
        maps.put("list", list);
        return "user/initial";
    }
	
	/**
	 * 获得系统用户List，Json格式。
	 * @param model 参数
	 * @return 系统用户List
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<User> list(User model) {
		List<User> list = userServiceImpl.pagedList(model);
		return list;
	}
	
	/**
     * 根据Id获得系统用户实体，Json格式。
     * @param id 参数id
     * @return 系统用户实体
     */
    @ResponseBody
    @RequestMapping("/get")
    public User get(String id) {
        User model = userServiceImpl.get(id);
        return model;
    }
	
	/**
     * 跳转到新增页面
     * @return 新增页面逻辑视图
     */
    @RequestMapping("/add")
    public String add() {
        return "user/add";
    }
    
    /**
     * 执行实际的新增操作
     * @param model 要新增的数据
     * @return 新增页面逻辑视图
     */
    @ResponseBody
    @RequestMapping("/doAdd")
    public JsonBean doAdd(User model) {
        model.setCreateDate(new Date());
        int result = userServiceImpl.save(model);
        JsonBean bean = new JsonBean();
        if (result == 1) {
            bean.setMessage(SUCCESS);
        } else {
            bean.setCode(1);
            bean.setMessage(ERROR);
        }
        return bean;
    }
    
    /**
     * 查看系统用户详情页。
     * @param model 查询参数，携带ID
     * @return 系统用户详情页
     */
    @RequestMapping("/detail")
    public String detail(User model, Map<String, Object> maps) {
        model = userServiceImpl.get(model.getId());
        maps.put("model", model);//将model放入视图中，供页面视图使用
        return "user/detail";
    }
    
    /**
     * 跳转到编辑信息页面
     * @param model 查询参数，携带ID
     * @return 编辑页面
     */
    @RequestMapping("/edit")
    public String edit(User model, Map<String, Object> maps) {
        model = userServiceImpl.get(model.getId());
        maps.put("model", model);
        return "user/edit";
    }
    
    /**
     * 更新系统用户信息
     * @param model 要更新的系统用户信息，含有ID
     * @return 操作结果信息
     */
    @ResponseBody
    @RequestMapping("/update")
    public JsonBean update(User model) {
        int result = userServiceImpl.updateById(model);
        JsonBean bean = new JsonBean();
        if (result == 1) {
            bean.setMessage(SUCCESS);
        } else {
            bean.setCode(1);
            bean.setMessage(ERROR);
        }
        return bean;
    }
    
    /**
     * 删除系统用户信息
     * @param id 要删除的系统用户ID
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JsonBean delete(String id) {
        int result = userServiceImpl.deleteById(id);
        JsonBean bean = new JsonBean();
        if (result == 1) {
            bean.setMessage(SUCCESS);
        } else {
            bean.setCode(1);
            bean.setMessage(ERROR);
        }
        return bean;
    }
}
