package com.huiyi.campus.web.health.service;

import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.phy.PhyHealthEducationEntity;

/**
 * @author: yzg
 * @time: 2021-04-14 14:35
 * @description: 健康宣教
 */
public interface PhyHealthEducationService {

    /**
     * 查询所有健康宣教
     * @param phyHealthEducationEntity 参数
     * @return 返回值
     */
    CrRpcResult selectHealthEducation(PhyHealthEducationEntity phyHealthEducationEntity);

    /**
     * 新增健康宣教
     * @param phyHealthEducationEntity 参数
     * @return 返回值
     */
    ResultBody insertHealthEducation(PhyHealthEducationEntity phyHealthEducationEntity);

    /**
     * 修改健康宣教
     * @param phyHealthEducationEntity 参数
     * @return 返回值
     */
    ResultBody updateHealthEducation(PhyHealthEducationEntity phyHealthEducationEntity);

    /**
     * 删除健康宣教
     * @param id 参数
     * @return 返回值
     */
    ResultBody deleteHealthEducation(Integer id);

}
