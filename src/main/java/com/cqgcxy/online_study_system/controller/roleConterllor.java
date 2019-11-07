package com.cqgcxy.online_study_system.controller;


import com.cqgcxy.online_study_system.entity.Permission;
import com.cqgcxy.online_study_system.entity.ResultMsg;
import com.cqgcxy.online_study_system.entity.Role;
import com.cqgcxy.online_study_system.service.permissionService;
import com.cqgcxy.online_study_system.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class roleConterllor {

    @Autowired
    roleService roleService;
    @Autowired
    permissionService permissionService;

    @RequestMapping("/roleList")
    public ModelAndView roleList(){
        List<Role> list = roleService.selectRole();
        ModelAndView view = new ModelAndView("/management/role/roleList");
        view.addObject("role",list);
        for (Role role : list){
            System.out.println(role.getRole_id()+":"+role.getRole_name());
        }
        return view;
    }

    @RequestMapping("/roleAdd")
    public ModelAndView roleAdd(){
        ModelAndView view = new ModelAndView("/management/role/roleAdd");
        List<Permission> permissions = permissionService.selectPermission();
        view.addObject("permissions",permissions);
        return view;
    }

    @RequestMapping("/roleById")
    public ModelAndView roleById(@RequestParam("role_id")String role_id){
        ModelAndView view = new ModelAndView("/management/role/roleEdit");
        List<Permission> permissions = permissionService.selectPermission();
        Role role =roleService.selectRoleById(Integer.parseInt(role_id));
        view.addObject("role",role);
        view.addObject("permissions",permissions);
        return view;
    }

    @ResponseBody
    @RequestMapping("/roleAdd_submit")
    public ResultMsg roleAdd_submit(@RequestParam("role_name") String role_name,
                               @RequestParam("per") String per []){
        Role role = new Role();
        role.setRole_name(role_name);
        int i = roleService.insetRole(role,per);
        if (i==1){
            return new ResultMsg(1,"成功");
        }else {
            return new ResultMsg(0,"失败");
        }
    }

    @ResponseBody
    @RequestMapping("updateRolrStatusRunStop")
    public ResultMsg updateRolrStatusRunStop(String role_id,String status){
        int i = roleService.updateRolrStatusRunStop(Integer.parseInt(role_id),Integer.parseInt(status));

        if (i==1){
            return new ResultMsg(1,"true");
        }else {
            return new ResultMsg(0,"false");
        }

    }
}
