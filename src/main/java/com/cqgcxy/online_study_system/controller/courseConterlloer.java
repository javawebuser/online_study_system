package com.cqgcxy.online_study_system.controller;

import com.cqgcxy.online_study_system.entity.*;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        model.addAttribute("courses",courses);
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

    //课程学习
    @RequestMapping("/studentCourse")
    public String studentCourse(@RequestParam("co_id") String co_id, Model model, HttpServletRequest httpRequest) {
        HttpSession session = httpRequest.getSession();
        User user = (User)session.getAttribute("user");
        if (session.getAttribute("user")!=null){
            model.addAttribute("user",user);
            System.out.println(user.getUsername());
            model.addAttribute("course",courseService.selectCourseById(Integer.parseInt(co_id)));
            return "student/studentCourseIndex";
        }else{
            return "login";
        }
    }
}
