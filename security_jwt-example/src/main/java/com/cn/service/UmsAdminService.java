package com.cn.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Description TODO
 * @Author xiao
 * @Date 2020-10-07 23:34
 * @Version 1.0
 */

public interface UmsAdminService {

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    String login(String userName, String passWord);

}
