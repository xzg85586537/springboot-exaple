package com.cn.model.status.service.impl;

import com.cn.model.status.entity.StatusContext;
import com.cn.model.status.service.IStatus;

/**
 * @author by xiao
 * @Classname WalkStatus
 * @Description
 * @Date 2020-04-07 21:36
 */
public class WalkStatus implements IStatus {
    @Override
    public void exeecute(StatusContext context) {
        System.out.println("走路状态");
        context.setStatus(this);
    }
}
