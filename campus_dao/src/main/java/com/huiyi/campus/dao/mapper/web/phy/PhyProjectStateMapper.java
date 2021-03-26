package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyProjectStateEntity;

public interface PhyProjectStateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PhyProjectStateEntity record);

    int insertSelective(PhyProjectStateEntity record);

    PhyProjectStateEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PhyProjectStateEntity record);

    int updateByPrimaryKey(PhyProjectStateEntity record);
}