package com.learning.keep.web.api.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
@Api(tags = "测试模块Api")//@RestController 这是SpringMVC的注解
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Consumes({MediaType.APPLICATION_JSON})
public class TestApi {

    @GET
    @Path("/say/{words}")
    @ApiOperation("打招呼")
    public String test(@PathParam("words") String text) {
        return "hello," + text;
    }

    @POST
    @Path("/save")
    @ApiOperation("添加模型")
    public void addPerson(TestModel model){
    }
}
