package com.cqgcxy.online_study_system.dao;

import com.cqgcxy.online_study_system.entity.Course;

import java.util.List;

/**
 * @Author:32157
 * @DATE:2019/11/12
 */
public interface courseDao {
    List<Course> selectCourse();
    Course selectCourseById(int co_id);
    int insertCourse(Course course);
}
