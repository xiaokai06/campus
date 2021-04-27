package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysOrganEntity;

/**
 * @author: yzg
 * @time: 2021-04-06 14:01
 * @description: 机构管理
 */
public interface SysOrganService {

    /**
     * 查询所有机构
     * @param sysOrganEntity
     * @param nickName
     * @return
     */
    ResultBody selectAllOrgan(String nickName, SysOrganEntity sysOrganEntity);

    /**
     * 新增机构
     * @param sysOrganEntity
     * @return
     */
    ResultBody insertOrganInfo(SysOrganEntity sysOrganEntity);

    /**
     * 修改机构
     * @param sysOrganEntity
     * @return
     */
    ResultBody updateOrganInfo(SysOrganEntity sysOrganEntity);

    /**
     * 删除机构
     * @param id
     * @return
     */
    ResultBody deleteOrganInfo(Integer id);

}
