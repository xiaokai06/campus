package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.entity.sys.SysDoctorEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysDoctorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-06 16:13
 * @description: 医生管理
 */
@Repository
public class SysDoctorDao {

    SysDoctorMapper sysDoctorMapper;

    SysDoctorDao(SysDoctorMapper sysDoctorMapper) {
        this.sysDoctorMapper = sysDoctorMapper;
    }

    /**
     * 查询所有医生
     * @param sysDoctorEntity 参数
     * @return 返回值
     */
    public List<SysDoctorEntity> selectAllDoctor(SysDoctorEntity sysDoctorEntity) {
        return sysDoctorMapper.selectAllDoctor(sysDoctorEntity);
    }

    /**
     * 新增医生
     * @param sysDoctorEntity 参数
     * @return 返回值
     */
    public int insertDoctorInfo(SysDoctorEntity sysDoctorEntity) {
        return sysDoctorMapper.insertDoctorInfo(sysDoctorEntity);
    }

    /**
     * 修改医生
     * @param sysDoctorEntity 参数
     * @return 返回值
     */
    public int updateDoctorInfo(SysDoctorEntity sysDoctorEntity) {
        return sysDoctorMapper.updateDoctorInfo(sysDoctorEntity);
    }

    /**
     * 删除医生
     * @param id 参数
     * @return 返回值
     */
    public int deleteDoctorInfo(Integer id) {
        return sysDoctorMapper.deleteDoctorInfo(id);
    }


}
