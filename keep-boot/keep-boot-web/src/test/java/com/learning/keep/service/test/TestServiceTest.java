package com.learning.keep.service.test;

import com.learning.keep.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huangdawei on 2017/9/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestServiceTest {

    @Autowired
    private ITestService testService;

    @Test
    public void test() throws InterruptedException{
        testService.test();
    }

    @Test
    public void testAspect(){
        testService.test("aspect test");
    }

}
