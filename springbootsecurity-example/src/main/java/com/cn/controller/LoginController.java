package com.cn.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program:springboot-exaple
 * @description:登录接口
 * @author: xiao
 * @create:2020-03-06 17:48
 **/
@RestController
public class LoginController {

    @RequestMapping("login")
    public String login() {
        return "登录成功";
    }

    @PostMapping("login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError",true);
        return "login";
    }
}
