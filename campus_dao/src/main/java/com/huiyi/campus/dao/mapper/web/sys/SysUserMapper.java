package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;

import java.util.List;

public interface SysUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(SysUserEntity record);

    int updateByPrimaryKeySelective(SysUserEntity record);

    SysUserEntity selectUserInfoByNickName(String nickName);

    Integer updatePwdByNickName(UpdatePwdDto updatePwdDto);

    List<SysUserEntity> selectAllUserInfo(SysUserEntity sysUserEntity);

    int insertUserRole(SysUserEntity sysUserEntity);

    int updateUserRole(SysUserEntity sysUserEntity);

    int deleteUserRole(Integer id);
}