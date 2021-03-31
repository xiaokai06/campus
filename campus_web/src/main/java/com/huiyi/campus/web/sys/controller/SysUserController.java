package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.PassToken;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.utils.StringUtils;
import com.huiyi.campus.dao.dto.sys.SysUserDto;
import com.huiyi.campus.web.sys.service.SysUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yzg
 * @time: 2021-03-30 9:57
 * @description:
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    SysUserService sysUserService;

    SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @PassToken
    @PostMapping("/login")
    public ResultBody login(@RequestBody SysUserDto sysUserDto) {
        String pwd = sysUserDto.getPwd();
        String nickName = sysUserDto.getNickName();
        String passWord = sysUserService.selectUserInfoByNickName(nickName);
        if (!StringUtils.isEmpty(passWord) && pwd.equals(passWord)) {
            return ResultBody.success("登录成功！");
        }
        return ResultBody.error("登录失败！");
    }

}
