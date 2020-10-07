package com.cn.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.cn.bo.AdminUserDetails;
import com.cn.mapper.UmsAdminMapper;
import com.cn.mapper.UmsAdminRoleRelationMapper;
import com.cn.pojo.UmsAdmin;
import com.cn.pojo.UmsResource;
import com.cn.service.UmsAdminService;
import com.cn.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author xiao
 * @Date 2020-10-07 19:47
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements UmsAdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UmsAdmin admin = getAdminByUserName(username);
        if (admin != null) {
            List<UmsResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin, resourceList);
        }
        throw new UsernameNotFoundException("用户名或者密码错误");
    }

    private List<UmsResource> getResourceList(Long adminId) {
        //用户、角色、资源关联
        List<UmsResource> resourceList = adminRoleRelationMapper.getResoucrByAdminId(adminId);
        if (CollectionUtil.isNotEmpty(resourceList)) {
            return resourceList;
        }
        return null;
    }

    private UmsAdmin getAdminByUserName(String username) {
        return adminMapper.getAdminByUserName(username);
    }

    public String login(String userName, String passWord) {
        String token = null;
        try {
            UserDetails userDetails = loadUserByUsername(userName);
            if (!passwordEncoder.matches(passWord, userDetails.getPassword())) {
                throw new RuntimeException("密码不正确");
            }
            if (!userDetails.isEnabled()) {
                throw new RuntimeException("账号已被停用，请联系管理员");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (RuntimeException e) {
            logger.warn("登录异常信息：{}", e.getMessage());
        }
        return token;
    }

}
