package com.cn.model.observer.service.impl;

import com.cn.model.observer.service.Fan;

/**
 * @author by xiao
 * @Classname XiaoHongFanImpl
 * @Description
 * @Date 2020-04-07 16:52
 */
public class XiaoMingFanImpl implements Fan {
    private String fanName;

    public XiaoMingFanImpl(String fanName) {
        this.fanName = fanName;
    }

    @Override
    public void update(String message) {
        System.out.println(fanName + "知道了" + message + "这条消息");

    }
}
