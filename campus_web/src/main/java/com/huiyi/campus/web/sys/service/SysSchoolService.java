package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;

/**
 * @author: yzg
 * @time: 2021-04-06 14:01
 * @description: 学校管理
 */
public interface SysSchoolService {

    /**
     * 查询所有学校
     * @param sysSchoolEntity
     * @return
     */
    ResultBody selectAllSchool(SysSchoolEntity sysSchoolEntity);

    /**
     * 新增学校
     * @param sysSchoolEntity
     * @return
     */
    ResultBody insertSchoolInfo(SysSchoolEntity sysSchoolEntity);

    /**
     * 修改学校
     * @param sysSchoolEntity
     * @return
     */
    ResultBody updateSchoolInfo(SysSchoolEntity sysSchoolEntity);

    /**
     * 删除学校
     * @param id
     * @return
     */
    ResultBody deleteSchoolInfo(Integer id);

}
