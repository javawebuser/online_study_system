package com.cqgcxy.online_study_system.entity;

/**
 * @Author:32157
 * @DATE:2019/10/28
 * 创建课程实体类
 */
public class Course {

     private Integer co_id;//课程id
     private String course;//课程名
     private int coursetime;//课时
     private  int score;//课程学分

    public Integer getCo_id() {
        return co_id;
    }

    public void setCo_id(Integer co_id) {
        this.co_id = co_id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(int coursetime) {
        this.coursetime = coursetime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
