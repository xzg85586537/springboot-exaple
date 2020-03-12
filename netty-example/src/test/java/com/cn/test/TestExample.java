package com.cn.test;

import com.cn.aaa.ChildChannelHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname com.cn.test.TestExample
 * @Description
 * @Date 2020/1/17 17:40
 * @Author by xiao
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExample {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

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
        String no = "C1101";
        String uuid = getOrderNoByUuid(no);
        System.out.println(uuid);
    }

    public static String getOrderNoByUuid(String no) {
//        synchronized(NoUtil.class){
        int uuidHashCode = UUID.randomUUID().toString().hashCode();
        if (uuidHashCode < 0) {
            uuidHashCode = uuidHashCode * (-1);
        }
        String date = LocalDate.now().format(FORMATTER);
        String code = String.format("%04d", new Random().nextInt(9999));
        return no + date + String.format("%010d", uuidHashCode) + code;
//        }
    }

}
