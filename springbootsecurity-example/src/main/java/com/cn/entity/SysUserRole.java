package com.cn.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * sys_user_role
 * @author 
 */
@Data
@TableName("sys_user_role")
public class SysUserRole implements Serializable {
    private Integer userId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;
}