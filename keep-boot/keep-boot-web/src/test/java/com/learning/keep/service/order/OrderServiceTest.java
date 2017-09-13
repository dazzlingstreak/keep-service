package com.learning.keep.service.order;

import com.learning.keep.Application;
import com.learning.keep.model.Order;
import com.learning.keep.properties.WiselySetting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huangdawei on 2017/9/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderServiceTest {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private WiselySetting wiselySetting;

    @Test
    public void selectOrderById() {
        Order order = orderService.selectOrderById(15);
        System.out.println(order.getCityId());
    }
}
