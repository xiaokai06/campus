package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyAssistEntity;

public interface PhyAssistMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(PhyAssistEntity record);

    int insertSelective(PhyAssistEntity record);

    PhyAssistEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(PhyAssistEntity record);

    int updateByPrimaryKey(PhyAssistEntity record);
}