package com.cn.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * sys_role_permission
 * @author 
 */
@Data
@TableName("sys_role_permission")
public class SysRolePermission implements Serializable {
    private Integer roleId;

    private Integer permissionId;

    private static final long serialVersionUID = 1L;
}