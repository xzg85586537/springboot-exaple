package com.cn.model.method.service.impl;

import com.cn.model.method.service.TravelService;

/**
 * @author by xiao
 * @Classname TrainTravel
 * @Description
 * @Date 2020-04-07 21:53
 */
public class TrainTravel implements TravelService {
    @Override
    public void travelStyle() {
        System.out.println("火车旅游");
    }
}
