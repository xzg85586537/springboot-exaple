package com.cn.listener;

import com.cn.event.MyEvent;
import org.springframework.context.ApplicationListener;

import java.util.List;

/**
 * @program:springboot-exaple
 * @description:事件监听器
 * @author: xiao
 * @create:2020-03-11 17:38
 * 事件监听器，实现ApplicationListener接口，泛型为自定义的事件
 **/
public class MyListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        //假如这里的source类型是list类型
        List list = (List) myEvent.getSource();
        String key = myEvent.getKey();
        String method = myEvent.getMethod();
        //监听成功后需要实现的代码......

        System.out.println("MyListener接收到了来自MyPublisher的信息:" + key);
    }
}

