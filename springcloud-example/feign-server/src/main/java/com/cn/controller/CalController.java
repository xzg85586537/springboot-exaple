package com.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by xiao
 * @Classname CalController
 * @Description
 * @Date 2020-03-30 0:34
 */
@RestController
@RequestMapping("/cal")
public class CalController {
    @RequestMapping("/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        return a + b;
    }
}
