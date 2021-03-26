package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysSexAgeRefEntity;

public interface SysSexAgeRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysSexAgeRefEntity record);

    int insertSelective(SysSexAgeRefEntity record);

    SysSexAgeRefEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysSexAgeRefEntity record);

    int updateByPrimaryKey(SysSexAgeRefEntity record);
}