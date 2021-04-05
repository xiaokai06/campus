package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.dao.entity.sys.SysMenuEntity;
import com.huiyi.campus.dao.entity.sys.SysRoleEntity;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysRoleMenuDao;
import com.huiyi.campus.dao.pojo.web.sys.SysUserDao;
import com.huiyi.campus.web.sys.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-02 9:16
 * @description:
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    SysUserDao sysUserDao;
    SysRoleMenuDao sysRoleMenuDao;

    SysRoleMenuServiceImpl(SysUserDao sysUserDao, SysRoleMenuDao sysRoleMenuDao) {
        this.sysUserDao = sysUserDao;
        this.sysRoleMenuDao = sysRoleMenuDao;
    }

    @Override
    public ResultBody getMenuByUserId(String nickName) {
        List<Integer> menuList;
        if (CommConstants.USER_ADMIN.equals(nickName)) {
            menuList = sysRoleMenuDao.selectMenuByUserId(null);
        } else {
            SysUserEntity sysUserEntity = sysUserDao.selectUserByNickName(nickName);
            Integer userId = sysUserEntity.getId();
            menuList = sysRoleMenuDao.selectMenuByUserId(userId);
        }
        return ResultBody.success(menuList);
    }

    @Override
    public ResultBody getAllRole(SysRoleEntity sysRoleEntity) {
        return ResultBody.success(sysRoleMenuDao.getAllRole(sysRoleEntity));
    }

    @Override
    public ResultBody insertRoleInfo(SysRoleEntity sysRoleEntity) {
        return ResultBody.insert(sysRoleMenuDao.insertRoleInfo(sysRoleEntity), sysRoleEntity.getId());
    }

    @Override
    public ResultBody updateRoleInfo(SysRoleEntity sysRoleEntity) {
        return ResultBody.update(sysRoleMenuDao.updateRoleInfo(sysRoleEntity));
    }

    @Override
    public ResultBody deleteRoleInfo(Integer id) {
        return ResultBody.delete(sysRoleMenuDao.deleteRoleInfo(id));
    }

    @Override
    public ResultBody getAllMenu(SysMenuEntity sysMenuEntity) {
        return ResultBody.success(sysRoleMenuDao.getAllMenu(sysMenuEntity));
    }

    @Override
    public ResultBody insertMenuInfo(SysMenuEntity sysMenuEntity) {
        return ResultBody.insert(sysRoleMenuDao.insertMenuInfo(sysMenuEntity), sysMenuEntity.getId());
    }

    @Override
    public ResultBody updateMenuInfo(SysMenuEntity sysMenuEntity) {
        return ResultBody.update(sysRoleMenuDao.updateMenuInfo(sysMenuEntity));
    }

    @Override
    public ResultBody deleteMenuInfo(Integer id) {
        return ResultBody.delete(sysRoleMenuDao.deleteMenuInfo(id));
    }


}
