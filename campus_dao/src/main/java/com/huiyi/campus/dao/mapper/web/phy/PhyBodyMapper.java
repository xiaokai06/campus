package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyBodyEntity;

public interface PhyBodyMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(PhyBodyEntity record);

    int insertSelective(PhyBodyEntity record);

    PhyBodyEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(PhyBodyEntity record);

    int updateByPrimaryKey(PhyBodyEntity record);
}