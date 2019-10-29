package com.cqgcxy.online_study_system.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.cqgcxy.online_study_system.real.myRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:32157
 * @DATE:2019/10/29
 * 将shiro配置到bean中
 */
@Configuration
public class shiroConfig {
    /**
     * 创建realm类
     * @return
     */
    @Bean(name = "myRealm")
    public myRealm getMyRealm(){
        myRealm realm = new myRealm();
        return realm;
    }

    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm")myRealm myRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联realm
        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //定义可以直接访问的资源
        Map<String,String> map = new LinkedHashMap<String,String>();
        /**
         * anon:无需认证可以访问
         * authc:必须认证才可访问
         * user使用rememberMe可以直接访问
         * perms：得到资源权限才可以访问
         * role：得到角色权限才可以访问
         */
        map.put("/add","authc");
        map.put("/update","authc");
        map.put("/login","anon");
        map.put("/add","perms[角色管理]");
        map.put("/update","perms[用户管理]");
        map.put("/batch","perms[批次管理]");
        map.put("/course","perms[课程管理]");
        /*map.put("/update","perms[user:update]");*/
        //修改调整的登录页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/authorizedUrl");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
     * @return
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
