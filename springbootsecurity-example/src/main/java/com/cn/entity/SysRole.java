package com.cn.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * sys_role
 * @author 
 */
@Data
@TableName("sys_role")
public class SysRole implements Serializable, GrantedAuthority {
    private Integer id;

    /**
     * 角色名
     */
    private String roleName;

    private static final long serialVersionUID = 1L;

    @Override
    public String getAuthority() {
        return roleName;
    }
}