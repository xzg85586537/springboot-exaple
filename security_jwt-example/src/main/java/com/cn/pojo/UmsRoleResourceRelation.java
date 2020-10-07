package com.cn.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * ums_role_resource_relation
 * @author 
 */
@Data
public class UmsRoleResourceRelation implements Serializable {
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 资源ID
     */
    private Long resourceId;

    private static final long serialVersionUID = 1L;
}