package com.cn.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * ums_role_menu_relation
 * @author 
 */
@Data
public class UmsRoleMenuRelation implements Serializable {
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;

    private static final long serialVersionUID = 1L;
}