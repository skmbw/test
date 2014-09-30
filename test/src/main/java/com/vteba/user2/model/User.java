package com.vteba.user2.model;

import java.util.Date;

public class User {
    /**
     * 对应数据库表字段 user.id
     */
    private String id;

    /**
     * 对应数据库表字段 user.user_name
     */
    private String userName;

    /**
     * 对应数据库表字段 user.user_account
     */
    private String userAccount;

    /**
     * 对应数据库表字段 user.super_admin
     */
    private String superAdmin;

    /**
     * 对应数据库表字段 user.telephone
     */
    private String telephone;

    /**
     * 对应数据库表字段 user.mobile_phone
     */
    private String mobilePhone;

    /**
     * 对应数据库表字段 user.company
     */
    private String company;

    /**
     * 对应数据库表字段 user.password
     */
    private String password;

    /**
     * 对应数据库表字段 user.create_date
     */
    private Date createDate;

    /**
     * 对应数据库表字段 user.state
     */
    private Boolean state;

    /**
     * 获得字段 user.id 的值
     *
     * @return the value of user.id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置字段 user.id 的值
     *
     * @param id the value for user.id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获得字段 user.user_name 的值
     *
     * @return the value of user.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置字段 user.user_name 的值
     *
     * @param userName the value for user.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获得字段 user.user_account 的值
     *
     * @return the value of user.user_account
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 设置字段 user.user_account 的值
     *
     * @param userAccount the value for user.user_account
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 获得字段 user.super_admin 的值
     *
     * @return the value of user.super_admin
     */
    public String getSuperAdmin() {
        return superAdmin;
    }

    /**
     * 设置字段 user.super_admin 的值
     *
     * @param superAdmin the value for user.super_admin
     */
    public void setSuperAdmin(String superAdmin) {
        this.superAdmin = superAdmin;
    }

    /**
     * 获得字段 user.telephone 的值
     *
     * @return the value of user.telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置字段 user.telephone 的值
     *
     * @param telephone the value for user.telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获得字段 user.mobile_phone 的值
     *
     * @return the value of user.mobile_phone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置字段 user.mobile_phone 的值
     *
     * @param mobilePhone the value for user.mobile_phone
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 获得字段 user.company 的值
     *
     * @return the value of user.company
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置字段 user.company 的值
     *
     * @param company the value for user.company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获得字段 user.password 的值
     *
     * @return the value of user.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置字段 user.password 的值
     *
     * @param password the value for user.password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获得字段 user.create_date 的值
     *
     * @return the value of user.create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置字段 user.create_date 的值
     *
     * @param createDate the value for user.create_date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获得字段 user.state 的值
     *
     * @return the value of user.state
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置字段 user.state 的值
     *
     * @param state the value for user.state
     */
    public void setState(Boolean state) {
        this.state = state;
    }
}