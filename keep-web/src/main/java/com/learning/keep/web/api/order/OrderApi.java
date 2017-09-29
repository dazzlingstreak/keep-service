package com.learning.keep.web.api.order;

import com.learning.keep.common.utils.BeanListUtils;
import com.learning.keep.dto.PageParam;
import com.learning.keep.dto.PageResult;
import com.learning.keep.model.Order;
import com.learning.keep.service.order.IOrderService;
import com.learning.keep.web.api.order.model.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
    @RequiresPermissions("super:add")
    public OrderVO selectOrderById(@PathParam("orderId") Integer orderId) {
        Order order = orderService.selectOrderById(orderId);
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(order, orderVO);
        return orderVO;
    }

    @POST
    @Path("/update")
    @ApiOperation("更新订单信息")
    public void updateOrder(OrderVO orderVO) {

    }

    @GET
    @Path("/getOrderNo/{orderId}")
    @ApiOperation("查询订单中心订单号")
    public Long selectOrderNoById(@PathParam("orderId") Integer orderId) {
        return orderService.selectOrderNoById(orderId);
    }

    @GET
    @Path("/all")
    public PageResult<OrderVO> selectAll() {
        PageResult<Order> orderPageResult = orderService.selectAll(new PageParam(1, 12));
        List<Order> orderList = orderPageResult.getItems();

        PageResult<OrderVO> orderVOPageResult = new PageResult<>();
        List<OrderVO> orderVOList = orderVOPageResult.getItems();
        BeanListUtils.copyProperties(orderList, orderVOList, OrderVO.class);
        return orderVOPageResult;
    }
}
