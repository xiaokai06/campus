package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysSchoolStudentEntity;

public interface SysSchoolStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysSchoolStudentEntity record);

    int insertSelective(SysSchoolStudentEntity record);

    SysSchoolStudentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysSchoolStudentEntity record);

    int updateByPrimaryKey(SysSchoolStudentEntity record);
}