package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysDoctorEntity;

import java.util.List;

public interface SysDoctorMapper {

    /**
     * 查询所有医生
     * @param sysDoctorEntity
     * @return
     */
    List<SysDoctorEntity> selectAllDoctor(SysDoctorEntity sysDoctorEntity);

    /**
     * 新增医生
     * @param sysDoctorEntity
     * @return
     */
    int insertDoctorInfo(SysDoctorEntity sysDoctorEntity);

    /**
     * 修改医生
     * @param sysDoctorEntity
     * @return
     */
    int updateDoctorInfo(SysDoctorEntity sysDoctorEntity);

    /**
     * 删除医生
     * @param id
     * @return
     */
    int deleteDoctorInfo(Integer id);

}