package com.cqgcxy.online_study_system.controller;

import com.cqgcxy.online_study_system.entity.User;
import com.cqgcxy.online_study_system.service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class userController {

    @Autowired
    userService userService;

    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/user")
    public String username(String username,String password,Model model){
        /**
         * 使用Shiro编写认证操作
         */
        System.out.println(username+":"+password);
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //3.执行登录方法
        try {
            subject.login(token);
            //登录成功
            return "redirect:/index";
        } catch (UnknownAccountException e) {
            //登录失败
            model.addAttribute("msg","用户名不存在");
            return "redirect:/login";
        }catch (IncorrectCredentialsException e) {
            //登录失败
            model.addAttribute("msg","密码错误");
            return "redirect:/login";
        }

    }


    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("/user/add");
        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView update(){
        ModelAndView modelAndView = new ModelAndView("/user/update");
        return modelAndView;
    }
}
