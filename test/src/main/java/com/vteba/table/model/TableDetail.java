package com.vteba.table.model;

public class TableDetail {
    /**
     * 对应数据库表字段 table_detail.id
     */
    private Long id;

    /**
     * 对应数据库表字段 table_detail.table_index
     */
    private Long tableIndex;

    /**
     * 对应数据库表字段 table_detail.shards_table_id
     */
    private Integer shardsTableId;

    /**
     * 获得字段 table_detail.id 的值
     *
     * @return the value of table_detail.id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置字段 table_detail.id 的值
     *
     * @param id the value for table_detail.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获得字段 table_detail.table_index 的值
     *
     * @return the value of table_detail.table_index
     */
    public Long getTableIndex() {
        return tableIndex;
    }

    /**
     * 设置字段 table_detail.table_index 的值
     *
     * @param tableIndex the value for table_detail.table_index
     */
    public void setTableIndex(Long tableIndex) {
        this.tableIndex = tableIndex;
    }

    /**
     * 获得字段 table_detail.shards_table_id 的值
     *
     * @return the value of table_detail.shards_table_id
     */
    public Integer getShardsTableId() {
        return shardsTableId;
    }

    /**
     * 设置字段 table_detail.shards_table_id 的值
     *
     * @param shardsTableId the value for table_detail.shards_table_id
     */
    public void setShardsTableId(Integer shardsTableId) {
        this.shardsTableId = shardsTableId;
    }
}