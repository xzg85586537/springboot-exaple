package com.cn.dynamic;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @Description 动态权限相关业务类
 * @Author xiao
 * @Date 2020-10-07 18:19
 * @Version 1.0
 */

public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();

}
