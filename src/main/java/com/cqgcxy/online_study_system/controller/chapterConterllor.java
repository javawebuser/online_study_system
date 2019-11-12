package com.cqgcxy.online_study_system.controller;

import com.cqgcxy.online_study_system.entity.Chapter;
import com.cqgcxy.online_study_system.entity.ResultMsg;
import com.cqgcxy.online_study_system.service.chapterService;
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
public class chapterConterllor {

    @Autowired
    chapterService chapterService;

    //章节添加页面
    @RequestMapping("/chapterAdd")
    public ModelAndView chapterAdd(@RequestParam("co_id")String co_id){
        ModelAndView view = new ModelAndView("/management/course/chapterAdd");
        view.addObject("co_id",co_id);
        return view;
    }

    @ResponseBody
    @RequestMapping("/chapterAdd_submit")
    public ResultMsg chapterAdd_submit( @RequestParam("co_id") String co_id,
                                        @RequestParam("chapter") String chapter
                                        ){
        Chapter cha = new Chapter();
        cha.setCo_id(Integer.parseInt(co_id));
        cha.setChapter(chapter);
        int i = chapterService.insertChapter(cha);
        if (i == 1) {
            return new ResultMsg(1, "成功");
        } else {
            return new ResultMsg(0, "失败");
        }
    }
}
