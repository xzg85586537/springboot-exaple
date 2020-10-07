package com.cn.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ums_admin
 * 后台用户表
 * @author
 */
@Data
public class UmsAdmin implements Serializable {
    private Long id;
    private String username;

    private String password;

    private String icon;

    private String email;

    private String nickName;

    private String note;

    private Date createTime;

    private Date loginTime;

    private Integer status;

    private static final long serialVersionUID = 1L;
}