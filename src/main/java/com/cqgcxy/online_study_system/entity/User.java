package com.cqgcxy.online_study_system.entity;

/**
 * @Author:chenlong
 * @DATE:2019/10/28
 * 创建用户类
 */
public class User {

    private Integer user_id;//用户id
    private String username;//用户名
    private String password;//用户密码
    private Integer role_id;//角色id

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}