package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyItemResultEntity;

public interface PhyItemResultMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhyItemResultEntity record);

    int insertSelective(PhyItemResultEntity record);

    PhyItemResultEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhyItemResultEntity record);

    int updateByPrimaryKey(PhyItemResultEntity record);
}