package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysMenuEntity;
import com.huiyi.campus.dao.entity.sys.SysRoleEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysRoleMenuDao;
import com.huiyi.campus.web.sys.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
     * @param sysRoleEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody getAllRole(SysRoleEntity sysRoleEntity) {
        return ResultBody.success(sysRoleMenuDao.getAllRole(sysRoleEntity));
    }

    /**
     * 新增角色
     * @param sysRoleEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody insertRoleInfo(SysRoleEntity sysRoleEntity) {
        return ResultBody.insert(sysRoleMenuDao.insertRoleInfo(sysRoleEntity), sysRoleEntity.getId());
    }

    /**
     * 修改角色
     * @param sysRoleEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateRoleInfo(SysRoleEntity sysRoleEntity) {
        return ResultBody.update(sysRoleMenuDao.updateRoleInfo(sysRoleEntity));
    }

    /**
     * 删除角色
     * @param id 参数
     * @return 返回值
     */
    @Override
    public ResultBody deleteRoleInfo(Integer id) {
        return ResultBody.delete(sysRoleMenuDao.deleteRoleInfo(id));
    }

    /**
     * 获取所有菜单
     * @param sysMenuEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody getAllMenu(SysMenuEntity sysMenuEntity) {
        List<SysMenuEntity> list = sysRoleMenuDao.getAllMenu(sysMenuEntity);
        Map<Integer, List<SysMenuEntity>> map = list.stream().collect(Collectors.groupingBy(SysMenuEntity::getParentId));
        for (Integer parentId : map.keySet()) {
            List<SysMenuEntity> result = map.get(parentId);
            if (!CollectionUtils.isEmpty(result)) {
                for (SysMenuEntity firstMenu : result) {
                    List<SysMenuEntity> resultList = map.get(firstMenu.getId());
                    if (!CollectionUtils.isEmpty(resultList)) {
                        for (SysMenuEntity secondMenu : resultList) {
                            List<SysMenuEntity> menuList = map.get(secondMenu.getId());
                            if (!CollectionUtils.isEmpty(menuList)) {
                                secondMenu.setList(menuList);
                            } else {
                                firstMenu.setList(resultList);
                            }
                        }
                    }
                }
            }
            return ResultBody.success(result);
        }
        return ResultBody.success();
    }

    /**
     * 新增菜单
     * @param sysMenuEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody insertMenuInfo(SysMenuEntity sysMenuEntity) {
        return ResultBody.insert(sysRoleMenuDao.insertMenuInfo(sysMenuEntity), sysMenuEntity.getId());
    }

    /**
     * 修改菜单
     * @param sysMenuEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateMenuInfo(SysMenuEntity sysMenuEntity) {
        return ResultBody.update(sysRoleMenuDao.updateMenuInfo(sysMenuEntity));
    }

    /**
     * 删除菜单
     * @param id 参数
     * @return 返回值
     */
    @Override
    public ResultBody deleteMenuInfo(Integer id) {
        return ResultBody.delete(sysRoleMenuDao.deleteMenuInfo(id));
    }

}
