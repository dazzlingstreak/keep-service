package com.learning.keep.service.order;

import com.learning.keep.dto.PageParam;
import com.learning.keep.dto.PageResult;
import com.learning.keep.model.Order;

import java.util.List;

/**
 * Created by huangdawei on 2017/8/22.
 */
public interface IOrderService {

    Order selectOrderById(Integer orderId);

    PageResult<Order> selectAll(PageParam param);

    Long selectOrderNoById(Integer orderId);
}
