package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysDoctorEntity;
import com.huiyi.campus.dao.entity.sys.SysSchoolDoctorEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysDoctorDao;
import com.huiyi.campus.dao.pojo.web.sys.SysSchoolDoctorDao;
import com.huiyi.campus.web.sys.service.SysDoctorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yzg
 * @time: 2021-04-06 16:05
 * @description: 医生管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysDoctorServiceImpl implements SysDoctorService {

    SysDoctorDao sysDoctorDao;
    SysSchoolDoctorDao sysSchoolDoctorDao;

    SysDoctorServiceImpl(SysDoctorDao sysDoctorDao, SysSchoolDoctorDao sysSchoolDoctorDao) {
        this.sysDoctorDao = sysDoctorDao;
        this.sysSchoolDoctorDao = sysSchoolDoctorDao;
    }

    /**
     * 查询所有医生
     * @param sysDoctorEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody selectAllDoctor(SysDoctorEntity sysDoctorEntity) {
        return ResultBody.success(sysDoctorDao.selectAllDoctor(sysDoctorEntity));
    }

    /**
     * 新增医生
     * @param sysDoctorEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody insertDoctorInfo(SysDoctorEntity sysDoctorEntity) {
        int i = sysDoctorDao.insertDoctorInfo(sysDoctorEntity);
        Integer doctorId = sysDoctorEntity.getId();
        if (i > 0) {
            Integer schoolId = sysDoctorEntity.getSchoolId();
            sysSchoolDoctorDao.insertDoctorBySchoolId(doctorId, schoolId);
        }
        return ResultBody.insert(i, doctorId);
    }

    /**
     * 修改医生
     * @param sysDoctorEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateDoctorInfo(SysDoctorEntity sysDoctorEntity) {
        int i = sysDoctorDao.updateDoctorInfo(sysDoctorEntity);
        Integer doctorId = sysDoctorEntity.getId();
        if (i > 0) {
            Integer schoolId = sysDoctorEntity.getSchoolId();
            sysSchoolDoctorDao.updateSchoolByDoctorId(doctorId, schoolId);
        }
        return ResultBody.update(i);
    }

    /**
     * 删除医生
     * @param sysSchoolDoctorEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody deleteDoctorInfo(SysSchoolDoctorEntity sysSchoolDoctorEntity) {
        Integer doctorId = sysSchoolDoctorEntity.getDoctorId();
        Integer schoolId = sysSchoolDoctorEntity.getSchoolId();
        int i = sysDoctorDao.deleteDoctorInfo(doctorId);
        if (i > 0) {
            sysSchoolDoctorDao.deleteSchoolByDoctorId(schoolId, doctorId);
        }
        return ResultBody.delete(i);
    }
}
