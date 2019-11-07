package com.cqgcxy.online_study_system.dao;

import com.cqgcxy.online_study_system.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface permissionDao {
    List<Permission> selectPermission();
}
