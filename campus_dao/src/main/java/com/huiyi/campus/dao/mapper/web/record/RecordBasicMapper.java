package com.huiyi.campus.dao.mapper.web.record;

import com.huiyi.campus.dao.entity.record.RecordBasicEntity;

public interface RecordBasicMapper {
    int deleteByPrimaryKey(Integer grxh01);

    int insert(RecordBasicEntity record);

    int insertSelective(RecordBasicEntity record);

    RecordBasicEntity selectByPrimaryKey(Integer grxh01);

    int updateByPrimaryKeySelective(RecordBasicEntity record);

    int updateByPrimaryKey(RecordBasicEntity record);
}