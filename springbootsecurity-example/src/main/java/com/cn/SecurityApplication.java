package com.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname SecurityApplication
 * @Description
 * @Date 2020/3/3 16:03
 * @Author by xiao
 */
@SpringBootApplication
@MapperScan("com.cn.mapper.**")
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
