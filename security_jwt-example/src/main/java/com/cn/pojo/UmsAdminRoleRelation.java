package com.cn.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * ums_admin_role_relation
 * 后台用户和角色关系表
 * @author
 */
@Data
public class UmsAdminRoleRelation implements Serializable {
    private Long id;

    private Long adminId;

    private Long roleId;

    private static final long serialVersionUID = 1L;
}