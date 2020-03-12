package com.cn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyUserDetailServiceTest {
    @Test

    public void test() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passWord = "123456";
        String encodePwd = encoder.encode(passWord);
//        String word = "$2a$10$RpFJjxYiXdEsAGnWp/8fsOetMuOON96Ntk/Ym2M/RKRyU0GZseaDC";
        String word = "$2a$10$Zn./gg7ChA1X.AWLiMTiSOOUkJltVntBcxbEDc4n1c2DAX611sVqm";
        System.out.println("encodePwd:" + encodePwd);
        boolean flag = encoder.matches(passWord, encodePwd);
        boolean matches = encoder.matches(passWord, word);
        System.out.println(flag);
        System.out.println(matches);
    }

}
