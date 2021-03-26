package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;

public interface PhyStudentInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhyStudentInfoEntity record);

    int insertSelective(PhyStudentInfoEntity record);

    PhyStudentInfoEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhyStudentInfoEntity record);

    int updateByPrimaryKey(PhyStudentInfoEntity record);
}