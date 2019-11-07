package com.cqgcxy.online_study_system.entity;

import java.util.List;

/**
 * @Author:32157
 * @DATE:2019/10/28
 * 创建角色实体类
 */
public class Role {

    private Integer role_id;//角色id
    private String role_name;//角色名字
    private Integer status;//角色状态
    private List<Permission> permissions;//用户权限

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
