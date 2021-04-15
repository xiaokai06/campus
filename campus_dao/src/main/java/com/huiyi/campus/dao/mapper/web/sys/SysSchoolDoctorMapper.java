package com.huiyi.campus.dao.mapper.web.sys;

import org.apache.ibatis.annotations.Param;

public interface SysSchoolDoctorMapper {

    /**
     * 通过学校ID新增医生ID
     * @param schoolId 学校ID
     * @param doctorId 医生ID
     * @return 返回值
     */
    void insertDoctorBySchoolId(@Param("schoolId") Integer schoolId, @Param("doctorId") Integer doctorId);

    /**
     * 通过医生ID更新学校ID
     * @param schoolId
     * @param doctorId
     */
    void updateSchoolByDoctorId(@Param("schoolId") Integer schoolId, @Param("doctorId") Integer doctorId);

    /**
     * 通过学校ID删除医生ID
     * @param id 学校ID
     * @return 返回值
     */
    void deleteDoctorBySchoolId(Integer id);

    /**
     * 通过医生ID删除学校ID
     * @param schoolId 学校ID
     * @param doctorId 医生ID
     * @return 返回值
     */
    int deleteSchoolByDoctorId(@Param("schoolId") Integer schoolId, @Param("doctorId") Integer doctorId);

}