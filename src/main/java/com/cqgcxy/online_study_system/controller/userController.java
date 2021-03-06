package com.cqgcxy.online_study_system.controller;

import com.cqgcxy.online_study_system.entity.Permission;
import com.cqgcxy.online_study_system.entity.ResultMsg;
import com.cqgcxy.online_study_system.entity.Role;
import com.cqgcxy.online_study_system.entity.User;
import com.cqgcxy.online_study_system.service.roleService;
import com.cqgcxy.online_study_system.service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class userController {

    @Autowired
    userService userService;
    @Autowired
    roleService roleService;

    //查询所有管理员
    @RequestMapping("/adminUserList")
    public String adminUserList(Model model){
        List<User> userList = userService.selectUserRoleAll();
        model.addAttribute("userList",userList);
        return "/management/user/userList";
    }

    //管理员添加页面
    @RequestMapping("/adminUserAdd")
    public String adminUserAdd(Model model){
        List<Role> roleList = roleService.selectRole();
        model.addAttribute("roleList",roleList);
        return "/management/user/userAdd";
    }

    //管理员添加提交
    @ResponseBody
    @RequestMapping("/adminUserAdd_submit")
    public ResultMsg adminUserAdd_submit(@RequestParam("username") String username,
                                         @RequestParam("role_id") String role_id){
        User user = new User();
        user.setUsername(username);
        user.setRole_id(Integer.parseInt(role_id));
        int i = userService.insertAdminUser(user);
        if (i==1){
            return new ResultMsg(1,"成功");
        }else {
            return new ResultMsg(0,"失败");
        }
    }

    //管理员修改页面
    @RequestMapping("/adminUserById")
    public ModelAndView adminUserById(@RequestParam("user_id")String user_id){
        ModelAndView view = new ModelAndView("/management/user/userEdit");
        User user = userService.selectAdminUserById(Integer.parseInt(user_id));
        List<Role> roleList = roleService.selectRole();
        view.addObject("roleList",roleList);
        view.addObject("user",user);
        return view;
    }

    //管理员修改
    @ResponseBody
    @RequestMapping("/adminUser_submit")
    public ResultMsg adminUser_submit(
                                    @RequestParam("user_id") String user_id,
                                    @RequestParam("username") String username,
                                    @RequestParam("role_id") String role_id){
        User updateUser = new User();
        updateUser.setUser_id(Integer.parseInt(user_id));
        updateUser.setUsername(username);
        updateUser.setRole_id(Integer.parseInt(role_id));
        int i = userService.updateAdminUser(updateUser);
        if (i==1){
            return new ResultMsg(1,"成功");
        }else {
            return new ResultMsg(0, "失败");
        }
    }

    //启动或者关闭管理员用户
    @ResponseBody
    @RequestMapping("/updateUserRunStop")
    public ResultMsg updateUserRunStop(String user_id,String status){
        int i = userService.updateUserStatusRunStop(Integer.parseInt(user_id),Integer.parseInt(status));

        if (i==1){
            return new ResultMsg(1,"true");
        }else {
            return new ResultMsg(0,"false");
        }
    }

    //查询所有学生
    @RequestMapping("/stuUserList")
    public String stuUserList(Model model){
        List<User> userList = userService.selectStuUser();
        model.addAttribute("userList",userList);
        return "/management/student/studentList";
    }
    //学生增加页面
    @RequestMapping("/stuUserAdd")
    public String stuUserAdd(){
        return "/management/student/studentAdd";
    }

    //学生添加提交
    @ResponseBody
    @RequestMapping("/stuUserAdd_submit")
    public ResultMsg stuUserAdd_submit(@RequestParam("username") String username){
        User user = new User();
        user.setUsername(username);
        int i = userService.insertstuUser(user);
        if (i==1){
            return new ResultMsg(1,"成功");
        }else {
            return new ResultMsg(0,"失败");
        }
    }

    //学生修改页面
    @RequestMapping("/stuUserById")
    public ModelAndView stuUserById(@RequestParam("user_id")String user_id){
        ModelAndView view = new ModelAndView("/management/student/studentEdit");
        User user = userService.selectAdminUserById(Integer.parseInt(user_id));
        view.addObject("user",user);
        return view;
    }

    //学生修改
    @ResponseBody
    @RequestMapping("/stuUser_submit")
    public ResultMsg stuUser_submit(
            @RequestParam("user_id") String user_id,
            @RequestParam("username") String username){
        User updateUser = new User();
        updateUser.setUser_id(Integer.parseInt(user_id));
        updateUser.setUsername(username);
        updateUser.setRole_id(3);
        int i = userService.updateAdminUser(updateUser);
        if (i==1){
            return new ResultMsg(1,"成功");
        }else {
            return new ResultMsg(0, "失败");
        }
    }
}
