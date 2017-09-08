package com.learning.keep.service.order.impl;

import com.github.pagehelper.PageHelper;
import com.learning.keep.dao.OrderMapper;
import com.learning.keep.dto.PageParam;
import com.learning.keep.dto.PageResult;
import com.learning.keep.model.Order;
import com.learning.keep.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangdawei on 2017/8/22.
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order selectOrderById(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public PageResult<Order> selectAll(PageParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        List<Order> orders = orderMapper.selectAll();
        return new PageResult<>(orders);
    }
}
