package com.learning.keep.web.api.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/test")
@Api(tags = "测试模块Api")
public class TestApi {

    @GET
    @Path("/say/{words}")
    @ApiOperation("打招呼")
    public String test(@PathParam("words") String text) {
        return "hello," + text;
    }
}
