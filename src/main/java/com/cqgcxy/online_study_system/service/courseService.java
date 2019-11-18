package com.cqgcxy.online_study_system.service;

import com.cqgcxy.online_study_system.dao.chapterDao;
import com.cqgcxy.online_study_system.dao.courseDao;
import com.cqgcxy.online_study_system.dao.coursewareDao;
import com.cqgcxy.online_study_system.entity.Chapter;
import com.cqgcxy.online_study_system.entity.Course;
import com.cqgcxy.online_study_system.entity.CourseWare;
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
    @Autowired
    chapterDao chapterDao;
    @Autowired
    coursewareDao coursewareDao;

    //查询所哟课程
    public List<Course> selectCourse(){
        List<Course> courses = courseDao.selectCourse();
        for (Course course : courses){
            List<Chapter> chapters = chapterDao.selectChapterById(course.getCo_id());
            for (Chapter chapter : chapters){
                List<CourseWare> courseWares = coursewareDao.selectCourseWareById(chapter.getChapter_id());
                chapter.setCourseWares(courseWares);
            }
            course.setChapters(chapters);
        }
        return courses;
    };
    //根据id查询课程
    public Course selectCourseById(int co_id){
        Course course = courseDao.selectCourseById(co_id);
        List<Chapter> chapters = chapterDao.selectChapterById(course.getCo_id());
        for (Chapter chapter : chapters){
            List<CourseWare> courseWares = coursewareDao.selectCourseWareById(chapter.getChapter_id());
            chapter.setCourseWares(courseWares);
        }
        course.setChapters(chapters);
        return course;
    };
    //插入课程
    public int insertCourse(Course course){
        return courseDao.insertCourse(course);
    };
}
