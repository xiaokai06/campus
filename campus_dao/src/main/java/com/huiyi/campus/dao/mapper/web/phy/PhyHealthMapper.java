package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyHealthEntity;

public interface PhyHealthMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(PhyHealthEntity record);

    int insertSelective(PhyHealthEntity record);

    PhyHealthEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(PhyHealthEntity record);

    int updateByPrimaryKey(PhyHealthEntity record);
}