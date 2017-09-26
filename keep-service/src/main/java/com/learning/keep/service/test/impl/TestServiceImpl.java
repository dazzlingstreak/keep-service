package com.learning.keep.service.test.impl;

import com.learning.keep.service.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by huangdawei on 2017/9/26.
 */
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Override
    public void test() throws InterruptedException {
        int taskSize = 5;

//        System.out.println("----同步程序开始运行----");
//        //同步执行
//        Date syncBeginDate = new Date();
//        for (int i = 0; i < taskSize; i++) {
//            MyRunnable myRunnable = new MyRunnable();
//            myRunnable.run();
//        }
//        Date syncEndDate = new Date();
//        System.out.println("----同步程序结束运行----，同步程序运行时间【"
//                + (syncEndDate.getTime() - syncBeginDate.getTime()) + "毫秒】");

        System.out.println("----异步程序开始运行----");
        Date asyncBeginDate = new Date();
//        ExecutorService executorService = Executors.newFixedThreadPool(taskSize);
        for (int i = 0; i < taskSize; i++) {
//            executorService.execute(new MyRunnable());
            MyRunnable myRunnable = new MyRunnable();
            executor.execute(myRunnable);
        }
//        executorService.shutdown();
        Date asyncEndDate = new Date();
        System.out.println("----异步程序结束运行----，异步程序运行时间【"
                + (asyncEndDate.getTime() - asyncBeginDate.getTime()) + "毫秒】");
        Thread.sleep(1500);
    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(">>>任务启动>>>");
            Date dateTmp1 = new Date();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date dateTmp2 = new Date();
            long time = dateTmp2.getTime() - dateTmp1.getTime();
            System.out.println(">>>任务结束>>> threadId:" + Thread.currentThread().getId() + ";threadName:" + Thread.currentThread().getName() + ";耗时 " + time + " 毫秒");
        }
    }
}
