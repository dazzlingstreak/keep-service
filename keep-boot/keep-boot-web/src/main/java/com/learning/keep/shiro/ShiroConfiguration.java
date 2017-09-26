package com.learning.keep.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huangdawei on 2017/9/22.
 */
@Configuration
public class ShiroConfiguration {

    /**
     * 注册DelegatingFilterProxy（Shiro）
     * 集成Shiro有2种方法：
     * 1. 自己组装一个FilterRegistrationBean（这种方法更为灵活，可以自己定义UrlPattern，
     * 在项目使用中你可能会因为一些很但疼的问题最后采用它， 想使用它你可能需要看官网或者已经很了解Shiro的处理原理了）
     * 2. 直接使用ShiroFilterFactoryBean（这种方法比较简单，其内部对ShiroFilter做了组装工作，无法自己定义UrlPattern，
     * 默认拦截 /*）
     * 参考：http://blog.csdn.net/catoop/article/details/50520958
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilter.setSecurityManager(securityManager());

//        shiroFilter.setLoginUrl("/login");// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
//        shiroFilter.setSuccessUrl("/index");// 登录成功后要跳转的链接
//        shiroFilter.setUnauthorizedUrl("/forbidden");// 未授权界面
//
//        Map<String, String> filterChainDefinitionMapping = new HashMap<>(); // 拦截器
//        // 配置不会被拦截的链接 顺序判断
//        filterChainDefinitionMapping.put("/", "anon");
//        filterChainDefinitionMapping.put("/home", "authc,roles[guest]");
//        filterChainDefinitionMapping.put("/admin", "authc,roles[admin]");
//        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMapping);
//
//
//        Map<String, Filter> filters = new HashMap<>();
//        filters.put("anon", new AnonymousFilter());
//        filters.put("authc", new FormAuthenticationFilter());
//        filters.put("logout", new LogoutFilter());
//        filters.put("roles", new RolesAuthorizationFilter());
//        filters.put("user", new UserFilter());
//        shiroFilter.setFilters(filters);
        return shiroFilter;
    }

    @Bean(name = "securityManager")
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        return securityManager;
    }

    @Bean(name = "realm")
    public Realm realm() {
        CustomAuthRealm customAuthRealm = new CustomAuthRealm();
        return customAuthRealm;
    }
}
