package com.cn.model.bridge.abstracts;

import com.cn.model.bridge.service.MemoryService;
import lombok.Setter;

/**
 * @program:springboot-exaple
 * @description:
 * @author: xiao
 * @create:2020-03-10 19:41
 **/
@Setter
public abstract class AbstractPhone {
    public MemoryService memory;
    public abstract void buyPhone();
}
