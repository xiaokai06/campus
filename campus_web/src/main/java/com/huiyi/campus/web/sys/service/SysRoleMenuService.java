package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysMenuEntity;
import com.huiyi.campus.dao.entity.sys.SysRoleEntity;

/**
 * @author: yzg
 * @time: 2021-04-02 9:15
 * @description: 角色菜单管理
 */
public interface SysRoleMenuService {

    /**
     * 获取该用户所拥有的菜单权限
     * @param nickName
     * @return
     */
    ResultBody getMenuByUserId(String nickName);

    /**
     * 获取所有角色
     * @param sysRoleEntity
     * @return
     */
    ResultBody getAllRole(SysRoleEntity sysRoleEntity);

    /**
     * 新增角色信息
     * @param sysRoleEntity
     * @return
     */
    ResultBody insertRoleInfo(SysRoleEntity sysRoleEntity);

    /**
     * 修改角色信息
     * @param sysRoleEntity
     * @return
     */
    ResultBody updateRoleInfo(SysRoleEntity sysRoleEntity);

    /**
     * 删除角色信息
     * @param id
     * @return
     */
    ResultBody deleteRoleInfo(Integer id);

    /**
     * 获取所有菜单信息
     * @param sysMenuEntity
     * @return
     */
    ResultBody getAllMenu(SysMenuEntity sysMenuEntity);

    /**
     * 新增菜单信息
     * @param sysMenuEntity
     * @return
     */
    ResultBody insertMenuInfo(SysMenuEntity sysMenuEntity);

    /**
     * 修改菜单信息
     * @param sysMenuEntity
     * @return
     */
    ResultBody updateMenuInfo(SysMenuEntity sysMenuEntity);

    /**
     * 删除菜单信息
     * @param id
     * @return
     */
    ResultBody deleteMenuInfo(Integer id);

}
