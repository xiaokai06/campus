package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.annotaion.OperLog;
import com.huiyi.campus.common.annotaion.PassToken;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;
import com.huiyi.campus.web.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


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
    @OperLog(operModule = "用户管理-退出", operType = CommConstants.EXIT, operDesc = "用户管理-退出登录")
    public ResultBody exit(@RequestBody SysUserEntity sysUserEntity) {
        return sysUserService.exitSystem(sysUserEntity.getNickName());
    }

    @IsLogin
    @ApiOperation("修改密码")
    @PostMapping("/updatePwd")
    @OperLog(operModule = "用户管理-修改密码", operType = CommConstants.UPDATE, operDesc = "用户管理-修改密码")
    public ResultBody updatePwd(@RequestBody UpdatePwdDto updatePwdDto) {
        return sysUserService.updatePwdByOldPwd(updatePwdDto);
    }

    @IsLogin
    @ApiOperation("重置密码")
    @PostMapping("/resetPwd")
    @OperLog(operModule = "用户管理-重置密码", operType = CommConstants.RESET, operDesc = "用户管理-重置密码")
    public ResultBody resetPwd(@RequestBody UpdatePwdDto updatePwdDto) {
        return sysUserService.resetPwd(updatePwdDto);
    }

    @IsLogin
    @ApiOperation("通过用户昵称获取菜单权限")
    @GetMapping("/getMenuByNickName")
    public ResultBody getMenuByNickName(@RequestParam String nickName) {
        return sysUserService.getMenuByUserId(nickName);
    }

    @IsLogin
    @ApiOperation("获取所有用户信息")
    @PostMapping("/getAllUserInfo")
    public CrRpcResult getAllUserInfo(@RequestBody SysUserEntity sysUserEntity, HttpServletRequest request) {
        String nickName = request.getHeader(CommConstants.ACC);
        return sysUserService.getAllUserInfo(nickName, sysUserEntity);
    }

    @IsLogin
    @ApiOperation("新增用户")
    @PostMapping("/insertUserInfo")
    @OperLog(operModule = "用户管理-新增", operType = CommConstants.ADD, operDesc = "用户管理-新增用户")
    public ResultBody insertUserInfo(@RequestBody SysUserEntity sysUserEntity) {
        return sysUserService.insertUserInfo(sysUserEntity);
    }

    @IsLogin
    @ApiOperation("修改用户")
    @PostMapping("/updateUserInfo")
    @OperLog(operModule = "用户管理-修改", operType = CommConstants.UPDATE, operDesc = "用户管理-修改用户")
    public ResultBody updateUserInfo(@RequestBody SysUserEntity sysUserEntity) {
        return sysUserService.updateUserInfo(sysUserEntity);
    }

    @IsLogin
    @ApiOperation("删除用户")
    @GetMapping("/deleteUserInfo")
    @OperLog(operModule = "用户管理-删除", operType = CommConstants.DELETE, operDesc = "用户管理-删除用户")
    public ResultBody deleteUserInfo(@RequestParam Integer id) {
        return sysUserService.deleteUserInfoById(id);
    }

}
