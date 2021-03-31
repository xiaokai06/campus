package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.annotaion.PassToken;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.dto.sys.SysUserDto;
import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.web.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yzg
 * @time: 2021-03-30 9:57
 * @description:
 */
@Api("综合管理")
@RestController
@RequestMapping("/user")
public class SysUserController {

    SysUserService sysUserService;

    SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @PassToken
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ResultBody login(@RequestBody SysUserDto sysUserDto) {
        return sysUserService.selectUserInfoByNickName(sysUserDto);
    }

    @IsLogin
    @ApiOperation("用户退出")
    @PostMapping("/exit")
    public ResultBody exit(@RequestBody SysUserDto sysUserDto) {
        return sysUserService.exitSystem(sysUserDto.getNickName());
    }

    @IsLogin
    @ApiOperation("修改密码")
    @PostMapping("/updatePwd")
    public ResultBody updatePwd(@RequestBody UpdatePwdDto updatePwdDto) {
        return sysUserService.updatePwdByOldPwd(updatePwdDto);
    }

}
