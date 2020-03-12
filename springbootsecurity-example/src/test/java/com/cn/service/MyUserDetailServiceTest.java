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
        String passWord = "123";
        String encodePwd = encoder.encode(passWord);
        String word = "$2a$10$uPx/fj0WKaSnun/ou9riJ.1BN1z/r8ElUEPw8AXzouQUIFTWMX1Ie";
        System.out.println("encodePwd:" + encodePwd);
        boolean flag = encoder.matches(passWord, encodePwd);
        boolean matches = encoder.matches(passWord, word);
        System.out.println(matches);
        System.out.println(flag);
    }

}
