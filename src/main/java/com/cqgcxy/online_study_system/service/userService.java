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

    //根据用户id查询用户
    public User selectAdminUserById(int user_id){
        return userDao.selectAdminUserById(user_id);
    };

    //新增管理用户
    public int insertAdminUser(User user){
        return userDao.insertAdminUser(user);
    };

    //修改用户
    public int updateAdminUser(User user){
        return  userDao.updateAdminUser(user);
    };
    //启用或者关闭用户
    public int updateUserStatusRunStop(int user_id,int status){
        if (status==0){
            return userDao.updateUserRun(user_id);
        }else {
            return userDao.updateUserStop(user_id);
        }
    }
}
