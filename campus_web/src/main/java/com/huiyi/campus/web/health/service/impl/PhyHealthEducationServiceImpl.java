package com.huiyi.campus.web.health.service.impl;

import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.phy.PhyHealthEducationEntity;
import com.huiyi.campus.dao.pojo.web.health.PhyHealthEducationDao;
import com.huiyi.campus.web.health.service.PhyHealthEducationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-14 14:36
 * @description: 健康宣教
 */
@Service
public class PhyHealthEducationServiceImpl implements PhyHealthEducationService {

    PhyHealthEducationDao phyHealthEducationDao;

    PhyHealthEducationServiceImpl(PhyHealthEducationDao phyHealthEducationDao) {
        this.phyHealthEducationDao = phyHealthEducationDao;
    }

    /**
     * 查询所有健康宣教
     * @param phyHealthEducationEntity 参数
     * @return 返回值
     */
    @Override
    public CrRpcResult selectHealthEducation(PhyHealthEducationEntity phyHealthEducationEntity) {
        List<PhyHealthEducationEntity> list = phyHealthEducationDao.selectHealthEducation(phyHealthEducationEntity);
        PageInfo pageInfo = new PageInfo(list);
        return CrRpcResult.success(pageInfo);
    }

    /**
     * 新增健康宣教
     * @param phyHealthEducationEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody insertHealthEducation(PhyHealthEducationEntity phyHealthEducationEntity) {
        return ResultBody.insert(phyHealthEducationDao.insertHealthEducation(phyHealthEducationEntity), phyHealthEducationEntity.getId());
    }

    /**
     * 修改健康宣教
     * @param phyHealthEducationEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateHealthEducation(PhyHealthEducationEntity phyHealthEducationEntity) {
        return ResultBody.update(phyHealthEducationDao.updateHealthEducation(phyHealthEducationEntity));
    }

    /**
     * 删除健康宣教
     * @param id 参数
     * @return 返回值
     */
    @Override
    public ResultBody deleteHealthEducation(Integer id) {
        return ResultBody.delete(phyHealthEducationDao.deleteHealthEducation(id));
    }
}
