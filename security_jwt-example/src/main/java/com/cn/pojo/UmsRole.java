package com.cn.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ums_role
 * @author 
 */
@Data
public class UmsRole implements Serializable {
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 后台用户数量
     */
    private Integer adminCount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 启用状态：0->禁用；1->启用
     */
    private Integer status;

    private Integer sort;

    private static final long serialVersionUID = 1L;
}