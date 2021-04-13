package com.huiyi.campus.dao.pojo.web.sys;

import com.github.pagehelper.PageHelper;
import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysUserMapper;
import com.huiyi.campus.dao.mapper.web.sys.SysUserRoleMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-03-30 10:02
 * @description: 用户管理
 */
@Repository
public class SysUserDao {

    private static final Log logger = LogFactory.getLog(SysUserDao.class);

    SysUserMapper sysUserMapper;
    SysUserRoleMapper sysUserRoleMapper;

    SysUserDao(SysUserMapper sysUserMapper, SysUserRoleMapper sysUserRoleMapper) {
        this.sysUserMapper = sysUserMapper;
        this.sysUserRoleMapper = sysUserRoleMapper;
    }

    /**
     * 通过用户昵称查询用户信息
     * @param nickName 参数
     * @return 返回值
     */
    public SysUserEntity selectUserByNickName(String nickName) {
        return sysUserMapper.selectUserInfoByNickName(nickName);
    }

    /**
     * 修改密码
     * @param updatePwdDto 参数
     * @return 返回值
     */
    public int updateUserPwd(UpdatePwdDto updatePwdDto) {
        return sysUserMapper.updatePwdByNickName(updatePwdDto);
    }

    /**
     * 查询所有用户信息
     * @param sysUserEntity 参数
     * @return 返回值
     */
    public List<SysUserEntity> selectAllUserInfo(SysUserEntity sysUserEntity) {
        PageHelper.startPage(sysUserEntity.getPageNum(), sysUserEntity.getPageSize());
        return sysUserMapper.selectAllUserInfo(sysUserEntity);
    }

    /**
     * 新增用户
     * @param sysUserEntity 参数
     * @return 返回值
     */
    public int insertUserInfo(SysUserEntity sysUserEntity) {
        int i = sysUserMapper.insertSelective(sysUserEntity);
        if (i > 0) {
            logger.info("新增用户，用户id：" + sysUserEntity.getId() + ", 角色id:" + sysUserEntity.getRoleId());
            sysUserRoleMapper.insertUserRole(sysUserEntity);
        }
        return i;
    }

    /**
     * 修改用户
     * @param sysUserEntity 参数
     * @return 返回值
     */
    public int updateUserInfo(SysUserEntity sysUserEntity) {
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUserEntity);
        if (i > 0) {
            sysUserRoleMapper.updateUserRole(sysUserEntity);
        }
        return i;
    }

    /**
     * 通过ID删除用户
     * @param id 参数
     * @return 返回值
     */
    public int deleteUserInfoById(Integer id) {
        int i = sysUserMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            sysUserRoleMapper.deleteUserRole(id);
        }
        return i;
    }

}
