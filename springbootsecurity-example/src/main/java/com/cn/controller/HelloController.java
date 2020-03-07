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

    /**
     * 受保护的资源
     * @return
     */
    @GetMapping("/hi")
    public String save(String name) {
        return "hi："+name;
    }

//    /**
//     * 不受保护的资源
//     * @return
//     */
//    @GetMapping("/save/no")
//    public String noSave() {
//        return "恭喜测试成功！！！";
//    }
}
