package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysDeskEntity;

public interface SysDeskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDeskEntity record);

    int insertSelective(SysDeskEntity record);

    SysDeskEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDeskEntity record);

    int updateByPrimaryKey(SysDeskEntity record);
}