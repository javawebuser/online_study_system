package com.cqgcxy.online_study_system.entity;

import java.sql.Date;
import java.util.List;

/**
 * @Author:32157
 * @DATE:2019/10/28
 * 创建批次管理实体类
 */
public class Batch {

    private Integer batch_id;//批次id
    private Date begintime;//开始时间
    private Date endtime;//结束时间
    private List<Course> courses;//课程集合

    public Integer getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(Integer batch_id) {
        this.batch_id = batch_id;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
