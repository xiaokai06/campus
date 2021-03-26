package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysParentEntity;

public interface SysParentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysParentEntity record);

    int insertSelective(SysParentEntity record);

    SysParentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysParentEntity record);

    int updateByPrimaryKey(SysParentEntity record);
}