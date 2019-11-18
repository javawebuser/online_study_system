package com.cqgcxy.online_study_system.dao;

import com.cqgcxy.online_study_system.entity.Course;
import com.cqgcxy.online_study_system.entity.CourseWare;

import java.util.List;

/**
 * @Author:32157
 * @DATE:2019/11/12
 */
public interface coursewareDao {
    List<CourseWare> selectCourseWare();
    List<CourseWare> selectCourseWareById(int chapter_id);
    int insertCourseWare(CourseWare courseWare);
}
