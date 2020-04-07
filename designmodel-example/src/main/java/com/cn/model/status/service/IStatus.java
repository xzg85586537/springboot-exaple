package com.cn.model.status.service;

import com.cn.model.status.entity.StatusContext;

/**
 * @author by xiao
 * @Classname IStatus
 * @Description
 * @Date 2020-04-07 21:33
 * 公共的状态接口
 */
public interface IStatus {
    void exeecute(StatusContext context);
}
