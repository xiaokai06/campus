package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyStudentHealthInfoEntity;

public interface PhyStudentHealthInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhyStudentHealthInfoEntity record);

    int insertSelective(PhyStudentHealthInfoEntity record);

    PhyStudentHealthInfoEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhyStudentHealthInfoEntity record);

    int updateByPrimaryKey(PhyStudentHealthInfoEntity record);
}