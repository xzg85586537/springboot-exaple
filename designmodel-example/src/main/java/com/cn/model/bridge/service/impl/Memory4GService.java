package com.cn.model.bridge.service.impl;

import com.cn.model.bridge.service.MemoryService;

/**
 * @program:springboot-exaple
 * @description:
 * @author: xiao
 * @create:2020-03-10 19:40
 **/
public class Memory4GService implements MemoryService {
    @Override
    public void showMemory() {
        System.out.println("4G内存");
    }
}
