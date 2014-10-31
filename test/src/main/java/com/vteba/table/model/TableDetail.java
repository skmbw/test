package com.vteba.table.model;

/**
 * 分区表，分区表明细信息，一个分区表下共有几个表（table_detail）的实体类。
 * 由代码工具自动生成。
 * @date 2014-10-31 15:51:24
 */
public class TableDetail {
    /**
     * 。table_detail.id
     */
    private Long id;

    /**
     * 。table_detail.table_index
     */
    private Long tableIndex;

    /**
     * 。table_detail.shards_table_id
     */
    private Integer shardsTableId;

    /**
     * 获得属性，(table_detail.id)的值
     *
     * @return 属性的值
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置属性，(table_detail.id)的值
     *
     * @param id 属性的值
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获得属性，(table_detail.table_index)的值
     *
     * @return 属性的值
     */
    public Long getTableIndex() {
        return tableIndex;
    }

    /**
     * 设置属性，(table_detail.table_index)的值
     *
     * @param tableIndex 属性的值
     */
    public void setTableIndex(Long tableIndex) {
        this.tableIndex = tableIndex;
    }

    /**
     * 获得属性，(table_detail.shards_table_id)的值
     *
     * @return 属性的值
     */
    public Integer getShardsTableId() {
        return shardsTableId;
    }

    /**
     * 设置属性，(table_detail.shards_table_id)的值
     *
     * @param shardsTableId 属性的值
     */
    public void setShardsTableId(Integer shardsTableId) {
        this.shardsTableId = shardsTableId;
    }
}