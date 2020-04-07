package com.cn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author by xiao
 * @Classname LocalTest
 * @Description
 * @Date 2020-04-02 8:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalTest {
    @Test
    public void test() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String s = localDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
        System.out.println(s);
    }
}
