package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysDoctorEntity;

public interface SysDoctorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDoctorEntity record);

    int insertSelective(SysDoctorEntity record);

    SysDoctorEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDoctorEntity record);

    int updateByPrimaryKey(SysDoctorEntity record);
}