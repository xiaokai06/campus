package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysMenuEntity;
import com.huiyi.campus.dao.entity.sys.SysRoleEntity;

import java.util.List;

public interface SysRoleMenuMapper {

    List<Integer> selectMenuById(Integer userId);

    List<SysRoleEntity> selectAllRole(String roleName);

    int insertRoleInfo(SysRoleEntity sysRoleEntity);

    int updateRoleInfo(SysRoleEntity sysRoleEntity);

    int deleteRoleInfo(Integer id);

    List<SysMenuEntity> selectAllMenu(String menuName);

    int insertMenuInfo(SysMenuEntity sysMenuEntity);

    int updateMenuInfo(SysMenuEntity sysMenuEntity);

    int deleteMenuInfo(Integer id);

}