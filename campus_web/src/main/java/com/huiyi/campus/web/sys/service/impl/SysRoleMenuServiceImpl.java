package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysMenuEntity;
import com.huiyi.campus.dao.entity.sys.SysRoleEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysRoleMenuDao;
import com.huiyi.campus.web.sys.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yzg
 * @time: 2021-04-02 9:16
 * @description: 角色-菜单管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    SysRoleMenuDao sysRoleMenuDao;

    SysRoleMenuServiceImpl(SysRoleMenuDao sysRoleMenuDao) {
        this.sysRoleMenuDao = sysRoleMenuDao;
    }

    /**
     * 获取所有角色
     * @param sysRoleEntity
     * @return
     */
    @Override
    public ResultBody getAllRole(SysRoleEntity sysRoleEntity) {
        return ResultBody.success(sysRoleMenuDao.getAllRole(sysRoleEntity));
    }

    /**
     * 新增角色
     * @param sysRoleEntity
     * @return
     */
    @Override
    public ResultBody insertRoleInfo(SysRoleEntity sysRoleEntity) {
        return ResultBody.insert(sysRoleMenuDao.insertRoleInfo(sysRoleEntity), sysRoleEntity.getId());
    }

    /**
     * 修改角色
     * @param sysRoleEntity
     * @return
     */
    @Override
    public ResultBody updateRoleInfo(SysRoleEntity sysRoleEntity) {
        return ResultBody.update(sysRoleMenuDao.updateRoleInfo(sysRoleEntity));
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @Override
    public ResultBody deleteRoleInfo(Integer id) {
        return ResultBody.delete(sysRoleMenuDao.deleteRoleInfo(id));
    }

    /**
     * 获取所有菜单
     * @param sysMenuEntity
     * @return
     */
    @Override
    public ResultBody getAllMenu(SysMenuEntity sysMenuEntity) {
        return ResultBody.success(sysRoleMenuDao.getAllMenu(sysMenuEntity));
    }

    /**
     * 新增菜单
     * @param sysMenuEntity
     * @return
     */
    @Override
    public ResultBody insertMenuInfo(SysMenuEntity sysMenuEntity) {
        return ResultBody.insert(sysRoleMenuDao.insertMenuInfo(sysMenuEntity), sysMenuEntity.getId());
    }

    /**
     * 修改菜单
     * @param sysMenuEntity
     * @return
     */
    @Override
    public ResultBody updateMenuInfo(SysMenuEntity sysMenuEntity) {
        return ResultBody.update(sysRoleMenuDao.updateMenuInfo(sysMenuEntity));
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @Override
    public ResultBody deleteMenuInfo(Integer id) {
        return ResultBody.delete(sysRoleMenuDao.deleteMenuInfo(id));
    }

}
