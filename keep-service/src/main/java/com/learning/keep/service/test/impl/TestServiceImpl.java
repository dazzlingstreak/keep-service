package com.learning.keep.service.test.impl;

import com.learning.keep.service.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by huangdawei on 2017/9/26.
 */
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Override
    public void test() throws InterruptedException {
        int taskSize = 40;

//        System.out.println("----单线程开始运行----");
//        //同步执行
//        Date syncBeginDate = new Date();
//        for (int i = 0; i < taskSize; i++) {
//            MyRunnable myRunnable = new MyRunnable();
//            myRunnable.run();
//        }
//        Date syncEndDate = new Date();
//        System.out.println("----单线程结束运行----，单线程运行时间【"
//                + (syncEndDate.getTime() - syncBeginDate.getTime()) + "毫秒】");

        System.out.println("----多线程开始运行----");
        Date asyncBeginDate = new Date();
        List<Future<?>> taskResults = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            MyRunnable myRunnable = new MyRunnable();
            Future<?> taskResult = executor.submit(myRunnable);
//            executor.submit(new Runnable() {
//                @Override
//                public void run() {
//                //  do something
//                }
//            });
            taskResults.add(taskResult);
        }
        while (true) {
            boolean isAllDone = true;
            for (Future<?> taskResult : taskResults) {
                isAllDone &= (taskResult.isDone() || taskResult.isCancelled());
            }
            if (isAllDone) {
                // 任务都执行完毕，跳出循环
                System.out.println("----多线程结束运行----，多线程运行时间【"
                        + (System.currentTimeMillis() - asyncBeginDate.getTime()) + "毫秒】");
                break;
            }
            try {
                System.out.println("waiting and sleep 1000 ...");
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println(e.toString());
                break;
            }
        }
    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            Date dateTmp1 = new Date();
            System.out.println(">>>任务启动>>> threadId:" + Thread.currentThread().getId() + ";threadName:" + Thread.currentThread().getName() + ";time:" + dateTmp1);
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

    @Override
    public String test(String name) {
        System.out.println("TestServiceImpl.test:" + name);
        return "hello:" + name;
    }
}
