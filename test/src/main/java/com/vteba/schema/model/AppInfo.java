package com.vteba.schema.model;

import java.util.Date;

public class AppInfo {
    /**
     * 对应数据库表字段 app_info.app_id
     */
    private Long appId;

    /**
     * 对应数据库表字段 app_info.app_name
     */
    private String appName;

    /**
     * 对应数据库表字段 app_info.app_desc
     */
    private String appDesc;

    /**
     * 对应数据库表字段 app_info.create_date
     */
    private Date createDate;

    /**
     * 对应数据库表字段 app_info.update_date
     */
    private Date updateDate;

    /**
     * 获得字段 app_info.app_id 的值
     *
     * @return the value of app_info.app_id
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 设置字段 app_info.app_id 的值
     *
     * @param appId the value for app_info.app_id
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获得字段 app_info.app_name 的值
     *
     * @return the value of app_info.app_name
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置字段 app_info.app_name 的值
     *
     * @param appName the value for app_info.app_name
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * 获得字段 app_info.app_desc 的值
     *
     * @return the value of app_info.app_desc
     */
    public String getAppDesc() {
        return appDesc;
    }

    /**
     * 设置字段 app_info.app_desc 的值
     *
     * @param appDesc the value for app_info.app_desc
     */
    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    /**
     * 获得字段 app_info.create_date 的值
     *
     * @return the value of app_info.create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置字段 app_info.create_date 的值
     *
     * @param createDate the value for app_info.create_date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获得字段 app_info.update_date 的值
     *
     * @return the value of app_info.update_date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置字段 app_info.update_date 的值
     *
     * @param updateDate the value for app_info.update_date
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}