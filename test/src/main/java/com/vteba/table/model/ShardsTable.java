package com.vteba.table.model;

import java.util.Date;
import java.util.List;

import com.vteba.tx.matrix.info.ShardsTables;

/**
 * 分区表，schema下的分区表配置（shards_table）的实体类。
 * 由代码工具自动生成。
 * @date 2014-10-31 15:51:24
 */
public class ShardsTable implements ShardsTables {
    /**
     * 主键。shards_table.id
     */
    private Integer id;

    /**
     * table schema。shards_table.schema_name
     */
    private String schemaName;

    /**
     * 。shards_table.schema_id
     */
    private Long schemaId;

    /**
     * 表名。shards_table.table_name
     */
    private String tableName;

    /**
     * 现在的表名。shards_table.current_table
     */
    private String currentTable;

    /**
     * 分区策略。shards_table.strategy
     */
    private String strategy;

    /**
     * 表id开始记录。shards_table.from_index
     */
    private Long fromIndex;

    /**
     * 表id结束记录。shards_table.end_index
     */
    private Long endIndex;

    /**
     * 。shards_table.create_date
     */
    private Date createDate;

    /**
     * 。shards_table.update_date
     */
    private Date updateDate;

    /**
     * 创建表的sql语句。shards_table.create_sql
     */
    private String createSql;

    /**
     * 获得属性，主键(shards_table.id)的值
     *
     * @return 属性主键的值
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置属性，主键(shards_table.id)的值
     *
     * @param id 属性主键的值
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获得属性，table schema(shards_table.schema_name)的值
     *
     * @return 属性table schema的值
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * 设置属性，table schema(shards_table.schema_name)的值
     *
     * @param schemaName 属性table schema的值
     */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    /**
     * 获得属性，(shards_table.schema_id)的值
     *
     * @return 属性的值
     */
    public Long getSchemaId() {
        return schemaId;
    }

    /**
     * 设置属性，(shards_table.schema_id)的值
     *
     * @param schemaId 属性的值
     */
    public void setSchemaId(Long schemaId) {
        this.schemaId = schemaId;
    }

    /**
     * 获得属性，表名(shards_table.table_name)的值
     *
     * @return 属性表名的值
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置属性，表名(shards_table.table_name)的值
     *
     * @param tableName 属性表名的值
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 获得属性，现在的表名(shards_table.current_table)的值
     *
     * @return 属性现在的表名的值
     */
    public String getCurrentTable() {
        return currentTable;
    }

    /**
     * 设置属性，现在的表名(shards_table.current_table)的值
     *
     * @param currentTable 属性现在的表名的值
     */
    public void setCurrentTable(String currentTable) {
        this.currentTable = currentTable;
    }

    /**
     * 获得属性，分区策略(shards_table.strategy)的值
     *
     * @return 属性分区策略的值
     */
    public String getStrategy() {
        return strategy;
    }

    /**
     * 设置属性，分区策略(shards_table.strategy)的值
     *
     * @param strategy 属性分区策略的值
     */
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    /**
     * 获得属性，表id开始记录(shards_table.from_index)的值
     *
     * @return 属性表id开始记录的值
     */
    public Long getFromIndex() {
        return fromIndex;
    }

    /**
     * 设置属性，表id开始记录(shards_table.from_index)的值
     *
     * @param fromIndex 属性表id开始记录的值
     */
    public void setFromIndex(Long fromIndex) {
        this.fromIndex = fromIndex;
    }

    /**
     * 获得属性，表id结束记录(shards_table.end_index)的值
     *
     * @return 属性表id结束记录的值
     */
    public Long getEndIndex() {
        return endIndex;
    }

    /**
     * 设置属性，表id结束记录(shards_table.end_index)的值
     *
     * @param endIndex 属性表id结束记录的值
     */
    public void setEndIndex(Long endIndex) {
        this.endIndex = endIndex;
    }

    /**
     * 获得属性，(shards_table.create_date)的值
     *
     * @return 属性的值
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置属性，(shards_table.create_date)的值
     *
     * @param createDate 属性的值
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获得属性，(shards_table.update_date)的值
     *
     * @return 属性的值
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置属性，(shards_table.update_date)的值
     *
     * @param updateDate 属性的值
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获得属性，创建表的sql语句(shards_table.create_sql)的值
     *
     * @return 属性创建表的sql语句的值
     */
    public String getCreateSql() {
        return createSql;
    }

    /**
     * 设置属性，创建表的sql语句(shards_table.create_sql)的值
     *
     * @param createSql 属性创建表的sql语句的值
     */
    public void setCreateSql(String createSql) {
        this.createSql = createSql;
    }

	@Override
	public List<Long> getTableIndexList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTableIndexList(List<Long> tableIndexList) {
		// TODO Auto-generated method stub
		
	}
}