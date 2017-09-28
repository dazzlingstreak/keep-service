package com.learning.keep.shiro;

import com.learning.keep.web.shiro.AccessTokenAuthcToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by huangdawei on 2017/9/18.
 * 自定义领域（资源）
 */
public class CustomAuthRealm extends AuthorizingRealm {

    @Override
    public Class getAuthenticationTokenClass() {
        return AuthenticationToken.class;
//        return super.getAuthenticationTokenClass(); //默认的是org.apache.shiro.authc.UsernamePasswordToken class 如果自定义的令牌，需要改下
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken instanceof AccessTokenAuthcToken) {
            AccessTokenAuthcToken accessTokenAuthcToken = (AccessTokenAuthcToken) authenticationToken;
            String accessToken = accessTokenAuthcToken.getAccessToken();
            if (accessToken.equalsIgnoreCase("123456")) {
                SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("super", accessToken, getName());
                return simpleAuthenticationInfo;
            }
        }
        return null;
    }

    //用户授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String principal = (String) principalCollection.getPrimaryPrincipal();  //这边获取的就是SimpleAuthenticationInfo的principal

        String key = "Organization:Permission:";
        List<String> permissonList = (List<String>) redisTemplate.opsForValue().get(key);
        if (CollectionUtils.isEmpty(permissonList)) {
            //mock权限码，正常应该是读取数据库/api获取
            permissonList = new ArrayList<>();
            permissonList.add("super:add");
            permissonList.add("super:edit");
            permissonList.add("super:delete");
            redisTemplate.opsForValue().set(key, permissonList, 1, TimeUnit.MINUTES);
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissonList);

        return simpleAuthorizationInfo;
    }

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
}
