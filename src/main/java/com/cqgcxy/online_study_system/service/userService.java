package com.cqgcxy.online_study_system.service;

import com.cqgcxy.online_study_system.entity.User;
import com.cqgcxy.online_study_system.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    userDao userMapper;

    public User selectBlog(){
        return userMapper.selectBlog();
    };
}
