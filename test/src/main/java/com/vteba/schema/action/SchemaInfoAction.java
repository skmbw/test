package com.vteba.schema.action;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.schema.model.SchemaInfo;
import com.vteba.schema.service.spi.SchemaInfoService;

import com.vteba.tx.jdbc.params.QueryBean;
import com.vteba.tx.jdbc.params.UpdateBean;
import com.vteba.web.action.GenericAction;
import com.vteba.web.action.JsonBean;

/**
 * schema配置信息控制器
 * @author yinlei
 * @date 2014-10-11 14:51:55
 */
@Controller
@RequestMapping("/schemaInfo")
public class SchemaInfoAction extends GenericAction<SchemaInfo> {
	@Inject
	private SchemaInfoService schemaInfoServiceImpl;
	
	/**
     * 获得schema配置信息List，初始化列表页。
     * @param model 参数
     * @return schema配置信息List
     */
    @RequestMapping("/initial")
    public String initial(SchemaInfo model, Map<String, Object> maps) {
    	QueryBean params = new QueryBean();
    	params.setParams(model);
        List<SchemaInfo> list = schemaInfoServiceImpl.pagedList(params);
        maps.put("list", list);
        return "schemaInfo/initial";
    }
	
	/**
	 * 获得schema配置信息List，Json格式。
	 * @param model 参数
	 * @return schema配置信息List
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<SchemaInfo> list(SchemaInfo model) {
		QueryBean params = new QueryBean();
    	params.setParams(model);
		List<SchemaInfo> list = schemaInfoServiceImpl.pagedList(params);
		return list;
	}
	
	/**
     * 根据Id获得schema配置信息实体，Json格式。
     * @param id 参数id
     * @return schema配置信息实体
     */
    @ResponseBody
    @RequestMapping("/get")
    public SchemaInfo get(Long id) {
        SchemaInfo model = schemaInfoServiceImpl.get(id);
        return model;
    }
	
	/**
     * 跳转到新增页面
     * @return 新增页面逻辑视图
     */
    @RequestMapping("/add")
    public String add() {
        return "schemaInfo/add";
    }
    
    /**
     * 执行实际的新增操作
     * @param model 要新增的数据
     * @return 新增页面逻辑视图
     */
    @ResponseBody
    @RequestMapping("/doAdd")
    public JsonBean doAdd(SchemaInfo model) {
        int result = schemaInfoServiceImpl.save(model);
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
     * 查看schema配置信息详情页。
     * @param model 查询参数，携带ID
     * @return schema配置信息详情页
     */
    @RequestMapping("/detail")
    public String detail(SchemaInfo model, Map<String, Object> maps) {
        model = schemaInfoServiceImpl.get(model.getSchemaId());
        maps.put("model", model);//将model放入视图中，供页面视图使用
        return "schemaInfo/detail";
    }
    
    /**
     * 跳转到编辑信息页面
     * @param model 查询参数，携带ID
     * @return 编辑页面
     */
    @RequestMapping("/edit")
    public String edit(SchemaInfo model, Map<String, Object> maps) {
        model = schemaInfoServiceImpl.get(model.getSchemaId());
        maps.put("model", model);
        return "schemaInfo/edit";
    }
    
    /**
     * 更新schema配置信息信息
     * @param model 要更新的schema配置信息信息，含有ID
     * @return 操作结果信息
     */
    @ResponseBody
    @RequestMapping("/update")
    public JsonBean update(SchemaInfo model) {
    	UpdateBean updateBean = new UpdateBean();
    	updateBean.setRecord(model);
        int result = schemaInfoServiceImpl.updateById(updateBean);
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
     * 删除schema配置信息信息
     * @param id 要删除的schema配置信息ID
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JsonBean delete(Long id) {
        int result = schemaInfoServiceImpl.deleteById(id);
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
     * 根据参数，创建某一个schema的对等schema数据源
     * @param schemaInfo 参数信息，起码有对等的schema name或者id
     * @return 返回消息
     */
    @ResponseBody
    @RequestMapping("/createSchema")
    public JsonBean createSchema(SchemaInfo schemaInfo) {
    	JsonBean bean = new JsonBean();
    	boolean result = schemaInfoServiceImpl.createSchema(schemaInfo);
    	if (result) {
            bean.setMessage(SUCCESS);
        } else {
            bean.setCode(1);
            bean.setMessage(ERROR);
        }
        return bean;
    }
}
