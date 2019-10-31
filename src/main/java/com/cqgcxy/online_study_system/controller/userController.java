package com.cqgcxy.online_study_system.controller;

import com.cqgcxy.online_study_system.entity.ResultMsg;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class userController {

    @Autowired
    userService userService;

    @RequestMapping("/login")
    public String login(){
        return "/login";
    }


    @RequestMapping("/user")
    public String username(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Model model,HttpSession session){
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
            User user=(User)subject.getPrincipal();
            session.setAttribute("loginUser",user);
            //登录成功
            return "redirect:/index";
        } catch (UnknownAccountException e) {
            //登录失败
            model.addAttribute("msg", "用户不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            //登录失败
            model.addAttribute("msg", "用户名密码错误");
            return "login";
        }

    }

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("/index");
        return mv;
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

    @RequestMapping("/batch")
    public ModelAndView batch(){
        ModelAndView modelAndView = new ModelAndView("/user/batch");
        return modelAndView;
    }

    @RequestMapping("/course")
    public ModelAndView course(){
        ModelAndView modelAndView = new ModelAndView("/user/course");
        return modelAndView;
    }

    @RequestMapping("/authorizedUrl")
    public String authorizedUrl(){
        return "/authorizedUrl";
    }

    @RequestMapping("/welcome")
    public  String welcome() {
        return "/welcome";
    }

    @ResponseBody
    @RequestMapping("/exit_submit")
    public ResultMsg exit_submit(HttpServletRequest request,String name) {
        if(name.equals("11")) {
            HttpSession session=request.getSession();
            session.invalidate();
            return new ResultMsg(1, "退出!");
        }
        return new ResultMsg(0, "退出失败!");
    }
}
