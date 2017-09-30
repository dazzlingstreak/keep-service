package com.learning.keep.service.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by huangdawei on 2017/9/30.
 */
@Aspect
@Component
@Order(1)
public class ServiceLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    @Pointcut("execution(public * com.learning.keep.service.order..*.*(..))")
    public void log() {
    }

    @Around(value = "log()")
    public Object logArround(JoinPoint joinPoint) throws Throwable {

        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info(declaringTypeName + "." + name + " args:" + JSON.toJSONString(args));

        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
        Object result = proceedingJoinPoint.proceed();

        logger.info(declaringTypeName + "." + name + " response:" + JSON.toJSONString(result));
        return result;
    }

}
