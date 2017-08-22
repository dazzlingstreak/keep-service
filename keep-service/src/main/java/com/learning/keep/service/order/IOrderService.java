package com.learning.keep.service.order;

import com.learning.keep.model.Order;

/**
 * Created by huangdawei on 2017/8/22.
 */
public interface IOrderService {

    Order selectOrderById(Integer orderId);
}
