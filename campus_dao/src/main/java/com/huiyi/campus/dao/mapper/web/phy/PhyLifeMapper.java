package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyLifeEntity;

public interface PhyLifeMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(PhyLifeEntity record);

    int insertSelective(PhyLifeEntity record);

    PhyLifeEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(PhyLifeEntity record);

    int updateByPrimaryKey(PhyLifeEntity record);
}