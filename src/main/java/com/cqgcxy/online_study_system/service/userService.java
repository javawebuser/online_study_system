package com.cqgcxy.online_study_system.service;

import com.cqgcxy.online_study_system.entity.User;
import com.cqgcxy.online_study_system.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class userService {

    @Autowired
    userDao userDao;

    //查询用户是否存在
    public User selectUserIsStu(User user){
        return userDao.selectUserIsStu(user);
    }
    //查询所有管理员
    public List<User> selectUserRoleAll(){
        return userDao.selectUserRoleAll();
    }
    //查询用户名是否存在
    public User selectUserByName(String username){
        return userDao.selectUserByName(username);
    }

    //查询用户角色权限
    public User selectUserRole(User user){
        return userDao.selectUserRole(user);
    };
}
