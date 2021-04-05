package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.annotaion.PassToken;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;
import com.huiyi.campus.web.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


/**
 * @author: yzg
 * @time: 2021-03-30 9:57
 * @description: 用户管理
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
@CrossOrigin
public class SysUserController {

    SysUserService sysUserService;

    SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @PassToken
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ResultBody login(@RequestBody SysUserEntity sysUserEntity) {
        return sysUserService.selectUserInfoByNickName(sysUserEntity);
    }

    @IsLogin
    @ApiOperation("用户退出")
    @PostMapping("/exit")
    public ResultBody exit(@RequestBody SysUserEntity sysUserEntity) {
        return sysUserService.exitSystem(sysUserEntity.getNickName());
    }

    @IsLogin
    @ApiOperation("修改密码")
    @PostMapping("/updatePwd")
    public ResultBody updatePwd(@RequestBody UpdatePwdDto updatePwdDto) {
        return sysUserService.updatePwdByOldPwd(updatePwdDto);
    }

    @IsLogin
    @ApiOperation("获取所有用户信息")
    @PostMapping("/getAllUserInfo")
    public ResultBody getAllUserInfo(@RequestBody SysUserEntity sysUserEntity) {
        return sysUserService.getAllUserInfo(sysUserEntity);
    }

    @IsLogin
    @ApiOperation("新增用户")
    @PostMapping("/insertUserInfo")
    public ResultBody insertUserInfo(@RequestBody SysUserEntity sysUserEntity) {
        return sysUserService.insertUserInfo(sysUserEntity);
    }

    @IsLogin
    @ApiOperation("修改用户")
    @PostMapping("/updateUserInfo")
    public ResultBody updateUserInfo(@RequestBody SysUserEntity sysUserEntity) {
        return sysUserService.updateUserInfo(sysUserEntity);
    }

    @IsLogin
    @ApiOperation("删除用户")
    @GetMapping("/deleteUserInfo")
    public ResultBody deleteUserInfo(@RequestParam Integer id) {
        return sysUserService.deleteUserInfoById(id);
    }

}
