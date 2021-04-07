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

    /**
     * 根据用户ID查询当前所归属学校
     * @param id
     * @return
     */
    List<SysSchoolEntity> selectSchoolByUserId(Integer id);

    /**
     * 根据教育局ID与用户ID查询学校
     * @param id
     * @return
     */
    List<SysSchoolEntity> selectSchoolByUserIdAndOrganId(Integer id);
}