package com.cn.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ums_resource
 * @author 
 */
@Data
public class UmsResource implements Serializable {
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源URL
     */
    private String url;

    /**
     * 描述
     */
    private String description;

    /**
     * 资源分类ID
     */
    private Long categoryId;

    private static final long serialVersionUID = 1L;
}