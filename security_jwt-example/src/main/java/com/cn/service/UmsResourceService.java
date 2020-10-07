package com.cn.service;

import com.cn.pojo.UmsResource;

import java.util.List;

/**
 * @Description TODO
 * @Author xiao
 * @Date 2020-10-07 23:35
 * @Version 1.0
 */

public interface UmsResourceService {
    /**
     * 查询全部资源
     */
    List<UmsResource> listAll();
}
