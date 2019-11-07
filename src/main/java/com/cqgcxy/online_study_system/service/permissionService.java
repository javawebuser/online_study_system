package com.cqgcxy.online_study_system.service;

import com.cqgcxy.online_study_system.dao.permissionDao;
import com.cqgcxy.online_study_system.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class permissionService {

    @Autowired
    permissionDao permissionDao;

    public List<Permission> selectPermission(){
        return permissionDao.selectPermission();
    };
}
