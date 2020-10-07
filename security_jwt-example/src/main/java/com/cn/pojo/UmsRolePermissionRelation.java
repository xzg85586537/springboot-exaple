package com.cn.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * ums_role_permission_relation
 * @author 
 */
@Data
public class UmsRolePermissionRelation implements Serializable {
    private Long id;

    private Long roleId;

    private Long permissionId;

    private static final long serialVersionUID = 1L;
}