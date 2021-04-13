package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysDoctorEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysDoctorDao;
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

    SysDoctorServiceImpl(SysDoctorDao sysDoctorDao) {
        this.sysDoctorDao = sysDoctorDao;
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
        return ResultBody.insert(sysDoctorDao.insertDoctorInfo(sysDoctorEntity), sysDoctorEntity.getId());
    }

    /**
     * 修改医生
     * @param sysDoctorEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateDoctorInfo(SysDoctorEntity sysDoctorEntity) {
        return ResultBody.update(sysDoctorDao.updateDoctorInfo(sysDoctorEntity));
    }

    /**
     * 删除医生
     * @param id 参数
     * @return 返回值
     */
    @Override
    public ResultBody deleteDoctorInfo(Integer id) {
        return ResultBody.delete(sysDoctorDao.deleteDoctorInfo(id));
    }
}
