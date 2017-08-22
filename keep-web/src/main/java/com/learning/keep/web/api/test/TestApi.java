package com.learning.keep.web.api.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        System.out.println(model.getName());
    }

    @GET
    @Path("/get")
    public List<TestModel> getModels(){
        List<TestModel> list = new ArrayList<>();
        TestModel model1 = new TestModel();
        model1.setAge(10);
        model1.setName("A");
        model1.setMarried(true);
        model1.setSalary(1000.00);
        model1.setBirthday(new Date());
        list.add(model1);

        TestModel model2 = new TestModel();
        model2.setAge(11);
        model2.setName("B");
        model2.setMarried(false);
        model2.setSalary(1500.00);
        model2.setBirthday(new Date());
        list.add(model2);
        return  list;
    }

}
