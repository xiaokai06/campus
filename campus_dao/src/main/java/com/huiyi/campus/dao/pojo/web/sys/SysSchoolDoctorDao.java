package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.mapper.web.sys.SysSchoolDoctorMapper;
import org.springframework.stereotype.Repository;

/**
 * @author: yzg
 * @time: 2021-04-15 9:11
 * @description: 学校医生关联表
 */
@Repository
public class SysSchoolDoctorDao {

    SysSchoolDoctorMapper sysSchoolDoctorMapper;

    SysSchoolDoctorDao(SysSchoolDoctorMapper sysSchoolDoctorMapper) {
        this.sysSchoolDoctorMapper = sysSchoolDoctorMapper;
    }

    /**
     * 通过学校ID新增医生ID
     * @param doctorId 医生ID
     * @param schoolId 学校ID
     */
    public void insertDoctorBySchoolId(Integer doctorId, Integer schoolId) {
        sysSchoolDoctorMapper.insertDoctorBySchoolId(doctorId, schoolId);
    }

    /**
     * 通过医生ID更新学校ID
     * @param doctorId
     * @param schoolId
     */
    public void updateSchoolByDoctorId(Integer doctorId, Integer schoolId) {
        sysSchoolDoctorMapper.updateSchoolByDoctorId(doctorId, schoolId);
    }

    /**
     * 通过学校ID删除医生ID
     * @param id 学校ID
     * @return 返回值
     */
    public void deleteDoctorBySchoolId(Integer id) {
        sysSchoolDoctorMapper.deleteDoctorBySchoolId(id);
    }

    /**
     * 通过医生ID删除学校ID
     * @param schoolId 学校ID
     * @param doctorId 医生ID
     * @return 返回值
     */
    public void deleteSchoolByDoctorId(Integer schoolId, Integer doctorId){
        sysSchoolDoctorMapper.deleteSchoolByDoctorId(schoolId, doctorId);
    }

}
