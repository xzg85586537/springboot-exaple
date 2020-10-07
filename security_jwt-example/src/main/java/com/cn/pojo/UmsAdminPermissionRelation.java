package com.cn.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * ums_admin_permission_relation
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)
 * @author
 */
@Data
public class UmsAdminPermissionRelation implements Serializable {
    private Long id;

    private Long adminId;

    private Long permissionId;

    private Integer type;

    private static final long serialVersionUID = 1L;
}