package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;

/**
 * @author: yzg
 * @time: 2021-03-30 9:59
 * @description: 用户管理
 */
public interface SysUserService {

    /**
     * 通过用户昵称查询用户信息
     * @param sysUserEntity
     * @return
     */
    ResultBody selectUserInfoByNickName(SysUserEntity sysUserEntity);

    /**
     * 退出系统
     * @param nickName
     * @return
     */
    ResultBody exitSystem(String nickName);

    /**
     * 修改密码
     * @param updatePwdDto
     * @return
     */
    ResultBody updatePwdByOldPwd(UpdatePwdDto updatePwdDto);

    /**
     * 获取该用户所拥有的菜单权限
     * @param nickName
     * @return
     */
    ResultBody getMenuByUserId(String nickName);

    /**
     * 获取所有用户
     * @param sysUserEntity
     * @return
     */
    CrRpcResult getAllUserInfo(SysUserEntity sysUserEntity);

    /**
     * 新增用户
     * @param sysUserEntity
     * @return
     */
    ResultBody insertUserInfo(SysUserEntity sysUserEntity);

    /**
     * 修改用户
     * @param sysUserEntity
     * @return
     */
    ResultBody updateUserInfo(SysUserEntity sysUserEntity);

    /**
     * 删除用户
     * @param id
     * @return
     */
    ResultBody deleteUserInfoById(Integer id);

    /**
     * 重置密码
     * @param updatePwdDto
     * @return
     */
    ResultBody resetPwd(UpdatePwdDto updatePwdDto);

}
