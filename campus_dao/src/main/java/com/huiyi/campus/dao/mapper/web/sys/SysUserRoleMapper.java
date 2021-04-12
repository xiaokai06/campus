package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysUserEntity;

public interface SysUserRoleMapper {
    /**
     * 新增用户-角色关联表信息
     * @param sysUserEntity
     * @return
     */
    int insertUserRole(SysUserEntity sysUserEntity);

    /**
     * 修改用户-角色关联表信息
     * @param sysUserEntity
     * @return
     */
    int updateUserRole(SysUserEntity sysUserEntity);

    /**
     * 删除用户-角色关联表信息
     * @param id
     * @return
     */
    int deleteUserRole(Integer id);
}