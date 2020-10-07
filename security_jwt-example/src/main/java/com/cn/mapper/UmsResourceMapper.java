package com.cn.mapper;


import com.cn.pojo.UmsResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UmsResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsResource record);

    int insertSelective(UmsResource record);

    UmsResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsResource record);

    int updateByPrimaryKey(UmsResource record);




    List<UmsResource> listAll();

}