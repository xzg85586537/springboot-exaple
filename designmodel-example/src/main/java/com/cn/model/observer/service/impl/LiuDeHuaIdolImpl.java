package com.cn.model.observer.service.impl;

import com.cn.model.observer.service.Fan;
import com.cn.model.observer.service.Idol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by xiao
 * @Classname LiuDeHuaIdolImpl
 * @Description
 * @Date 2020-04-07 16:55
 */
public class LiuDeHuaIdolImpl implements Idol {
    private List<Fan> fanList = new ArrayList<>();

    @Override
    public void addFan(Fan fan) {
        fanList.add(fan);
    }

    @Override
    public void delFan(Fan fan) {
        fanList.removeAll(fanList);
    }

    @Override
    public void notify(String message) {
        fanList.stream().forEach(fan -> fan.update(message));
    }
}
