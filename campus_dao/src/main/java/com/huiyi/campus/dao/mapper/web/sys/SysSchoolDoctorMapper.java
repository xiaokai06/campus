package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysSchoolDoctorEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysSchoolDoctorMapper {

    /**
     * 通过学校ID新增医生ID
     * @param sysSchoolDoctorEntity 参数
     * @return 返回值
     */
    int insertDoctorBySchoolId(SysSchoolDoctorEntity sysSchoolDoctorEntity);

    /**
     * 通过学校ID删除医生ID
     * @param id 学校ID
     * @return 返回值
     */
    int deleteDoctorBySchoolId(Integer id);

    /**
     * 通过医生ID删除学校ID
     * @param schoolId 学校ID
     * @param doctorId 医生ID
     * @return 返回值
     */
    int deleteSchoolByDoctorId(@Param("schoolId") Integer schoolId, @Param("doctorId") Integer doctorId);

}