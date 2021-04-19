package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.entity.sys.SysMenuEntity;
import com.huiyi.campus.dao.entity.sys.SysRoleEntity;
import com.huiyi.campus.dao.entity.sys.SysRoleMenuEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysRoleMenuMapper;
import io.jsonwebtoken.lang.Collections;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: yzg
 * @time: 2021-04-02 9:17
 * @description: 角色菜单权限
 */
@Repository
public class SysRoleMenuDao {

    private static final Log logger = LogFactory.getLog(SysRoleMenuDao.class);

    SysRoleMenuMapper sysRoleMenuMapper;

    SysRoleMenuDao(SysRoleMenuMapper sysRoleMenuMapper) {
        this.sysRoleMenuMapper = sysRoleMenuMapper;
    }

    public List<SysMenuEntity> selectMenuByUserId(Integer userId) {
        if (null != userId) {
            Integer roleId = sysRoleMenuMapper.selectRoleIdByUserId(userId);
            if (null != roleId) {
                return sysRoleMenuMapper.selectMenuById(userId);
            } else {
                return null;
            }
        }
        return sysRoleMenuMapper.selectAllMenu(null);
    }

    public List<SysRoleEntity> getAllRole(SysRoleEntity sysRoleEntity) {
        List<SysRoleEntity> list = sysRoleMenuMapper.selectAllRole(sysRoleEntity.getRoleName());
        if (!Collections.isEmpty(list)) {
            List<Integer> idList = list.stream().map(SysRoleEntity::getId).collect(Collectors.toList());
            List<SysRoleEntity> adminList = list.stream().filter(x -> x.getId().equals(1)).collect(Collectors.toList());
            if (!Collections.isEmpty(adminList)) {
                adminList.get(0).setMenuIds(sysRoleMenuMapper.selectAllMenu(null).stream().map(SysMenuEntity::getId).collect(Collectors.toList()));
            }
            List<SysRoleMenuEntity> menuList = sysRoleMenuMapper.selectMenuByRoleId(idList);
            if (!Collections.isEmpty(menuList)) {
                Map<Integer, List<SysRoleMenuEntity>> map = menuList.stream().collect(Collectors.groupingBy(SysRoleMenuEntity::getRoleId));
                for (SysRoleEntity sysRole : list) {
                    Integer roleId = sysRole.getId();
                    if (1 != roleId) {
                        List<SysRoleMenuEntity> menus = map.get(roleId);
                        if (!Collections.isEmpty(menus)) {
                            sysRole.setMenuIds(menus.stream().map(SysRoleMenuEntity::getMenuId).collect(Collectors.toList()));
                        }
                    }
                }
            }
        }
        return list;
    }

    public int insertRoleInfo(SysRoleEntity sysRoleEntity) {
        int i = sysRoleMenuMapper.insertRoleInfo(sysRoleEntity);
        if (i > 0) {
            Integer roleId = sysRoleEntity.getId();
            List<Integer> menuIds = sysRoleEntity.getMenuIds();
            if (!Collections.isEmpty(menuIds)) {
                sysRoleMenuMapper.insertRoleMenuInfo(roleId, menuIds);
                logger.info("新增的角色ID为：" + roleId + ", 菜单权限为：" + menuIds);
            }
        }
        return i;
    }

    public int updateRoleInfo(SysRoleEntity sysRoleEntity) {
        Integer roleId = sysRoleEntity.getId();
        int id = sysRoleMenuMapper.updateRoleInfo(sysRoleEntity);
        List<Integer> idList = sysRoleEntity.getMenuIds();
        if (!Collections.isEmpty(idList)) {
            if (null != roleId) {
                sysRoleMenuMapper.deleteMenuByRoleId(roleId);
            }
            sysRoleMenuMapper.insertRoleMenuInfo(roleId, idList);
            logger.info("修改的角色ID为：" + roleId + ", 新的菜单权限ID为：" + idList);
        }
        return id;
    }

    public int deleteRoleInfo(Integer id) {
        int i = sysRoleMenuMapper.deleteRoleInfo(id);
        return i > 0 ? sysRoleMenuMapper.deleteMenuByRoleId(id) : i;
    }

    public List<SysMenuEntity> getAllMenu(SysMenuEntity sysMenuEntity) {
        return sysRoleMenuMapper.selectAllMenu(sysMenuEntity.getMenuName());
    }

    public int insertMenuInfo(SysMenuEntity sysMenuEntity) {
        return sysRoleMenuMapper.insertMenuInfo(sysMenuEntity);
    }

    public int updateMenuInfo(SysMenuEntity sysMenuEntity) {
        return sysRoleMenuMapper.updateMenuInfo(sysMenuEntity);
    }

    public int deleteMenuInfo(Integer id) {
        return sysRoleMenuMapper.deleteMenuInfo(id);
    }

}
