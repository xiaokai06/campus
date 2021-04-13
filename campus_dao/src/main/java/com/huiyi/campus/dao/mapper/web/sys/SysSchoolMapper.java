package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;

import java.util.List;

public interface SysSchoolMapper {

    /**
     * 查询学校
     * @param sysSchoolEntity
     * @return
     */
    List<SysSchoolEntity> selectAllSchool(SysSchoolEntity sysSchoolEntity);

    /**
     * 新增学校
     * @param sysSchoolEntity
     * @return
     */
    int insertSchoolInfo(SysSchoolEntity sysSchoolEntity);

    /**
     * 修改学校
     * @param sysSchoolEntity
     * @return
     */
    int updateSchoolInfo(SysSchoolEntity sysSchoolEntity);

    /**
     * 删除学校
     * @param id
     * @return
     */
    int deleteSchoolInfo(Integer id);
}