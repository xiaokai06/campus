package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysUserRoleEntity;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRoleEntity record);

    int insertSelective(SysUserRoleEntity record);

    SysUserRoleEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRoleEntity record);

    int updateByPrimaryKey(SysUserRoleEntity record);
}