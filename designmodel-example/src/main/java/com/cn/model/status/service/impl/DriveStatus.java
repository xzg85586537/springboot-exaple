package com.cn.model.status.service.impl;

import com.cn.model.status.entity.StatusContext;
import com.cn.model.status.service.IStatus;

/**
 * @author by xiao
 * @Classname DriveStatus
 * @Description
 * @Date 2020-04-07 21:38
 */
public class DriveStatus implements IStatus {
    @Override
    public void exeecute(StatusContext context) {
        System.out.println("开车状态");
        context.setStatus(this);
    }
}
