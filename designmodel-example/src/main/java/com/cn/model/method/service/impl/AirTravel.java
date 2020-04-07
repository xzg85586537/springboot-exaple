package com.cn.model.method.service.impl;

import com.cn.model.method.service.TravelService;

/**
 * @author by xiao
 * @Classname AirTravel
 * @Description
 * @Date 2020-04-07 21:52
 */
public class AirTravel implements TravelService {
    @Override
    public void travelStyle() {
        System.out.println("飞机旅游");
    }
}
