package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysMenuEntity;
import com.huiyi.campus.dao.entity.sys.SysRoleEntity;
import com.huiyi.campus.dao.entity.sys.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMenuMapper {

    /**
     * 通过用户ID查询菜单权限
     * @param userId
     * @return
     */
    List<SysMenuEntity> selectMenuById(Integer userId);

    /**
     * 查询所有的角色
     * @param roleName
     * @return
     */
    List<SysRoleEntity> selectAllRole(String roleName);

    /**
     * 通过角色ID查询菜单权限
     * @param idList
     * @return
     */
    List<SysRoleMenuEntity> selectMenuByRoleId(List<Integer> idList);

    /**
     * 新增角色
     * @param sysRoleEntity
     * @return
     */
    int insertRoleInfo(SysRoleEntity sysRoleEntity);

    /**
     * 修改角色
     * @param sysRoleEntity
     * @return
     */
    int updateRoleInfo(SysRoleEntity sysRoleEntity);

    /**
     * 删除角色
     * @param id
     * @return
     */
    int deleteRoleInfo(Integer id);

    /**
     * 查询所有菜单权限
     * @param menuName
     * @return
     */
    List<SysMenuEntity> selectAllMenu(String menuName);

    /**
     * 新增菜单
     * @param sysMenuEntity
     * @return
     */
    int insertMenuInfo(SysMenuEntity sysMenuEntity);

    /**
     * 修改菜单
     * @param sysMenuEntity
     * @return
     */
    int updateMenuInfo(SysMenuEntity sysMenuEntity);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    int deleteMenuInfo(Integer id);

    /**
     * 新增角色-菜单关联表
     * @param roleId
     * @param list
     * @return
     */
    int insertRoleMenuInfo(@Param("roleId") Integer roleId, @Param("list") List<Integer> list);

    /**
     * 通过角色ID删除对应的菜单权限
     * @param id
     * @return
     */
    int deleteMenuByRoleId(Integer id);

}