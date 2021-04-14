package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.entity.phy.PhyHealthEducationEntity;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-14 15:45
 * @description: 健康宣教
 */
public interface PhyHealthEducationMapper {

    /**
     * 查询所有健康宣教
     * @param phyHealthEducationEntity 参数
     * @return 返回值
     */
    List<PhyHealthEducationEntity> selectHealthEducation(PhyHealthEducationEntity phyHealthEducationEntity);

    /**
     * 新增健康宣教
     * @param phyHealthEducationEntity 参数
     * @return 返回值
     */
    int insertHealthEducation(PhyHealthEducationEntity phyHealthEducationEntity);

    /**
     * 修改健康宣教
     * @param phyHealthEducationEntity 参数
     * @return 返回值
     */
    int updateHealthEducation(PhyHealthEducationEntity phyHealthEducationEntity);

    /**
     * 删除健康宣教
     * @param id 参数
     * @return 返回值
     */
    int deleteHealthEducation(Integer id);

}
