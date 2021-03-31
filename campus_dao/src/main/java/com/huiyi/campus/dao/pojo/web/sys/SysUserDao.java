package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.dto.sys.UserDto;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-03-30 10:02
 * @description:
 */
@Repository
public class SysUserDao {

    @Autowired
    SysUserMapper sysUserMapper;

    public String selectUserByNickName(String nickName) {
        return sysUserMapper.selectUserInfoByNickName(nickName);
    }

    public Integer updateUserPwd(UpdatePwdDto updatePwdDto) {
        return sysUserMapper.updatePwdByNickName(updatePwdDto);
    }

    public List<SysUserEntity> selectAllUserInfo(UserDto userDto) {
        return sysUserMapper.selectAllUserInfo(userDto);
    }

}
