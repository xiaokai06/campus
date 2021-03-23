package com.huiyi.campus.dao.web.mapper.sys;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiyi.campus.dao.entity.sys.SysSchoolDoctorEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SysSchoolDoctorEntityMapper extends BaseMapper<SysSchoolDoctorEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(SysSchoolDoctorEntity record);

    int insertSelective(SysSchoolDoctorEntity record);

    SysSchoolDoctorEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysSchoolDoctorEntity record);

    int updateByPrimaryKey(SysSchoolDoctorEntity record);
}