package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysOrganEntity;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-06 14:04
 * @description: 机构管理
 */
public interface SysOrganMapper {

    /**
     * 查询所有机构
     * @param sysOrganEntity
     * @return
     */
    List<SysOrganEntity> selectAllOrgan(SysOrganEntity sysOrganEntity);

    /**
     * 新增机构
     * @param sysOrganEntity
     * @return
     */
    int insertOrganInfo(SysOrganEntity sysOrganEntity);

    /**
     * 修改机构
     * @param sysOrganEntity
     * @return
     */
    int updateOrganInfo(SysOrganEntity sysOrganEntity);

    /**
     * 删除机构
     * @param id
     * @return
     */
    int deleteOrganInfo(Integer id);

    List<SysOrganEntity> selectOrganByUserId(Integer organId);

    List<SysOrganEntity> selectByOrganId(Integer organId);
}
