package com.cn.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description
 * @Date 2020/3/3 16:04
 * @Author by xiao
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    @PreAuthorize("hasRole('HELLO')")
    public String sayHello() {
        return "hello";
    }

//    @PostMapping("login")
//    public
}
