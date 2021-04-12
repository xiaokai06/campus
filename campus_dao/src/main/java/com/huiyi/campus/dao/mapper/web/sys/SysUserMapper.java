package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;

import java.util.List;

public interface SysUserMapper {

    /**
     * 通过主键ID删除用户（更新del_flag字段）
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增用户
     * @param sysUserEntity
     * @return
     */
    int insertSelective(SysUserEntity sysUserEntity);

    /**
     * 修改用户
     * @param sysUserEntity
     * @return
     */
    int updateByPrimaryKeySelective(SysUserEntity sysUserEntity);

    /**
     * 通过用户昵称查询用户信息
     * @param nickName
     * @return
     */
    SysUserEntity selectUserInfoByNickName(String nickName);

    /**
     * 通过用户昵称修改密码
     * @param updatePwdDto
     * @return
     */
    int updatePwdByNickName(UpdatePwdDto updatePwdDto);

    /**
     * 查询所有用户
     * @param sysUserEntity
     * @return
     */
    List<SysUserEntity> selectAllUserInfo(SysUserEntity sysUserEntity);
}