package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.entity.sys.SysSchoolDoctorEntity;
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
     * @param sysSchoolDoctorEntity 参数
     * @return 返回值
     */
    public int insertDoctorBySchoolId(SysSchoolDoctorEntity sysSchoolDoctorEntity) {
        return sysSchoolDoctorMapper.insertDoctorBySchoolId(sysSchoolDoctorEntity);
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
