package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

/**
 * @program:springboot-exaple
 * @description:
 * @author: xiao
 * @create:2020-03-11 19:29
 **/
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
public class TechnologyApplication {
    public static void main(String[] args) {
        SpringApplication.run(TechnologyApplication.class, args);
    }
}

