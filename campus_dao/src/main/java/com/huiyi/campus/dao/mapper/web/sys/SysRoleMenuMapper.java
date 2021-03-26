package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysRoleMenuEntity;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleMenuEntity record);

    int insertSelective(SysRoleMenuEntity record);

    SysRoleMenuEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleMenuEntity record);

    int updateByPrimaryKey(SysRoleMenuEntity record);
}