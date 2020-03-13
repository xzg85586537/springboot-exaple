package com.cn.model.bridge.PhoneBrand;

import com.cn.model.bridge.abstracts.AbstractPhone;

/**
 * @program:springboot-exaple
 * @description:
 * @author: xiao
 * @create:2020-03-10 19:43
 **/

public class HuaWei extends AbstractPhone {
    @Override
    public void buyPhone() {
        memory.showMemory();
        System.out.println("购买华为手机");
    }
}
