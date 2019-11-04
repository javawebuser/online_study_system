package com.cqgcxy.online_study_system.service;

import com.cqgcxy.online_study_system.dao.roleDao;
import com.cqgcxy.online_study_system.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class roleService {

    @Autowired
    roleDao roleDao;

    public List<Role> selectRole(){
        return roleDao.selectRole();
    };

    public int updateRolrStatusRunStop(int role_id,int status){
        if (status==0){
            return roleDao.updateRolrStatusRun(role_id);
        }else {
            return roleDao.updateRolrStatusStop(role_id);
        }
    };
}