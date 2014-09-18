package com.vteba.user2.model;

import java.util.Date;

public class User {
    /**
     * order by 排序语句
     * 对应数据库表字段 user
     *
     * @date 2014-09-18 10:08:50
     */
    protected String orderBy;

    /**
     * 分页开始记录
     * 对应数据库表字段 user
     *
     * @date 2014-09-18 10:08:50
     */
    protected int start;

    /**
     * 分页大小
     * 对应数据库表字段 user
     *
     * @date 2014-09-18 10:08:50
     */
    protected int pageSize = 10;

    /**
     * 是否去重
     * 对应数据库表字段 user
     *
     * @date 2014-09-18 10:08:50
     */
    protected boolean distinct;

    /**
     * 对应数据库表字段 user.id
     *
     * @date 2014-09-18 10:08:50
     */
    private String id;

    /**
     * 对应数据库表字段 user.user_name
     *
     * @date 2014-09-18 10:08:50
     */
    private String userName;

    /**
     * 对应数据库表字段 user.user_account
     *
     * @date 2014-09-18 10:08:50
     */
    private String userAccount;

    /**
     * 对应数据库表字段 user.super_admin
     *
     * @date 2014-09-18 10:08:50
     */
    private String superAdmin;

    /**
     * 对应数据库表字段 user.telephone
     *
     * @date 2014-09-18 10:08:50
     */
    private String telephone;

    /**
     * 对应数据库表字段 user.mobile_phone
     *
     * @date 2014-09-18 10:08:50
     */
    private String mobilePhone;

    /**
     * 对应数据库表字段 user.company
     *
     * @date 2014-09-18 10:08:50
     */
    private String company;

    /**
     * 对应数据库表字段 user.password
     *
     * @date 2014-09-18 10:08:50
     */
    private String password;

    /**
     * 对应数据库表字段 user.create_date
     *
     * @date 2014-09-18 10:08:50
     */
    private Date createDate;

    /**
     * 对应数据库表字段 user.state
     *
     * @date 2014-09-18 10:08:50
     */
    private Boolean state;

    /**
     * 设置 order by 排序语句
     *
     * @date 2014-09-18 10:08:50
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 获得 order by 排序语句
     *
     * @date 2014-09-18 10:08:50
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 设置 start，分页开始记录
     *
     * @date 2014-09-18 10:08:50
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 获得 start，分页开始记录
     *
     * @date 2014-09-18 10:08:50
     */
    public int getStart() {
        return start;
    }

    /**
     * 设置 pageSize，分页大小
     *
     * @date 2014-09-18 10:08:50
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获得 pageSize，分页大小
     *
     * @date 2014-09-18 10:08:50
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置 distinct，是否去重
     *
     * @date 2014-09-18 10:08:50
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 获得 distinct，是否去重
     *
     * @date 2014-09-18 10:08:50
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 获得字段 user.id 的值
     *
     * @return the value of user.id
     *
     * @date 2014-09-18 10:08:50
     */
    public String getId() {
        return id;
    }

    /**
     * 设置字段 user.id 的值
     *
     * @param id the value for user.id
     *
     * @date 2014-09-18 10:08:50
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获得字段 user.user_name 的值
     *
     * @return the value of user.user_name
     *
     * @date 2014-09-18 10:08:50
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置字段 user.user_name 的值
     *
     * @param userName the value for user.user_name
     *
     * @date 2014-09-18 10:08:50
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获得字段 user.user_account 的值
     *
     * @return the value of user.user_account
     *
     * @date 2014-09-18 10:08:50
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 设置字段 user.user_account 的值
     *
     * @param userAccount the value for user.user_account
     *
     * @date 2014-09-18 10:08:50
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 获得字段 user.super_admin 的值
     *
     * @return the value of user.super_admin
     *
     * @date 2014-09-18 10:08:50
     */
    public String getSuperAdmin() {
        return superAdmin;
    }

    /**
     * 设置字段 user.super_admin 的值
     *
     * @param superAdmin the value for user.super_admin
     *
     * @date 2014-09-18 10:08:50
     */
    public void setSuperAdmin(String superAdmin) {
        this.superAdmin = superAdmin;
    }

    /**
     * 获得字段 user.telephone 的值
     *
     * @return the value of user.telephone
     *
     * @date 2014-09-18 10:08:50
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置字段 user.telephone 的值
     *
     * @param telephone the value for user.telephone
     *
     * @date 2014-09-18 10:08:50
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获得字段 user.mobile_phone 的值
     *
     * @return the value of user.mobile_phone
     *
     * @date 2014-09-18 10:08:50
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置字段 user.mobile_phone 的值
     *
     * @param mobilePhone the value for user.mobile_phone
     *
     * @date 2014-09-18 10:08:50
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 获得字段 user.company 的值
     *
     * @return the value of user.company
     *
     * @date 2014-09-18 10:08:50
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置字段 user.company 的值
     *
     * @param company the value for user.company
     *
     * @date 2014-09-18 10:08:50
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获得字段 user.password 的值
     *
     * @return the value of user.password
     *
     * @date 2014-09-18 10:08:50
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置字段 user.password 的值
     *
     * @param password the value for user.password
     *
     * @date 2014-09-18 10:08:50
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获得字段 user.create_date 的值
     *
     * @return the value of user.create_date
     *
     * @date 2014-09-18 10:08:50
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置字段 user.create_date 的值
     *
     * @param createDate the value for user.create_date
     *
     * @date 2014-09-18 10:08:50
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获得字段 user.state 的值
     *
     * @return the value of user.state
     *
     * @date 2014-09-18 10:08:50
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置字段 user.state 的值
     *
     * @param state the value for user.state
     *
     * @date 2014-09-18 10:08:50
     */
    public void setState(Boolean state) {
        this.state = state;
    }
}