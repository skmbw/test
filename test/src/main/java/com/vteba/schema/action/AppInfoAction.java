package com.vteba.schema.action;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.schema.model.AppInfo;
import com.vteba.schema.service.spi.AppInfoService;

import com.vteba.tx.jdbc.params.QueryBean;
import com.vteba.tx.jdbc.params.UpdateBean;
import com.vteba.web.action.GenericAction;
import com.vteba.web.action.JsonBean;

/**
 * 应用配置信息控制器
 * @author yinlei
 * @date 2014-10-11 14:51:55
 */
@Controller
@RequestMapping("/appInfo")
public class AppInfoAction extends GenericAction<AppInfo> {
	@Inject
	private AppInfoService appInfoServiceImpl;
	
	/**
     * 获得应用配置信息List，初始化列表页。
     * @param model 参数
     * @return 应用配置信息List
     */
    @RequestMapping("/initial")
    public String initial(AppInfo model, Map<String, Object> maps) {
    	QueryBean params = new QueryBean();
    	params.setParams(model);
        List<AppInfo> list = appInfoServiceImpl.pagedList(params);
        maps.put("list", list);
        return "appInfo/initial";
    }
	
	/**
	 * 获得应用配置信息List，Json格式。
	 * @param model 参数
	 * @return 应用配置信息List
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<AppInfo> list(AppInfo model) {
		QueryBean params = new QueryBean();
    	params.setParams(model);
		List<AppInfo> list = appInfoServiceImpl.pagedList(params);
		return list;
	}
	
	/**
     * 根据Id获得应用配置信息实体，Json格式。
     * @param id 参数id
     * @return 应用配置信息实体
     */
    @ResponseBody
    @RequestMapping("/get")
    public AppInfo get(Long id) {
        AppInfo model = appInfoServiceImpl.get(id);
        return model;
    }
	
	/**
     * 跳转到新增页面
     * @return 新增页面逻辑视图
     */
    @RequestMapping("/add")
    public String add() {
        return "appInfo/add";
    }
    
    /**
     * 执行实际的新增操作
     * @param model 要新增的数据
     * @return 新增页面逻辑视图
     */
    @ResponseBody
    @RequestMapping("/doAdd")
    public JsonBean doAdd(AppInfo model) {
        int result = appInfoServiceImpl.save(model);
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
     * 查看应用配置信息详情页。
     * @param model 查询参数，携带ID
     * @return 应用配置信息详情页
     */
    @RequestMapping("/detail")
    public String detail(AppInfo model, Map<String, Object> maps) {
        model = appInfoServiceImpl.get(model.getAppId());
        maps.put("model", model);//将model放入视图中，供页面视图使用
        return "appInfo/detail";
    }
    
    /**
     * 跳转到编辑信息页面
     * @param model 查询参数，携带ID
     * @return 编辑页面
     */
    @RequestMapping("/edit")
    public String edit(AppInfo model, Map<String, Object> maps) {
        model = appInfoServiceImpl.get(model.getAppId());
        maps.put("model", model);
        return "appInfo/edit";
    }
    
    /**
     * 更新应用配置信息信息
     * @param model 要更新的应用配置信息信息，含有ID
     * @return 操作结果信息
     */
    @ResponseBody
    @RequestMapping("/update")
    public JsonBean update(AppInfo model) {
    	UpdateBean updateBean = new UpdateBean();
    	updateBean.setParams(model);
        int result = appInfoServiceImpl.updateById(updateBean);
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
     * 删除应用配置信息信息
     * @param id 要删除的应用配置信息ID
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JsonBean delete(Long id) {
        int result = appInfoServiceImpl.deleteById(id);
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
