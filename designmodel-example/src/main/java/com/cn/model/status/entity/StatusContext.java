package com.cn.model.status.entity;

import com.cn.model.status.service.IStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * @author by xiao
 * @Classname StatusContext
 * @Description
 * @Date 2020-04-07 21:34
 */
@Getter
@Setter
public class StatusContext {
    IStatus status;
    public StatusContext() {
    }
}
