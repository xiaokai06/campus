package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysUserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-03-30 10:02
 * @description:
 */
@Repository
public class SysUserDao {

    SysUserMapper sysUserMapper;

    SysUserDao(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    /**
     * 通过用户昵称查询用户信息
     * @param nickName
     * @return
     */
    public SysUserEntity selectUserByNickName(String nickName) {
        return sysUserMapper.selectUserInfoByNickName(nickName);
    }

    /**
     * 修改密码
     * @param updatePwdDto
     * @return
     */
    public Integer updateUserPwd(UpdatePwdDto updatePwdDto) {
        return sysUserMapper.updatePwdByNickName(updatePwdDto);
    }

    /**
     * 查询所有用户信息
     * @param sysUserEntity
     * @return
     */
    public List<SysUserEntity> selectAllUserInfo(SysUserEntity sysUserEntity) {
        return sysUserMapper.selectAllUserInfo(sysUserEntity);
    }

    /**
     * 新增用户
     * @param sysUserEntity
     * @return
     */
    public Integer insertUserInfo(SysUserEntity sysUserEntity) {
        return sysUserMapper.insertSelective(sysUserEntity);
    }

    /**
     * 修改用户
     * @param sysUserEntity
     * @return
     */
    public Integer updateUserInfo(SysUserEntity sysUserEntity) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUserEntity);
    }

    /**
     * 通过ID删除用户
     * @param id
     * @return
     */
    public Integer deleteUserInfoById(Integer id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

}
