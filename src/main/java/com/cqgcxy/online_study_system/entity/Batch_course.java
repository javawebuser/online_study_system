package com.cqgcxy.online_study_system.entity;

/**
 * @Author:32157
 * @DATE:2019/10/28
 * 创建批次课程实体类
 */
public class Batch_course {

    private Integer Id;//id
    private Integer batch_id;//批次id
    private Integer co_id;//课程id

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

    public Integer getCo_id() {
        return co_id;
    }

    public void setCo_id(Integer co_id) {
        this.co_id = co_id;
    }
}
