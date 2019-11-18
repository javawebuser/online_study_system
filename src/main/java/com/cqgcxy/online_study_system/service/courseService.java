package com.cqgcxy.online_study_system.service;

import com.cqgcxy.online_study_system.dao.courseDao;
import com.cqgcxy.online_study_system.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:32157
 * @DATE:2019/11/12
 */
@Service
public class courseService {

    @Autowired
    courseDao courseDao;

    //查询所哟课程
    public List<Course> selectCourse(){
        return courseDao.selectCourse();
    };
    //根据id查询课程
    public Course selectCourseById(int co_id){
      return courseDao.selectCourseById(co_id);
    };
    //插入课程
    public int insertCourse(Course course){
        return courseDao.insertCourse(course);
    };
}
