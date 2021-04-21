package com.huiyi.campus.dao.mapper.web.sys;


import com.huiyi.campus.dao.entity.sys.SysGradeClassEntity;

import java.util.List;

public interface SysGradeClassMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysGradeClassEntity record);

    int insertSelective(SysGradeClassEntity record);

    SysGradeClassEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysGradeClassEntity record);

    int updateByPrimaryKey(SysGradeClassEntity record);

    List<SysGradeClassEntity> selectGrdeClassList(SysGradeClassEntity sysGradeClassEntity);
}