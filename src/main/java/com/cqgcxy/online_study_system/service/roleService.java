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

    /**
     * 角色列表
     * @return
     */
    public List<Role> selectRole(){
        return roleDao.selectRole();
    };

    /**
     * 开启或者停用角色
     * @param role_id
     * @param status
     * @return
     */
    public int updateRolrStatusRunStop(int role_id,int status){
        if (status==0){
            return roleDao.updateRolrStatusRun(role_id);
        }else {
            return roleDao.updateRolrStatusStop(role_id);
        }
    };

    /**
     * 角色添加
     * @param role
     * @param per
     * @return
     */
    @Transactional
    public int insetRole(Role role,String per []){
        //添加角色、角色添加失败返回0
        int i = roleDao.insetRole(role);
        Role_permission permission = new Role_permission();
        List<Role_permission> list=new ArrayList<>();
        if (i==1){
            for (int j=0;j<per.length;j++){
                //将添加角色后的role_id，写到Role_permission中
                permission.setRole_id(role.getRole_id());
                permission.setPer_id(Integer.parseInt(per[j]));
                list.add(permission);
            }
            int k = role_permissionDao.insertRolePermission(list);
            //判断添加条数是否正确，正确放回1，错误回滚事务，并放回0
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

    /**
     * 根据role_id获取角色
     * @param role_id
     * @return
     */
    public Role selectRoleById(int role_id){
        return roleDao.selectRoleById(role_id);
    }

    /**
     * 修改权限
     * @param role
     * @param per
     * @return
     */
    @Transactional
    public int updateRolrAdmin(Role role,String per []){
        //1.修改权限名字，修改失败返会0
        int i = roleDao.updateRolrAdmin(role);
        Role_permission permission = new Role_permission();
        List<Role_permission> list=new ArrayList<>();
        if (i==1){
            //2.删除角色所有权限，删除失败回滚事务，返回0
            int j = role_permissionDao.deletPermission(role.getRole_id());
            if (j>0){
                for (int l=0;l<per.length;l++){
                    //将添加角色后的role_id，写到Role_permission中
                    permission.setRole_id(role.getRole_id());
                    permission.setPer_id(Integer.parseInt(per[l]));
                    list.add(permission);
                }
                //判断添加条数是否正确，正确放回1，错误回滚事务，并放回0
                int m = role_permissionDao.insertRolePermission(list);
                if (m==per.length){
                    return 1;
                }else {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }
            }else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return 0;
            }
        }else{
            return 0;
        }
    }
}
