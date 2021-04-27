package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysOrganEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-06 14:04
 * @description: 机构管理
 */
public interface SysOrganMapper {

    /**
     * 查询所有机构
     *
     * @param sysOrganEntity
     * @return
     */
    List<SysOrganEntity> selectAllOrgan(@Param("sysOrgan") SysOrganEntity sysOrganEntity,
                                        @Param("organId") Integer organId);

    /**
     * 新增机构
     *
     * @param sysOrganEntity
     * @return
     */
    int insertOrganInfo(SysOrganEntity sysOrganEntity);

    /**
     * 修改机构
     *
     * @param sysOrganEntity
     * @return
     */
    int updateOrganInfo(SysOrganEntity sysOrganEntity);

    /**
     * 删除机构
     *
     * @param id
     * @return
     */
    int deleteOrganInfo(Integer id);

    /**
     * 根据机构ID查询子级
     *
     * @param organId
     * @return
     */
    List<SysOrganEntity> selectIdByOrganId(Integer organId);

    List<SysOrganEntity> selectOrganByUserId(Integer organId);

    List<SysOrganEntity> selectByOrganId(Integer organId);

//    List<Integer> selectOrgByOrgId(Integer orgId);
}
