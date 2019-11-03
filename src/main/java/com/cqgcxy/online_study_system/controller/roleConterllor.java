package com.cqgcxy.online_study_system.controller;


import com.cqgcxy.online_study_system.entity.Role;
import com.cqgcxy.online_study_system.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class roleConterllor {

    @Autowired
    roleService roleService;

    @RequestMapping("/role")
    public ModelAndView role(){
        List<Role> list = roleService.selectRole();
        ModelAndView view = new ModelAndView("/management/role");
        view.addObject("role",list);
        return view;
    }
}
