package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysHospitalEntity;

public interface SysHospitalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysHospitalEntity record);

    int insertSelective(SysHospitalEntity record);

    SysHospitalEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysHospitalEntity record);

    int updateByPrimaryKey(SysHospitalEntity record);
}