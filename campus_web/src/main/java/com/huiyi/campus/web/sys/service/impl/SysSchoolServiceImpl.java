package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysSchoolDao;
import com.huiyi.campus.web.sys.service.SysSchoolService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yzg
 * @time: 2021-04-06 14:01
 * @description: 学校管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysSchoolServiceImpl implements SysSchoolService {

    SysSchoolDao sysSchoolDao;

    SysSchoolServiceImpl(SysSchoolDao sysSchoolDao) {
        this.sysSchoolDao = sysSchoolDao;
    }

    /**
     * 获取所有学校
     * @param sysSchoolEntity
     * @return
     */
    @Override
    public ResultBody selectAllSchool(SysSchoolEntity sysSchoolEntity) {
        return ResultBody.success(sysSchoolDao.selectAllSchool(sysSchoolEntity));
    }

    /**
     * 新增学校
     * @param sysSchoolEntity
     * @return
     */
    @Override
    public ResultBody insertSchoolInfo(SysSchoolEntity sysSchoolEntity) {
        return ResultBody.insert(sysSchoolDao.insertSchoolInfo(sysSchoolEntity), sysSchoolEntity.getId());
    }

    /**
     * 修改学校
     * @param sysSchoolEntity
     * @return
     */
    @Override
    public ResultBody updateSchoolInfo(SysSchoolEntity sysSchoolEntity) {
        return ResultBody.update(sysSchoolDao.updateSchoolInfo(sysSchoolEntity));
    }

    /**
     * 删除学校
     * @param id
     * @return
     */
    @Override
    public ResultBody deleteSchoolInfo(Integer id) {
        return ResultBody.delete(sysSchoolDao.deleteSchoolInfo(id));
    }
}
