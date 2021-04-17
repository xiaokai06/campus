package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysDoctorEntity;
import com.huiyi.campus.dao.entity.sys.SysSchoolDoctorEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysDoctorDao;
import com.huiyi.campus.dao.pojo.web.sys.SysSchoolDoctorDao;
import com.huiyi.campus.web.sys.service.SysDoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(SysDoctorServiceImpl.class);

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
        Integer doctorId = sysDoctorEntity.getId();
        Integer schoolId = sysDoctorEntity.getSchoolId();
        logger.info("新增医生获取到的医生ID为：" + doctorId + ", 学校ID为：" + schoolId);
        int i = sysDoctorDao.insertDoctorInfo(sysDoctorEntity);
        if (i > 0 && null != doctorId && null != schoolId) {
            sysSchoolDoctorDao.insertDoctorBySchoolId(doctorId, schoolId);
        }
        return ResultBody.insert(i, sysDoctorEntity.getId());
    }

    /**
     * 修改医生
     * @param sysDoctorEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateDoctorInfo(SysDoctorEntity sysDoctorEntity) {
        Integer doctorId = sysDoctorEntity.getId();
        Integer schoolId = sysDoctorEntity.getSchoolId();
        logger.info("修改医生获取到的医生ID为：" + doctorId + ", 学校ID为：" + schoolId);
        int i = sysDoctorDao.updateDoctorInfo(sysDoctorEntity);
        if (i > 0 && null != doctorId && null != schoolId) {
            int j = sysSchoolDoctorDao.updateSchoolByDoctorId(doctorId, schoolId);
            // TODO:针对一开始医生没有归属学校，后面修改为归属某家学校
            if (j <= 0) {
                sysSchoolDoctorDao.insertDoctorBySchoolId(doctorId, schoolId);
            }
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
        logger.info("删除医生获取到的医生ID为：" + doctorId + ", 学校ID为：" + schoolId);
        if (i > 0 && null != doctorId && null != schoolId) {
            sysSchoolDoctorDao.deleteSchoolByDoctorId(schoolId, doctorId);
        }
        return ResultBody.delete(i);
    }
}
