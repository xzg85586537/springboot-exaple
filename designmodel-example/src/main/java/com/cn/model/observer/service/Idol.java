package com.cn.model.observer.service;

/**
 * @author by xiao
 * @Classname Idol
 * @Description
 * @Date 2020-04-07 16:54
 */
public interface Idol {
    void addFan(Fan fan);

    void delFan(Fan fan);

    void notify(String message);
}
