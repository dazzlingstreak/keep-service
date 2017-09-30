package com.learning.keep.service.test;

/**
 * Created by huangdawei on 2017/9/26.
 */
public interface ITestService {

    /**
     * 测试多线程
     * @throws InterruptedException
     */
    void test() throws InterruptedException;

    /**
     * 测试Aspect
     * @param name
     * @return
     */
    String test(String name);
}
