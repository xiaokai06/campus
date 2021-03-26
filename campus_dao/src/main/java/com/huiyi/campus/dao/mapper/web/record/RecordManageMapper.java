package com.huiyi.campus.dao.mapper.web.record;

import com.huiyi.campus.dao.entity.record.RecordManageEntity;

public interface RecordManageMapper {
    int deleteByPrimaryKey(Integer grxh01);

    int insert(RecordManageEntity record);

    int insertSelective(RecordManageEntity record);

    RecordManageEntity selectByPrimaryKey(Integer grxh01);

    int updateByPrimaryKeySelective(RecordManageEntity record);

    int updateByPrimaryKey(RecordManageEntity record);
}