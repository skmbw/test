package com.vteba.table.action;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.table.model.TableDetail;
import com.vteba.table.service.spi.TableDetailService;

import com.vteba.tx.jdbc.params.QueryBean;
import com.vteba.tx.jdbc.params.UpdateBean;
import com.vteba.web.action.GenericAction;
import com.vteba.web.action.JsonBean;

/**
 * 分区表明细信息控制器
 * @author yinlei
 * @date 2014-10-31 15:51:23
 */
@Controller
@RequestMapping("/tableDetail")
public class TableDetailAction extends GenericAction<TableDetail> {
	@Inject
	private TableDetailService tableDetailServiceImpl;
	
	/**
     * 获得分区表明细信息List，初始化列表页。
     * @param model 参数
     * @return 分区表明细信息List
     */
    @RequestMapping("/initial")
    public String initial(TableDetail model, Map<String, Object> maps) {
    	QueryBean params = new QueryBean();
    	params.setParams(model);
        List<TableDetail> list = tableDetailServiceImpl.pagedList(params);
        maps.put("list", list);
        return "tableDetail/initial";
    }
	
	/**
	 * 获得分区表明细信息List，Json格式。
	 * @param model 参数
	 * @return 分区表明细信息List
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<TableDetail> list(TableDetail model) {
		QueryBean params = new QueryBean();
    	params.setParams(model);
		List<TableDetail> list = tableDetailServiceImpl.pagedList(params);
		return list;
	}
	
	/**
     * 根据Id获得分区表明细信息实体，Json格式。
     * @param id 参数id
     * @return 分区表明细信息实体
     */
    @ResponseBody
    @RequestMapping("/get")
    public TableDetail get(Long id) {
        TableDetail model = tableDetailServiceImpl.get(id);
        return model;
    }
	
	/**
     * 跳转到新增页面
     * @return 新增页面逻辑视图
     */
    @RequestMapping("/add")
    public String add() {
        return "tableDetail/add";
    }
    
    /**
     * 执行实际的新增操作
     * @param model 要新增的数据
     * @return 新增页面逻辑视图
     */
    @ResponseBody
    @RequestMapping("/doAdd")
    public JsonBean doAdd(TableDetail model) {
        int result = tableDetailServiceImpl.save(model);
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
     * 查看分区表明细信息详情页。
     * @param model 查询参数，携带ID
     * @return 分区表明细信息详情页
     */
    @RequestMapping("/detail")
    public String detail(TableDetail model, Map<String, Object> maps) {
        model = tableDetailServiceImpl.get(model.getId());
        maps.put("model", model);//将model放入视图中，供页面视图使用
        return "tableDetail/detail";
    }
    
    /**
     * 跳转到编辑信息页面
     * @param model 查询参数，携带ID
     * @return 编辑页面
     */
    @RequestMapping("/edit")
    public String edit(TableDetail model, Map<String, Object> maps) {
        model = tableDetailServiceImpl.get(model.getId());
        maps.put("model", model);
        return "tableDetail/edit";
    }
    
    /**
     * 更新分区表明细信息信息
     * @param model 要更新的分区表明细信息信息，含有ID
     * @return 操作结果信息
     */
    @ResponseBody
    @RequestMapping("/update")
    public JsonBean update(TableDetail model) {
    	UpdateBean updateBean = new UpdateBean();
    	updateBean.setRecord(model);
        int result = tableDetailServiceImpl.updateById(updateBean);
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
     * 删除分区表明细信息信息
     * @param id 要删除的分区表明细信息ID
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JsonBean delete(Long id) {
        int result = tableDetailServiceImpl.deleteById(id);
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
