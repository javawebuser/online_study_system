package com.cqgcxy.online_study_system.service;

import com.cqgcxy.online_study_system.dao.roleDao;
import com.cqgcxy.online_study_system.dao.role_permissionDao;
import com.cqgcxy.online_study_system.entity.Role;
import com.cqgcxy.online_study_system.entity.Role_permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
@Service
public class roleService {

    @Autowired
    roleDao roleDao;
    @Autowired
    role_permissionDao role_permissionDao;

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

    @Transactional
    public int insetRole(Role role,String per []){
        int i = roleDao.insetRole(role);
        Role_permission permission = new Role_permission();
        List<Role_permission> list=new ArrayList<>();
        if (i==1){
            for (int j=0;j<per.length;j++){
                permission.setRole_id(role.getRole_id());
                permission.setPer_id(Integer.parseInt(per[j]));
                list.add(permission);
            }
            int k = role_permissionDao.insertRolePermission(list);
            if (k==per.length){
                return 1;
            }else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return 0;
            }
        }else{
            return 0;
        }
    }

    public Role selectRoleById(int role_id){
        return roleDao.selectRoleById(role_id);
    }
}
