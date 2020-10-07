package com.cn.mapper;

import com.cn.pojo.UmsAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface UmsAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin record);

    int insertSelective(UmsAdmin record);

    UmsAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdmin record);

    int updateByPrimaryKey(UmsAdmin record);



    UmsAdmin getAdminByUserName(String username);
}