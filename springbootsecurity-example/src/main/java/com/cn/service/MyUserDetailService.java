package com.cn.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.entity.SysRole;
import com.cn.entity.SysUser;
import com.cn.mapper.SysRoleMapper;
import com.cn.mapper.SysUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname MyUserDetailService
 * @Description
 * @Date 2020/3/6 11:33
 * @Author by xiao
 * 自定义认证逻辑
 */
@Service
@AllArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    private SysUserMapper userMapper;
    private SysRoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        SysUser user = userMapper.loadUserByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SysRole> roleList = roleMapper.getRoles(user.getId());
        user.setAuthorities(roleList);
        return user;
    }
}
