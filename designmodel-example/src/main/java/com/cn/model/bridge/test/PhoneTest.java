package com.cn.model.bridge.test;

import com.cn.model.bridge.PhoneBrand.HuaWei;
import com.cn.model.bridge.service.impl.Memory5GService;

/**
 * @program:springboot-exaple
 * @description:
 * @author: xiao
 * @create:2020-03-10 19:46
 **/
public class PhoneTest {
    public static void main(String[] args) {
        HuaWei huaWei = new HuaWei();
        huaWei.setMemory(new Memory5GService());
        huaWei.buyPhone();
        System.out.println("消费者购买华为手机，内存为5G");
    }
}
