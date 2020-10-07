package com.cn.service.impl;

import com.cn.mapper.UmsResourceMapper;
import com.cn.pojo.UmsResource;
import com.cn.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author xiao
 * @Date 2020-10-07 22:58
 * @Version 1.0
 */
@Service
public class ResourceServiceImpl implements UmsResourceService {
    @Autowired
    private UmsResourceMapper resourceMapper;

    @Override
    public List<UmsResource> listAll() {
        return resourceMapper.listAll();
    }
}
