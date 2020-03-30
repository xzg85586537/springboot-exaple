package com.cn.controller;

import com.cn.service.CalRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by xiao
 * @Classname ClientController
 * @Description
 * @Date 2020-03-30 0:40
 */
@RestController
@RequestMapping("/test")
public class ClientController {

    @Autowired
    private CalRemoteService calRemoteService;

    @RequestMapping("/radd")
    public String rAdd(@RequestParam Integer a, @RequestParam Integer b) {
        return a + "+" + b + "的Feign调用结果为：" + calRemoteService.add(a, b);
    }
}
