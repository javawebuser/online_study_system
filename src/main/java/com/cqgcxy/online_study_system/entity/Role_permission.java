package com.cqgcxy.online_study_system.entity;

/**
 * @Author:32157
 * @DATE:2019/10/28
 * 创建角色权限实体类
 */
public class Role_permission {

    private Integer Id;//id
    private Integer role_id;//角色id
    private Integer per_id;//权限id

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getPer_id() {
        return per_id;
    }

    public void setPer_id(Integer per_id) {
        this.per_id = per_id;
    }
}
