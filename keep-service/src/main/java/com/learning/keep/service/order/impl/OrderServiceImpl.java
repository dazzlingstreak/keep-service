package com.learning.keep.service.order.impl;

import com.learning.keep.dao.OrderMapper;
import com.learning.keep.model.Order;
import com.learning.keep.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
