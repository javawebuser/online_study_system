package com.cqgcxy.online_study_system.controller;

import com.cqgcxy.online_study_system.entity.Chapter;
import com.cqgcxy.online_study_system.entity.ResultMsg;
import com.cqgcxy.online_study_system.service.chapterService;
import com.cqgcxy.online_study_system.service.coursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @ResponseBody
    @RequestMapping("/coursewareAdd_submit")
    public ResultMsg coursewareAdd_submit(@RequestParam("chapter_id") String co_id,
                                       @RequestParam("chapter") String chapter
                                        ){


        return new ResultMsg(0, "失败");

    }
}
