package com.vteba.table.model;

import java.util.Date;

public class ShardsTable {
    /**
     * 对应数据库表字段 shards_table.id
     */
    private Integer id;

    /**
     * 对应数据库表字段 shards_table.schema_name
     */
    private String schemaName;

    /**
     * 对应数据库表字段 shards_table.schema_id
     */
    private Long schemaId;

    /**
     * 对应数据库表字段 shards_table.table_name
     */
    private String tableName;

    /**
     * 对应数据库表字段 shards_table.current_table
     */
    private String currentTable;

    /**
     * 对应数据库表字段 shards_table.strategy
     */
    private String strategy;

    /**
     * 对应数据库表字段 shards_table.from_index
     */
    private Long fromIndex;

    /**
     * 对应数据库表字段 shards_table.end_index
     */
    private Long endIndex;

    /**
     * 对应数据库表字段 shards_table.create_date
     */
    private Date createDate;

    /**
     * 对应数据库表字段 shards_table.update_date
     */
    private Date updateDate;

    /**
     * 对应数据库表字段 shards_table.create_sql
     */
    private String createSql;

    /**
     * 获得字段 shards_table.id 的值
     *
     * @return the value of shards_table.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置字段 shards_table.id 的值
     *
     * @param id the value for shards_table.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获得字段 shards_table.schema_name 的值
     *
     * @return the value of shards_table.schema_name
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * 设置字段 shards_table.schema_name 的值
     *
     * @param schemaName the value for shards_table.schema_name
     */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    /**
     * 获得字段 shards_table.schema_id 的值
     *
     * @return the value of shards_table.schema_id
     */
    public Long getSchemaId() {
        return schemaId;
    }

    /**
     * 设置字段 shards_table.schema_id 的值
     *
     * @param schemaId the value for shards_table.schema_id
     */
    public void setSchemaId(Long schemaId) {
        this.schemaId = schemaId;
    }

    /**
     * 获得字段 shards_table.table_name 的值
     *
     * @return the value of shards_table.table_name
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置字段 shards_table.table_name 的值
     *
     * @param tableName the value for shards_table.table_name
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 获得字段 shards_table.current_table 的值
     *
     * @return the value of shards_table.current_table
     */
    public String getCurrentTable() {
        return currentTable;
    }

    /**
     * 设置字段 shards_table.current_table 的值
     *
     * @param currentTable the value for shards_table.current_table
     */
    public void setCurrentTable(String currentTable) {
        this.currentTable = currentTable;
    }

    /**
     * 获得字段 shards_table.strategy 的值
     *
     * @return the value of shards_table.strategy
     */
    public String getStrategy() {
        return strategy;
    }

    /**
     * 设置字段 shards_table.strategy 的值
     *
     * @param strategy the value for shards_table.strategy
     */
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    /**
     * 获得字段 shards_table.from_index 的值
     *
     * @return the value of shards_table.from_index
     */
    public Long getFromIndex() {
        return fromIndex;
    }

    /**
     * 设置字段 shards_table.from_index 的值
     *
     * @param fromIndex the value for shards_table.from_index
     */
    public void setFromIndex(Long fromIndex) {
        this.fromIndex = fromIndex;
    }

    /**
     * 获得字段 shards_table.end_index 的值
     *
     * @return the value of shards_table.end_index
     */
    public Long getEndIndex() {
        return endIndex;
    }

    /**
     * 设置字段 shards_table.end_index 的值
     *
     * @param endIndex the value for shards_table.end_index
     */
    public void setEndIndex(Long endIndex) {
        this.endIndex = endIndex;
    }

    /**
     * 获得字段 shards_table.create_date 的值
     *
     * @return the value of shards_table.create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置字段 shards_table.create_date 的值
     *
     * @param createDate the value for shards_table.create_date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获得字段 shards_table.update_date 的值
     *
     * @return the value of shards_table.update_date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置字段 shards_table.update_date 的值
     *
     * @param updateDate the value for shards_table.update_date
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获得字段 shards_table.create_sql 的值
     *
     * @return the value of shards_table.create_sql
     */
    public String getCreateSql() {
        return createSql;
    }

    /**
     * 设置字段 shards_table.create_sql 的值
     *
     * @param createSql the value for shards_table.create_sql
     */
    public void setCreateSql(String createSql) {
        this.createSql = createSql;
    }
}