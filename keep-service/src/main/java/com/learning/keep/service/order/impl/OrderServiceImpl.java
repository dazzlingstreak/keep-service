package com.learning.keep.service.order.impl;

import com.github.pagehelper.PageHelper;
import com.learning.keep.dao.OrderMapper;
import com.learning.keep.dto.PageParam;
import com.learning.keep.dto.PageResult;
import com.learning.keep.model.Order;
import com.learning.keep.service.order.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by huangdawei on 2017/8/22.
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;  //这边需要与Application中的Bean定义的Template的类型一致，否则无法Autowired

    @Override
    @Cacheable(value = "order.Cache", key = "#orderId", condition = "#orderId > 10")
    //@CachePut也可以声明一个方法支持缓存功能。与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中
    //SpringCache是基于AOP的代理实现，所以在内部调用方法是不会缓存的
    public Order selectOrderById(Integer orderId) {
        logger.info("selectOrderById,orderId:{}", orderId);
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    @CacheEvict(value = "order.Cache", allEntries = true) //删除order.Cache名称下的所有key-value
    public PageResult<Order> selectAll(PageParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        List<Order> orders = orderMapper.selectAll();
        return new PageResult<>(orders);
    }

    /**
     *  主要测试redis的手动缓存使用
     * @param orderId
     * @return
     */
    @Override
    public Long selectOrderNoById(Integer orderId) {
        String key = "order:info:" + orderId;
        Long value = (Long) redisTemplate.opsForValue().get(key);
        if (value != null) {
            logger.info("selectOrderNo from redis,orderId:{}", orderId);
            return value;
        }

        logger.info("selectOrderNoById from db,orderId:{}", orderId);
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (Objects.nonNull(order)) {
            redisTemplate.opsForValue().set(key, order.getOrderCenterNo(), 1, TimeUnit.MINUTES);
            return order.getOrderCenterNo();
        }
        return null;
    }
}
