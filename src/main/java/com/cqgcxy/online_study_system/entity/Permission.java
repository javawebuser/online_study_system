package com.cqgcxy.online_study_system.entity;

/**
 * @Author:32157
 * @DATE:2019/10/28
 * 创建权限实体表
 */
public class Permission {

    private Integer per_id;//权限id
    private String per_name;//权限名字

    public Integer getPer_id() {
        return per_id;
    }

    public void setPer_id(Integer per_id) {
        this.per_id = per_id;
    }

    public String getPer_name() {
        return per_name;
    }

    public void setPer_name(String per_name) {
        this.per_name = per_name;
    }
}
