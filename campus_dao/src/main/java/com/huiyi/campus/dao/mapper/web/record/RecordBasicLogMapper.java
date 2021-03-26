package com.huiyi.campus.dao.mapper.web.record;

import com.huiyi.campus.dao.entity.record.RecordBasicLogEntity;

public interface RecordBasicLogMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(RecordBasicLogEntity record);

    int insertSelective(RecordBasicLogEntity record);

    RecordBasicLogEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(RecordBasicLogEntity record);

    int updateByPrimaryKey(RecordBasicLogEntity record);
}