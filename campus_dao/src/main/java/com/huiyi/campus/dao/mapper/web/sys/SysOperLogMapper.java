package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysOperLogEntity;

public interface SysOperLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOperLogEntity record);

    int insertSelective(SysOperLogEntity record);

    SysOperLogEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOperLogEntity record);

    int updateByPrimaryKey(SysOperLogEntity record);
}