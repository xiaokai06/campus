package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysOrganDao;
import com.huiyi.campus.dao.pojo.web.sys.SysSchoolDao;
import com.huiyi.campus.dao.pojo.web.sys.SysSchoolDoctorDao;
import com.huiyi.campus.web.sys.service.SysSchoolService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-06 14:01
 * @description: 学校管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysSchoolServiceImpl implements SysSchoolService {

    SysOrganDao sysOrganDao;
    SysSchoolDao sysSchoolDao;
    SysSchoolDoctorDao sysSchoolDoctorDao;

    SysSchoolServiceImpl(SysSchoolDao sysSchoolDao, SysSchoolDoctorDao sysSchoolDoctorDao,
                         SysOrganDao sysOrganDao) {
        this.sysOrganDao = sysOrganDao;
        this.sysSchoolDao = sysSchoolDao;
        this.sysSchoolDoctorDao = sysSchoolDoctorDao;
    }

    /**
     * 获取所有学校
     * @param sysSchoolEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody selectAllSchool(SysSchoolEntity sysSchoolEntity) {
        Integer organId = sysSchoolEntity.getOrgId();
        List<Integer> list = new ArrayList<>();
        if (null != organId && organId != 0) {
            list = sysOrganDao.selectIdByOrganId(organId);
        }
        return ResultBody.success(sysSchoolDao.selectAllSchool(sysSchoolEntity, list));
    }

    /**
     * 新增学校
     * @param sysSchoolEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody insertSchoolInfo(SysSchoolEntity sysSchoolEntity) {
        return ResultBody.insert(sysSchoolDao.insertSchoolInfo(sysSchoolEntity), sysSchoolEntity.getId());
    }

    /**
     * 修改学校
     * @param sysSchoolEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateSchoolInfo(SysSchoolEntity sysSchoolEntity) {
        return ResultBody.update(sysSchoolDao.updateSchoolInfo(sysSchoolEntity));
    }

    /**
     * 删除学校
     * @param id 参数
     * @return 返回值
     */
    @Override
    public ResultBody deleteSchoolInfo(Integer id) {
        int i = sysSchoolDao.deleteSchoolInfo(id);
        if (i > 0) {
            sysSchoolDoctorDao.deleteDoctorBySchoolId(id);
        }
        return ResultBody.delete(i);
    }
}
