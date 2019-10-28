package com.cqgcxy.online_study_system.controller;

import com.cqgcxy.online_study_system.entity.User;
import com.cqgcxy.online_study_system.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class userController {

    @Autowired
    userService userService;

    @ResponseBody
    @RequestMapping("/user")
    public String username(){
        User user = userService.selectBlog();
        System.out.println(user.getUsername());
        return user.getUsername();
    }

}
