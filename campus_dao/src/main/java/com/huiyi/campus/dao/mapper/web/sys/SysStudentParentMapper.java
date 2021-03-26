package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysStudentParentEntity;

public interface SysStudentParentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysStudentParentEntity record);

    int insertSelective(SysStudentParentEntity record);

    SysStudentParentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysStudentParentEntity record);

    int updateByPrimaryKey(SysStudentParentEntity record);
}