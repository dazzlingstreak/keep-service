package com.learning.keep.web.api.order;

import com.learning.keep.model.Order;
import com.learning.keep.service.order.IOrderService;
import com.learning.keep.web.api.order.model.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

/**
 * Created by huangdawei on 2017/8/22.
 */
@Path("/order")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Api(tags = "订单模块")
public class OrderApi {

    @Autowired
    private IOrderService orderService;

    @GET
    @Path("/{orderId}")
    @ApiOperation("查询订单详情")
    public OrderVO selectOrderById(@PathParam("orderId") Integer orderId) {
        Order order = orderService.selectOrderById(orderId);
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(order, orderVO);
        return orderVO;
    }
}
