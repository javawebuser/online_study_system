package com.cqgcxy.online_study_system.controller;

import com.cqgcxy.online_study_system.entity.Chapter;
import com.cqgcxy.online_study_system.entity.Course;
import com.cqgcxy.online_study_system.entity.CourseWare;
import com.cqgcxy.online_study_system.entity.ResultMsg;
import com.cqgcxy.online_study_system.service.chapterService;
import com.cqgcxy.online_study_system.service.courseService;
import com.cqgcxy.online_study_system.service.coursewareService;
import com.cqgcxy.online_study_system.service.roleService;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @Author:32157
 * @DATE:2019/11/12
 */
@Controller
public class courseConterlloer {

    @Autowired
    courseService courseService;
    @Autowired
    chapterService chapterService;
    @Autowired
    coursewareService coursewareService;

    //课程列表
    @RequestMapping("/courseIndex")
    public String courseIndex (Model model){
        List<Course> courses = courseService.selectCourse();
        List<Chapter> chapters = chapterService.selectChapter();
        List<CourseWare> courseWares = coursewareService.selectCourseWare();
        model.addAttribute("courses",courses);
        model.addAttribute("chapters",chapters);
        model.addAttribute("courseWares",courseWares);
        return "/management/course/courseIndex";
    }

    //课程添加页面
    @RequestMapping("/courseAdd")
    public ModelAndView courseAdd(){
        ModelAndView view = new ModelAndView("/management/course/courseAdd");
        return view;
    }

    //课程添加页面
    @ResponseBody
    @RequestMapping("/courseAdd_submit")
    public ResultMsg courseAdd_submit( @RequestParam("course") String course,
                                       @RequestParam("coursetime") String coursetime,
                                       @RequestParam("score") String score
                                           ) {
        Course co = new Course();
        co.setCourse(course);
        co.setCoursetime(Integer.parseInt(coursetime));
        co.setScore(Integer.parseInt(score));
        int i = courseService.insertCourse(co);
        if (i == 1) {
            return new ResultMsg(1, "成功");
        } else {
            return new ResultMsg(0, "失败");
        }
    }
}
