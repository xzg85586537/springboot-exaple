package com.cn.test;

import com.cn.ChildChannelHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
        int i = 7 << 1;
        System.out.println("结果为:" + i);
    }

    @Test
    public void test2() throws IOException {
        File file = new File("D:\\logs\\C3EB86965AB4431EB9A1982FA11D16CD" + File.separator + "20200307");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Test
    public void test4() {
        String s = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        System.out.println(s);
    }

    @Test
    public void test5() {

    }


}
