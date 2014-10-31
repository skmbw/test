package com.vteba.schema.model;

import java.util.Date;

/**
 * 分区表，应用信息配置（app_info）的实体类。
 * 由代码工具自动生成。
 * @date 2014-10-31 13:58:51
 */
public class AppInfo {
    /**
     * 应用id。app_info.app_id
     */
    private Long appId;

    /**
     * 应用的名字，具有唯一性。app_info.app_name
     */
    private String appName;

    /**
     * 应用描述。app_info.app_desc
     */
    private String appDesc;

    /**
     * 创建时间。app_info.create_date
     */
    private Date createDate;

    /**
     * 更新时间。app_info.update_date
     */
    private Date updateDate;

    /**
     * 数据库是否分表。app_info.shards
     */
    private Boolean shards;

    /**
     * 获得属性，应用id(app_info.app_id)的值
     *
     * @return 属性应用id的值
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 设置属性，应用id(app_info.app_id)的值
     *
     * @param appId 属性应用id的值
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获得属性，应用的名字，具有唯一性(app_info.app_name)的值
     *
     * @return 属性应用的名字，具有唯一性的值
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置属性，应用的名字，具有唯一性(app_info.app_name)的值
     *
     * @param appName 属性应用的名字，具有唯一性的值
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * 获得属性，应用描述(app_info.app_desc)的值
     *
     * @return 属性应用描述的值
     */
    public String getAppDesc() {
        return appDesc;
    }

    /**
     * 设置属性，应用描述(app_info.app_desc)的值
     *
     * @param appDesc 属性应用描述的值
     */
    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    /**
     * 获得属性，创建时间(app_info.create_date)的值
     *
     * @return 属性创建时间的值
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置属性，创建时间(app_info.create_date)的值
     *
     * @param createDate 属性创建时间的值
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获得属性，更新时间(app_info.update_date)的值
     *
     * @return 属性更新时间的值
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置属性，更新时间(app_info.update_date)的值
     *
     * @param updateDate 属性更新时间的值
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获得属性，数据库是否分表(app_info.shards)的值
     *
     * @return 属性数据库是否分表的值
     */
    public Boolean getShards() {
        return shards;
    }

    /**
     * 设置属性，数据库是否分表(app_info.shards)的值
     *
     * @param shards 属性数据库是否分表的值
     */
    public void setShards(Boolean shards) {
        this.shards = shards;
    }
}