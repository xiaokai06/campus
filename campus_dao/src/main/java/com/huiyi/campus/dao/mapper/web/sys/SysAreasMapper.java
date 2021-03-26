package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysAreasEntity;

public interface SysAreasMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAreasEntity record);

    int insertSelective(SysAreasEntity record);

    SysAreasEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAreasEntity record);

    int updateByPrimaryKey(SysAreasEntity record);
}