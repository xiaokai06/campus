package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyVaccHistoryEntity;

public interface PhyVaccHistoryMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(PhyVaccHistoryEntity record);

    int insertSelective(PhyVaccHistoryEntity record);

    PhyVaccHistoryEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(PhyVaccHistoryEntity record);

    int updateByPrimaryKey(PhyVaccHistoryEntity record);
}