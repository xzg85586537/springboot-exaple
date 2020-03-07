package com.cn.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname RolePermissionVo
 * @Description
 * @Date 2020/3/6 15:46
 * @Author by xiao
 */
@Data
public class RolePermissionVo implements Serializable {
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 路径
     */
    private String url;
}
