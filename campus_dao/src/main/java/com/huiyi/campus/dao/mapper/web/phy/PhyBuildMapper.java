package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyBuildEntity;

public interface PhyBuildMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(PhyBuildEntity record);

    int insertSelective(PhyBuildEntity record);

    PhyBuildEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(PhyBuildEntity record);

    int updateByPrimaryKey(PhyBuildEntity record);
}