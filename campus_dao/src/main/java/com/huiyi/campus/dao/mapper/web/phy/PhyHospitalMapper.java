package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyHospitalEntity;

public interface PhyHospitalMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(PhyHospitalEntity record);

    int insertSelective(PhyHospitalEntity record);

    PhyHospitalEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(PhyHospitalEntity record);

    int updateByPrimaryKey(PhyHospitalEntity record);
}