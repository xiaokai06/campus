package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.dto.sys.UserDto;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;

import java.util.List;

public interface SysUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserEntity record);

    int insertSelective(SysUserEntity record);

    SysUserEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUserEntity record);

    int updateByPrimaryKey(SysUserEntity record);

    SysUserEntity selectUserInfoByNickName(String nickName);

    Integer updatePwdByNickName(UpdatePwdDto updatePwdDto);

    List<SysUserEntity> selectAllUserInfo(UserDto userDto);

}