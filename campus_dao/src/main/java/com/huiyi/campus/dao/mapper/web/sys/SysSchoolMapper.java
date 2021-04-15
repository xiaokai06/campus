package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;

import java.util.List;

public interface SysSchoolMapper {

    /**
     * 查询学校
     * @param sysSchoolEntity 参数
     * @return 返回值
     */
    List<SysSchoolEntity> selectAllSchool(SysSchoolEntity sysSchoolEntity);

    /**
     * 通过机构ID删除学校
     * @param id
     * @return
     */
    List<Integer> deleteSchoolByOrganId(Integer id);

    /**
     * 新增学校
     * @param sysSchoolEntity 参数
     * @return 返回值
     */
    int insertSchoolInfo(SysSchoolEntity sysSchoolEntity);

    /**
     * 修改学校
     * @param sysSchoolEntity 参数
     * @return 返回值
     */
    int updateSchoolInfo(SysSchoolEntity sysSchoolEntity);

    /**
     * 删除学校
     * @param id 参数
     * @return 返回值
     */
    int deleteSchoolInfo(Integer id);


    /**
     * 根据用户ID查询当前所归属学校
     * @param id 参数
     * @return 返回值
     */
    List<SysSchoolEntity> selectSchoolByUserId(Integer id);

    /**
     * 根据教育局ID与用户ID查询学校
     * @param id 参数
     * @return 返回值
     */
    List<SysSchoolEntity> selectSchoolByUserIdAndOrganId(Integer id);
}