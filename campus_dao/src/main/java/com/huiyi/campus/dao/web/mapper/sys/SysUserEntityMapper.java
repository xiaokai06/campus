package com.huiyi.campus.dao.web.mapper.sys;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserEntityMapper extends BaseMapper<SysUserEntity> {
    int deleteByPrimaryKey(String uid);

    int insert(SysUserEntity record);

    int insertSelective(SysUserEntity record);

    SysUserEntity selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(SysUserEntity record);

    int updateByPrimaryKey(SysUserEntity record);
}