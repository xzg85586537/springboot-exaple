package com.cn.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser loadUserByUsername(@Param("username") String username);
}