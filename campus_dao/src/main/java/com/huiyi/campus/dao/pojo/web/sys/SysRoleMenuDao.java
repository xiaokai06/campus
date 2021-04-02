package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.dto.sys.MenuDto;
import com.huiyi.campus.dao.dto.sys.RoleDto;
import com.huiyi.campus.dao.entity.sys.SysMenuEntity;
import com.huiyi.campus.dao.entity.sys.SysRoleEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysRoleMenuMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: yzg
 * @time: 2021-04-02 9:17
 * @description: 角色菜单权限
 */
@Repository
public class SysRoleMenuDao {

    SysRoleMenuMapper sysRoleMenuMapper;

    SysRoleMenuDao(SysRoleMenuMapper sysRoleMenuMapper) {
        this.sysRoleMenuMapper = sysRoleMenuMapper;
    }

    public List<Integer> selectMenuByUserId(Integer userId) {
        if (null != userId) {
            return sysRoleMenuMapper.selectMenuById(userId);
        }
        return sysRoleMenuMapper.selectAllMenu(null).stream().map(SysMenuEntity::getId).collect(Collectors.toList());
    }

    public List<SysRoleEntity> getAllRole(RoleDto roleDto) {
        return sysRoleMenuMapper.selectAllRole(roleDto);
    }

    public int insertRoleInfo(SysRoleEntity sysRoleEntity) {
        return sysRoleMenuMapper.insertRoleInfo(sysRoleEntity);
    }

    public int updateRoleInfo(SysRoleEntity sysRoleEntity) {
        return sysRoleMenuMapper.updateRoleInfo(sysRoleEntity);
    }

    public int deleteRoleInfo(Integer id) {
        return sysRoleMenuMapper.deleteRoleInfo(id);
    }

    public List<SysMenuEntity> getAllMenu(MenuDto menuDto) {
        return sysRoleMenuMapper.selectAllMenu(menuDto.getMenuName());
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
