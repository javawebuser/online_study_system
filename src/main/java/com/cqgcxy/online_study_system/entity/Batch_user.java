package com.cqgcxy.online_study_system.entity;

/**
 * @Author:32157
 * @DATE:2019/10/28
 * 创建批次学生管理类
 */
public class Batch_user {

    private Integer Id;//id
    private Integer batch_id;//批次id
    private Integer user_id;//学生id

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(Integer batch_id) {
        this.batch_id = batch_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
