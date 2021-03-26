package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyHealthEvaluateEntity;

public interface PhyHealthEvaluateMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(PhyHealthEvaluateEntity record);

    int insertSelective(PhyHealthEvaluateEntity record);

    PhyHealthEvaluateEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(PhyHealthEvaluateEntity record);

    int updateByPrimaryKey(PhyHealthEvaluateEntity record);
}