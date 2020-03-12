package com.cn.publisher;

import com.cn.event.MyEvent;
import com.cn.spring.SpringContextHolder;
import org.springframework.stereotype.Component;

/**
 * @program:springboot-exaple
 * @description:事件发布
 * @author: xiao
 * @create:2020-03-11 17:43
 **/
@Component
public class MyPublisher {
    public void publish(String key, String method) {
        //调用重新的SpringContextHolder类型的发布方法进行发布。
        SpringContextHolder.publishEvent(new MyEvent(this, key, method));
    }
}
