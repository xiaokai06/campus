package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;

public interface SysSchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysSchoolEntity record);

    int insertSelective(SysSchoolEntity record);

    SysSchoolEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysSchoolEntity record);

    int updateByPrimaryKey(SysSchoolEntity record);
}