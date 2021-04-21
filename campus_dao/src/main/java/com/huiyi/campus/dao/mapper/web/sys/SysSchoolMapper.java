package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysSchoolMapper {

    /**
     * 查询学校
     * @param sysSchoolEntity 参数
     * @param list 机构ID
     * @return 返回值
     */
    List<SysSchoolEntity> selectAllSchool(@Param("sysSchool") SysSchoolEntity sysSchoolEntity, @Param("list") List<Integer> list);

    /**
     * 通过机构ID删除学校
     * @param id
     * @return
     */
    int deleteSchoolByOrganId(Integer id);

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
     * 通过机构ID查询学校ID
     * @param list
     * @return
     */
    List<Integer> selectIdByOrganId(List<Integer> list);

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