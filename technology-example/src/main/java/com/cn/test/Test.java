package com.cn.test;

import com.cn.TechnologyApplication;
import com.cn.publisher.MyPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program:springboot-exaple
 * @description:
 * @author: xiao
 * @create:2020-03-11 17:58
 **/
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TechnologyApplication.class);
        MyPublisher publisher = context.getBean(MyPublisher.class);
        publisher.publish("key是这样", "method长这样");
        context.close();
    }
}
