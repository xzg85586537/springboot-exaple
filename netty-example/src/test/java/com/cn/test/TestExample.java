package com.cn.test;

import com.cn.ChildChannelHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Classname com.cn.test.TestExample
 * @Description
 * @Date 2020/1/17 17:40
 * @Author by xiao
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChildChannelHandler.class)
public class TestExample {

    @Test
    public void test() {
        int i = 20 >> 1;
        System.out.println("结果为：" + i);
    }

}
