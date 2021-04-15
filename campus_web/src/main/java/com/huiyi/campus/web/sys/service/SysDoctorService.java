package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysDoctorEntity;
import com.huiyi.campus.dao.entity.sys.SysSchoolDoctorEntity;

/**
 * @author: yzg
 * @time: 2021-04-06 16:05
 * @description: 医生管理
 */
public interface SysDoctorService {

    /**
     * 查询所有医生
     * @param sysDoctorEntity
     * @return
     */
    ResultBody selectAllDoctor(SysDoctorEntity sysDoctorEntity);

    /**
     * 新增医生
     * @param sysDoctorEntity
     * @return
     */
    ResultBody insertDoctorInfo(SysDoctorEntity sysDoctorEntity);

    /**
     * 修改医生
     * @param sysDoctorEntity
     * @return
     */
    ResultBody updateDoctorInfo(SysDoctorEntity sysDoctorEntity);

    /**
     * 删除医生
     * @param sysSchoolDoctorEntity
     * @return
     */
    ResultBody deleteDoctorInfo(SysSchoolDoctorEntity sysSchoolDoctorEntity);

}
