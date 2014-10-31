package com.vteba.table.service.spi;

import java.util.List;

import com.vteba.tx.jdbc.params.DeleteBean;
import com.vteba.tx.jdbc.params.QueryBean;
import com.vteba.tx.jdbc.params.UpdateBean;

import com.vteba.table.model.TableDetail;

/**
 * 分区表明细信息相关的业务service接口。
 * @author yinlei
 * @date 2014-10-31 15:51:23
 */
public interface TableDetailService {

    /**
     * 根据params所携带条件进行count计数，适用于复杂条件。请设置QueryBean中keyValue（优先级高），定位分区表。<br>
     * 或者设置QueryBean中的startDate和endDate定位分区表。
     * @param params 查询条件，QueryBean中的params应该是MyBatis生成的条件查询Bean
     * @return 统计的记录条数
     */
    public int count(QueryBean params);

    /**
     * 根据params所携带条件进行计数，条件是等于，且是and关系。请设置QueryBean中keyValue（优先级高），定位分区表。<br>
     * 或者设置QueryBean中的startDate和endDate定位分区表。
     * @param params 查询条件，QueryBean中的params应该是实体类POJO
     * @return 统计的记录条数
     */
    public int countBy(QueryBean params);

    /**
     * 根据params所携带条件删除记录，适用于复杂条件。请设置DeleteBean中keyValue（优先级高），定位分区表。<br>
     * 或者设置DeleteBean中的startDate和endDate定位分区表。
     * @param params 删除条件，DeleteBean中的params应该是MyBatis生成的条件查询Bean
     * @return 删除的记录条数
     */
    public int deleteBatch(DeleteBean params);

    /**
     * 根据params所携带条件删除数据，条件是等于，且是and关系。请设置DeleteBean中keyValue（优先级高），定位分区表。<br>
     * 或者设置DeleteBean中的startDate和endDate定位分区表。
     * @param params 删除条件，DeleteBean中的params应该是实体类POJO
     * @return 删除的记录条数
     */
    public int deleteBulks(DeleteBean params);

    /**
     * 根据主键删除记录。
     * @param id 主键id
     * @return 删除的记录条数，1或0
     */
    public int deleteById(Long id);

    /**
     * 插入记录，只有非空字段才会插入到数据库。
     * @param record 要被保存的数据
     * @return 保存成功的记录条数，1或0
     */
    public int save(TableDetail record);

    /**
     * 根据params所携带条件查询数据，适用于复杂查询。请设置QueryBean中keyValue（优先级高），定位分区表。<br>
     * 或者设置QueryBean中的startDate和endDate定位分区表。
     * @param params 查询条件，QueryBean中的params应该是MyBatis生成的条件查询Bean
     * @return 分区表明细信息实体list
     */
    public List<TableDetail> queryForList(QueryBean params);

    /**
     * 根据params所携带条件查询数据，条件是等于，且是and关系。请设置QueryBean中keyValue（优先级高），定位分区表。<br>
     * 或者设置QueryBean中的startDate和endDate定位分区表。
     * @param params 查询条件，QueryBean中的params应该是实体类POJO
     * @return 分区表明细信息实体list
     */
    public List<TableDetail> queryList(QueryBean params);

    /**
     * 根据params所携带条件分页查询数据，适用于复杂查询。请设置QueryBean中keyValue（优先级高），定位分区表。<br>
     * 或者设置QueryBean中的startDate和endDate定位分区表。
     * @param params 查询条件，QueryBean中的params应该是MyBatis生成的条件查询Bean
     * @return 分区表明细信息实体list
     */
    public List<TableDetail> pagedForList(QueryBean params);

    /**
     * 根据params所携带条件分页查询数据，条件是等于，且是and关系。请设置QueryBean中keyValue（优先级高），定位分区表。<br>
     * 或者设置QueryBean中的startDate和endDate定位分区表。
     * @param params 查询条件，QueryBean中的params应该是实体类POJO
     * @return 分区表明细信息实体list
     */
    public List<TableDetail> pagedList(QueryBean params);

    /**
     * 根据主键查询数据。
     * @param id 主键
     * @return 分区表明细信息实体
     */
    public TableDetail get(Long id);

    /**
     * 根据params所携带条件更新指定字段，适用于复杂条件。请设置UpdateBean中keyValue（优先级高），定位分区表。<br>
     * 或者设置UpdateBean中的startDate和endDate定位分区表。
     * @param params 更新参数，UpdateBean中的params应该是MyBatis生成的条件查询Bean，record是要更新的实体类数据
     * @return 更新记录条数
     */
    public int updateBatch(UpdateBean params);

    /**
     * 根据params所携带条件更新指定字段，条件是等于，且是and关系。请设置UpdateBean中keyValue（优先级高），定位分区表。<br>
     * 或者设置UpdateBean中的startDate和endDate定位分区表。
     * @param params 更新参数，UpdateBean中的params应该是实体类POJO，record是要更新的实体类数据
     * @return 更新记录条数
     */
    public int updateBulks(UpdateBean params);

    /**
     * 根据主键更新指定字段的数据。请设置UpdateBean中keyValue，定位分区表
     * @param params 更新参数，UpdateBean中的record是要更新的实体类数据
     * @return 更新记录条数
     */
    public int updateById(UpdateBean params);
    
    /**
     * 根据条件查询唯一结果。params参数是实体bean
     * @param params 参数，是简单等于条件
     * @return 唯一结果
     */
    public TableDetail unique(QueryBean params);
    
    /**
     * 根据条件查询唯一结果。
     * @param params 参数，是简单等于条件
     * @return 唯一结果
     */
    public TableDetail unique(TableDetail appInfo);

}
