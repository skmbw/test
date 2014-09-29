package com.vteba.table.dao;

import com.vteba.service.tenant.annotation.Schema;
import com.vteba.table.model.TableDetail;
import com.vteba.tx.jdbc.mybatis.annotation.DaoMapper;
import com.vteba.tx.jdbc.params.DeleteBean;
import com.vteba.tx.jdbc.params.QueryBean;
import com.vteba.tx.jdbc.params.UpdateBean;

import java.util.List;

/**
 * 分区表table_detail的MyBatis Dao Mapper。
 * 由代码工具自动生成，可以新增方法，但是不要修改自动生成的方法。
 * @date 2014-09-22 13:53:26
 */
@DaoMapper
@Schema(schemaName = "skmbw")
public interface TableDetailDao {
    /**
     * 根据params所携带条件进行count计数。
     * @param params 查询条件
     */
    int count(QueryBean params);

    /**
     * 根据params所携带条件进行计数，条件是等于，且是and关系。
     * @param params 查询条件
     */
    int countBy(QueryBean params);

    /**
     * 根据params所携带条件删除记录，适用于复杂条件。
     * @param params 查询条件
     */
    int deleteBatch(DeleteBean params);

    /**
     * 根据params所携带条件删除数据，条件是等于，且是and关系。
     * @param params 删除条件
     */
    int deleteBulks(DeleteBean params);

    /**
     * 根据主键删除记录。
     * @param id 主键id
     */
    int deleteById(Long id);

    /**
     * 插入记录，只有非空字段才会插入到数据库。
     * @param record 要被保存的数据
     */
    int save(TableDetail record);

    /**
     * 根据params所携带条件查询数据，适用于复杂查询。
     * @param params 查询条件
     */
    List<TableDetail> queryForList(QueryBean params);

    /**
     * 根据params所携带条件查询数据，条件是等于，且是and关系。
     * @param params 查询条件
     */
    List<TableDetail> queryList(QueryBean params);

    /**
     * 根据params所携带条件分页查询数据，适用于复杂查询。
     * @param params 查询条件
     */
    List<TableDetail> pagedForList(QueryBean params);

    /**
     * 根据params所携带条件分页查询数据，条件是等于，且是and关系。
     * @param params 查询条件
     */
    List<TableDetail> pagedList(QueryBean params);

    /**
     * 根据主键查询数据。
     * @param id 主键
     */
    TableDetail get(Long id);

    /**
     * 根据params所携带条件更新指定字段，适用于复杂条件。
     * @param params update的where条件，以及定位分区表的条件
     */
    int updateBatch(UpdateBean params);

    /**
     * 根据params所携带条件更新指定字段，条件是等于，且是and关系。
     * @param params update的where条件，以及定位分区表的条件
     */
    int updateBulks(UpdateBean params);

    /**
     * 根据主键更新指定字段的数据。
     * @param params update的where条件，以及定位分区表的条件
     */
    int updateById(UpdateBean params);
}