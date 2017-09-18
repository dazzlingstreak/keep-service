package com.learning.keep.web.api.index;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

/**
 * Created by huangdawei on 2017/9/15.
 */
@Path("/index")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Api("登陆相关")
public class IndexApi {

    private static final String TEMP_TOKEN = "TempToken";
    private static final String BACK_URL = "BackUrl";
    private static final Logger logger = LoggerFactory.getLogger(IndexApi.class);

    @GET
    @Path("/to_login")
    public Response login(@QueryParam("userToken") String userToken, @QueryParam("currentUrl") String currentUrl, @Context HttpServletResponse response) {
        String tempToken = UUID.randomUUID().toString();

        Cookie cookie = new Cookie(TEMP_TOKEN, tempToken);
        cookie.setPath("/");
        response.addCookie(cookie);
        cookie = new Cookie(BACK_URL, currentUrl);
        cookie.setPath("/");
        response.addCookie(cookie);

        try {
            String authLoginUrl = "http://localhost:3154/keep/api/v1/index/login"; //统一认证地址，这边模拟为自身的一个login api地址
            Response.ResponseBuilder builder = Response.status(Response.Status.FOUND).location(new URI(authLoginUrl));
            return builder.build();
        } catch (Exception ex) {
            logger.error("login error :{}", ex);
        }
        return null;
    }

    @GET
    @Path("/login")
    public Response login(@Context HttpServletRequest request) {
        //这个方法应该作为统一登陆的API的回调接口地址，作用是：统一登陆成功后，可以加一些业务逻辑，最后返回到 进入的地址。
        //这些cookie都是业务线自身定义的，所以不会在统一登陆认证的地方使用到。
        //示例中是特殊使用，将统一登陆认证和回调都用这个方法了。
        Cookie[] cookies = request.getCookies();
        String tempToken = "";
        String backUrl = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase(TEMP_TOKEN)) {
                    tempToken = cookie.getValue();
                } else if (cookie.getName().equalsIgnoreCase(BACK_URL)) {
                    backUrl = cookie.getValue();
                }
            }
        }
        try {
            //略过登陆校验，直接判定为登陆通过
            Response.ResponseBuilder builder = Response.status(Response.Status.FOUND).location(new URI(backUrl + "?" + tempToken));
            return builder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
