package com.cqgcxy.online_study_system.service;

import com.cqgcxy.online_study_system.dao.coursewareDao;
import com.cqgcxy.online_study_system.entity.CourseWare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:32157
 * @DATE:2019/11/12
 */
@Service
public class coursewareService {

    @Autowired
    coursewareDao coursewareDao;
    //查询所有课件
    public List<CourseWare> selectCourseWare(){
        return coursewareDao.selectCourseWare();
    };
    //根据章节插入课件
    public int insertCourseWare(CourseWare courseWare){
        return coursewareDao.insertCourseWare(courseWare);
    };
}
