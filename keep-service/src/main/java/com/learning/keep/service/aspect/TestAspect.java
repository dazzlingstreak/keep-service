package com.learning.keep.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by huangdawei on 2017/9/30.
 */
@Aspect
@Order(10)
@Component
public class TestAspect {
    private static final Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Pointcut("execution(public * com.learning.keep.service.test..*.*(..))")
    public void testWork() {
    }

    @Before(value = "testWork()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("doBefore ...");
    }

    /**
     * 1)value="切入点表达式或命名切入点"
     * 2)pointcut="切入点表达式或命名切入点"
     * 3)argNames="参数列表参数名"
     * 4)returning="返回搜索值对应参数名"
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "testWork()", returning = "result") //返回后
    public void doAfter(JoinPoint joinPoint, String result) {
        //1.joinPoint.getArgs(): 获取带参方法的参数
        //2.joinPoint.getTarget(): 获取他们的目标对象信息
        //3.joinPoint.getSignature():(signature是信号,标识的意思):获取被增强的方法相关信息

        System.out.println("doAfter getSignature:" + joinPoint.getSignature());
        System.out.println("doAfter getSignature.getDeclaringTypeName:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("doAfter getSignature.getName:" + joinPoint.getSignature().getName());
        System.out.println("doAfter getArgs:" + joinPoint.getArgs());
        System.out.println("doAfter getArgs string:" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("doAfter result:" + result);

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Override annotation = method.getAnnotation(Override.class);
    }

    @Around(value = "testWork()")
    public Object doArround(JoinPoint joinPoint) throws Throwable {
        System.out.println("doArround before method ...");
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
        Object result = proceedingJoinPoint.proceed();  //实际方法的处理，如果这边不加，那么doAfter中获取的result就为null了
        System.out.println("doArround after method ...");
        return result;
    }
}
