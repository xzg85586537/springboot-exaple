package com.cn.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * sys_user
 * @author 
 */
@Data
@TableName("sys_user")
public class SysUser extends Model<SysUser> implements UserDetails,Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 自己定义！！！
     */
    private List<SysRole> authorities;

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    /**
     * 用户账号是否过期
     */

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户账号是否被锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户密码是否过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否可用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}