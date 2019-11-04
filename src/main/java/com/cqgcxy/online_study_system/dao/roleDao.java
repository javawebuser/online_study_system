package com.cqgcxy.online_study_system.dao;

import com.cqgcxy.online_study_system.entity.Role;

import java.util.List;

/**
 * 角色
 */
public interface roleDao {
    //查询所有角色
    List<Role> selectRole();
    //修改角色状态
    int updateRolrStatusRun(int role_id);
    int updateRolrStatusStop(int role_id);
}
