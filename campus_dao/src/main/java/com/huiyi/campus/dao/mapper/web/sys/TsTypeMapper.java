package com.huiyi.campus.dao.mapper.web.sys;


import com.huiyi.campus.dao.entity.sys.TsTypeEntity;

public interface TsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsTypeEntity record);

    int insertSelective(TsTypeEntity record);

    TsTypeEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsTypeEntity record);

    int updateByPrimaryKey(TsTypeEntity record);
}