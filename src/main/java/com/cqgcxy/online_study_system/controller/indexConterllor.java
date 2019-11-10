package com.cqgcxy.online_study_system.controller;

import com.cqgcxy.online_study_system.entity.ResultMsg;
import com.cqgcxy.online_study_system.entity.User;
import com.cqgcxy.online_study_system.service.userService;
import org.apache.shiro.SecurityUtils;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author:32157
 * @DATE:2019/11/8
 */
@Controller
public class indexConterllor {

    @Autowired
    com.cqgcxy.online_study_system.service.userService userService;

    /**
     * 登录页面
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        HttpSession session=request.getSession();
        if(session.getAttribute("user")!=null) {
            return "redirect:/index";
        }else {
            return "/login";
        }
    }

    /**
     * 用户判断
     * @param username
     * @param password
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/user")
    public String username(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Model model, HttpServletRequest request){
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //3.执行登录方法
        HttpSession session=request.getSession();

        try {
            subject.login(token);
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            User user1 = userService.selectUserIsStu(user);
            session.setAttribute("user",user1);
            if (user1.getRole().getRole_name().equals("学生")){
                return "redirect:/studentIndex";
            }else {
                return "redirect:/index";
            }
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

    /**
     * 主页
     * @param request
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (session.getAttribute("user")!=null){
            return "/index";
        }else{
            return "redirect:login";
        }
    }

    @RequestMapping("/studentIndex")
    public String studentIndex(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (session.getAttribute("user")!=null){
            return "/student/studentIndex";
        }else{
            return "redirect:login";
        }
    }

    /**
     * 权限警告页面
     * @return
     */
    @RequestMapping("/authorizedUrl")
    public String authorizedUrl(){
        return "/authorizedUrl";
    }

    /**
     * 登录主页默认页面
     * @return
     */
    @RequestMapping("/welcome")
    public  String welcome() {
        return "/welcome";
    }

    /**
     * 退出请求
     * @param request
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/exit_submit")
    public ResultMsg exit_submit(HttpServletRequest request, String name) {
        if(name.equals("11")) {
            HttpSession session=request.getSession();
            session.removeAttribute("user");
            return new ResultMsg(1, "退出!");
        }
        return new ResultMsg(0, "退出失败!");
    }
}
