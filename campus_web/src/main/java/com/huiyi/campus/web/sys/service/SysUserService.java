package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.dto.sys.SysUserDto;
import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.dto.sys.UserDto;

/**
 * @author: yzg
 * @time: 2021-03-30 9:59
 * @description:
 */
public interface SysUserService {

    ResultBody selectUserInfoByNickName(SysUserDto sysUserDto);

    ResultBody exitSystem(String nickName);

    ResultBody updatePwdByOldPwd(UpdatePwdDto updatePwdDto);

    ResultBody getAllUserInfo(UserDto userDto);

}
