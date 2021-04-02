package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.dto.sys.MenuDto;
import com.huiyi.campus.dao.dto.sys.RoleDto;
import com.huiyi.campus.dao.entity.sys.SysMenuEntity;
import com.huiyi.campus.dao.entity.sys.SysRoleEntity;

/**
 * @author: yzg
 * @time: 2021-04-02 9:15
 * @description:
 */
public interface SysRoleMenuService {

    ResultBody getMenuByUserId(String nickName);

    ResultBody getAllRole(RoleDto roleDto);

    ResultBody insertRoleInfo(SysRoleEntity sysRoleEntity);

    ResultBody updateRoleInfo(SysRoleEntity sysRoleEntity);

    ResultBody deleteRoleInfo(Integer id);

    ResultBody getAllMenu(MenuDto menuDto);

    ResultBody insertMenuInfo(SysMenuEntity sysMenuEntity);

    ResultBody updateMenuInfo(SysMenuEntity sysMenuEntity);

    ResultBody deleteMenuInfo(Integer id);

}
