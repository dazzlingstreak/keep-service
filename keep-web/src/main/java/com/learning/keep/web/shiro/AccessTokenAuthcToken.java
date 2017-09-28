package com.learning.keep.web.shiro;


import org.apache.shiro.authc.AuthenticationToken;

public class AccessTokenAuthcToken implements AuthenticationToken {

    private String userToken;
    private String accessToken;

    public AccessTokenAuthcToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public AccessTokenAuthcToken(String userToken, String accessToken) {
        this(accessToken);
        this.userToken = userToken;
    }

    @Override
    public Object getPrincipal() {
        return userToken;
    }

    @Override
    public Object getCredentials() {
        return accessToken;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
