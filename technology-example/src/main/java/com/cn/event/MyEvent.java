package com.cn.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @program:springboot-exaple
 * @description: 自定义事件，继承ApplicationEvent
 * @author: xiao
 * @create:2020-03-11 17:31
 * source属性可以省略，继承ApplicationEvent自带的。
 **/
@Getter
@Setter
public class MyEvent extends ApplicationEvent {
    private Object source;
    private String key;
    private String method;

    public MyEvent(Object source, String key, String method) {
        super(source);
        this.source = source;
        this.key = key;
        this.method = method;
    }

    @Override
    public Object getSource() {
        return source;
    }

}
