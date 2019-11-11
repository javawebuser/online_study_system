package com.cqgcxy.online_study_system.entity;

import java.util.List;

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
    private int status;//用户状态
    private Role role;
    private List<Permission> permission;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Permission> getPermission() {
        return permission;
    }

    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }

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
