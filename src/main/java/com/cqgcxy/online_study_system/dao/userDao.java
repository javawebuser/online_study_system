package com.cqgcxy.online_study_system.dao;

import com.cqgcxy.online_study_system.entity.User;

import java.util.List;

public interface userDao {
    List<User> selectUserRoleAll();
    User selectUserByName(String username);
    User selectUserRole(User user);
    User selectUserIsStu(User user);
}
