package com.cqgcxy.online_study_system.controller;

import com.cqgcxy.online_study_system.entity.Chapter;
import com.cqgcxy.online_study_system.entity.CourseWare;
import com.cqgcxy.online_study_system.entity.ResultMsg;
import com.cqgcxy.online_study_system.service.chapterService;
import com.cqgcxy.online_study_system.service.coursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Author:32157
 * @DATE:2019/11/12
 */
@Controller
public class coursewareController {

    @Autowired
    coursewareService coursewareService;

    //章节添加页面
    @RequestMapping("/coursewareAdd")
    public ModelAndView coursewareAdd(@RequestParam("chapter_id")String chapter_id){
        ModelAndView view = new ModelAndView("/management/course/coursewareAdd");
        view.addObject("chapter_id",chapter_id);
        return view;
    }
    //添加课件
    @ResponseBody
    @RequestMapping("/coursewareAdd_submit")
    public ResultMsg coursewareAdd_submit(
                                            @RequestParam("chapter_id") String chapter_id,
                                            @RequestParam("address") String address
                                         ){
        CourseWare courseWare = new CourseWare();
        courseWare.setChapter_id(Integer.parseInt(chapter_id));courseWare.setAddress(address);
        int i= coursewareService.insertCourseWare(courseWare);
        if (i==1){
            return new ResultMsg(1,"成功");
        }else {
            return new ResultMsg(0, "失败");
        }
    }
    //
    @RequestMapping("/courseWareById")
    public String courseWareById(@RequestParam("Id") String Id, Model model){
        model.addAttribute("CourseWare",coursewareService.CourseWareById(Integer.parseInt(Id)));
        return "student/courseWare";
    }
}
