package com.learning.keep.web.filter;

import com.learning.keep.web.shiro.AccessTokenAuthcToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by huangdawei on 2017/9/28.
 */
@Provider
public class AuthenticationFilter implements ContainerRequestFilter, ContainerResponseFilter {

    /**
     * shiro异常参考：http://blog.csdn.net/oshusheng1/article/details/50410258
     */
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String accessToken = getAccessToken(containerRequestContext);
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            AccessTokenAuthcToken accessTokenAuthcToken = new AccessTokenAuthcToken(accessToken); //认证token
            subject.login(accessTokenAuthcToken); //securityManager进行认证，最终由实际的realm进行认证，realm根据token查询用户信息，若查询不到，返回null，则抛出org.apache.shiro.authc.UnknownAccountException
        }
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {

    }

    private String getAccessToken(ContainerRequestContext containerRequestContext) {
        String accessToken = containerRequestContext.getHeaderString("Authorization");
        return accessToken;
    }
}
