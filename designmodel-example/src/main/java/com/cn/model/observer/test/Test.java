package com.cn.model.observer.test;

import com.cn.model.observer.service.impl.LiuDeHuaIdolImpl;
import com.cn.model.observer.service.impl.XiaoHongFanImpl;
import com.cn.model.observer.service.impl.XiaoMingFanImpl;

/**
 * @author by xiao
 * @Classname Test
 * @Description
 * @Date 2020-04-07 16:56
 */
public class Test {
    public static void main(String[] args) {
        LiuDeHuaIdolImpl liuDeHua = new LiuDeHuaIdolImpl();

        XiaoHongFanImpl xiaoHong = new XiaoHongFanImpl("小红");
        XiaoMingFanImpl xiaoMing = new XiaoMingFanImpl("小明");

//        liuDeHua.addFan(xiaoHong);
//        liuDeHua.addFan(xiaoMing);
        liuDeHua.notify("我会唱歌");
    }
}
