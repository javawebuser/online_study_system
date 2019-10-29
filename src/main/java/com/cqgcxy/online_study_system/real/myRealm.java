package com.cqgcxy.online_study_system.real;

import com.cqgcxy.online_study_system.entity.Permission;
import com.cqgcxy.online_study_system.entity.User;
import com.cqgcxy.online_study_system.service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

/**
 * @Author:32157
 * @DATE:2019/10/29
 * 自定义Rralm（授权和认证）
 */

public class myRealm extends AuthorizingRealm {

    /**
     * 授权逻辑
     * @param principalCollection
     * @return
     */
    @Autowired
    userService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        Subject subject = SecurityUtils.getSubject();
        User user=(User)subject.getPrincipal();

        User userRole = userService.selectUserRole(user);
        for(Permission permission : userRole.getPermission()){
            info.addStringPermission(permission.getPer_name());
        }
        return info;
    }

    /**
     * 认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = userService.selectUserByName(token.getUsername());
        if (user==null){
            //用户名不存在
            return null;
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(),"");
    }
}
