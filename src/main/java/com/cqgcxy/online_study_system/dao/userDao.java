package com.cqgcxy.online_study_system.dao;

import com.cqgcxy.online_study_system.entity.User;

import java.util.List;

public interface userDao {
    List<User> selectUserRoleAll();
    User selectUserByName(String username);
    User selectUserRole(User user);
    User selectUserIsStu(User user);
    User selectAdminUserById(int user_id);
    int insertAdminUser(User user);
    int updateAdminUser(User user);
    int updateUserRun(int user_id);
    int updateUserStop(int user_id);
}
