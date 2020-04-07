package com.cn.model.status.test;

import com.cn.model.status.entity.StatusContext;
import com.cn.model.status.service.impl.DriveStatus;
import com.cn.model.status.service.impl.WalkStatus;

/**
 * @author by xiao
 * @Classname Test
 * @Description
 * @Date 2020-04-07 21:38
 */
public class Test {
    public static void main(String[] args) {
        StatusContext context = new StatusContext();
        WalkStatus walkStatus = new WalkStatus();
        walkStatus.exeecute(context);

        DriveStatus driveStatus = new DriveStatus();
        driveStatus.exeecute(context);
    }
}
