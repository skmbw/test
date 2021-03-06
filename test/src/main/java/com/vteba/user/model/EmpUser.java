package com.vteba.user.model;

public class EmpUser {
    private String userName;
    private Integer age;
    
    public EmpUser() {
        super();
    }

    public EmpUser(String userName, Integer age) {
        super();
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
}
