package com.cn.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @program:springboot-exaple
 * @description:
 * @author: xiao
 * @create:2020-03-11 14:49
 * 重写SpringContextHolder类
 * 目的：可以进行同步或者异步的调用。
 **/
@Slf4j
@Component
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
    private static ApplicationContext applicationContext = null;

    public SpringContextHolder() {
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static void clearHolder() {
        if (log.isDebugEnabled()) {
            log.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
        }
        applicationContext = null;
    }

    public static void publishEvent(ApplicationEvent event) {
        if (applicationContext != null) {
            applicationContext.publishEvent(event);
        }
    }


    @Override
    public void destroy() throws Exception {
        clearHolder();
    }
}
