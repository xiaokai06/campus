package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysLoginLogEntity;

public interface SysLoginLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysLoginLogEntity record);

    int insertSelective(SysLoginLogEntity record);

    SysLoginLogEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysLoginLogEntity record);

    int updateByPrimaryKey(SysLoginLogEntity record);
}