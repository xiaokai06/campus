package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyBasicEntity;

public interface PhyBasicMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(PhyBasicEntity record);

    int insertSelective(PhyBasicEntity record);

    PhyBasicEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(PhyBasicEntity record);

    int updateByPrimaryKey(PhyBasicEntity record);
}