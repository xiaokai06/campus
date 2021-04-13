package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.annotaion.OperLog;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.dao.entity.sys.SysMenuEntity;
import com.huiyi.campus.dao.entity.sys.SysRoleEntity;
import com.huiyi.campus.web.sys.service.SysRoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yzg
 * @time: 2021-04-02 9:11
 * @description: 角色菜单管理
 */
@Api(tags = "角色菜单管理")
@RestController
@RequestMapping("/role")
@CrossOrigin
public class SysRoleMenuController {

    SysRoleMenuService sysRoleMenuService;

    SysRoleMenuController(SysRoleMenuService sysRoleMenuService) {
        this.sysRoleMenuService = sysRoleMenuService;
    }

    @IsLogin
    @ApiOperation("查询所有角色")
    @PostMapping("/getAllRole")
    public ResultBody getAllRole(@RequestBody SysRoleEntity sysRoleEntity) {
        return sysRoleMenuService.getAllRole(sysRoleEntity);
    }

    @IsLogin
    @ApiOperation("新增角色")
    @PostMapping("/insertRoleInfo")
    @OperLog(operModule = "角色管理-新增", operType = CommConstants.ADD, operDesc = "角色管理-新增角色")
    public ResultBody insertRoleInfo(@RequestBody SysRoleEntity sysRoleEntity) {
        return sysRoleMenuService.insertRoleInfo(sysRoleEntity);
    }

    @IsLogin
    @ApiOperation("修改角色")
    @PostMapping("/updateRoleInfo")
    @OperLog(operModule = "角色管理-修改", operType = CommConstants.UPDATE, operDesc = "角色管理-修改角色")
    public ResultBody updateRoleInfo(@RequestBody SysRoleEntity sysRoleEntity) {
        return sysRoleMenuService.updateRoleInfo(sysRoleEntity);
    }

    @IsLogin
    @ApiOperation("删除角色")
    @GetMapping("/deleteRoleInfo")
    @OperLog(operModule = "角色管理-删除", operType = CommConstants.DELETE, operDesc = "角色管理-删除角色")
    public ResultBody deleteRoleInfo(@RequestParam Integer id) {
        return sysRoleMenuService.deleteRoleInfo(id);
    }

    @IsLogin
    @ApiOperation("查询所有菜单")
    @PostMapping("/getAllMenu")
    public ResultBody selectAllMenu(@RequestBody SysMenuEntity sysMenuEntity) {
        return sysRoleMenuService.getAllMenu(sysMenuEntity);
    }

    @IsLogin
    @ApiOperation("新增菜单")
    @PostMapping("/insertMenuInfo")
    @OperLog(operModule = "菜单管理-新增", operType = CommConstants.ADD, operDesc = "菜单管理-新增菜单")
    public ResultBody insertMenuInfo(@RequestBody SysMenuEntity sysMenuEntity) {
        return sysRoleMenuService.insertMenuInfo(sysMenuEntity);
    }

    @IsLogin
    @ApiOperation("修改菜单")
    @PostMapping("/updateMenuInfo")
    @OperLog(operModule = "菜单管理-修改", operType = CommConstants.UPDATE, operDesc = "菜单管理-修改菜单")
    public ResultBody updateMenuInfo(@RequestBody SysMenuEntity sysMenuEntity) {
        return sysRoleMenuService.updateMenuInfo(sysMenuEntity);
    }

    @IsLogin
    @ApiOperation("删除菜单")
    @GetMapping("/deleteMenuInfo")
    @OperLog(operModule = "菜单管理-删除", operType = CommConstants.DELETE, operDesc = "菜单管理-删除菜单")
    public ResultBody deleteMenuInfo(@RequestParam Integer id) {
        return sysRoleMenuService.deleteMenuInfo(id);
    }

}
