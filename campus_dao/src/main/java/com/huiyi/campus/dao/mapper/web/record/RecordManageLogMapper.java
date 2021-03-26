package com.huiyi.campus.dao.mapper.web.record;

import com.huiyi.campus.dao.entity.record.RecordManageLogEntity;

public interface RecordManageLogMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(RecordManageLogEntity record);

    int insertSelective(RecordManageLogEntity record);

    RecordManageLogEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(RecordManageLogEntity record);

    int updateByPrimaryKey(RecordManageLogEntity record);
}