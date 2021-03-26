package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysSchoolDoctor;

public interface SysSchoolDoctorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysSchoolDoctor record);

    int insertSelective(SysSchoolDoctor record);

    SysSchoolDoctor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysSchoolDoctor record);

    int updateByPrimaryKey(SysSchoolDoctor record);
}