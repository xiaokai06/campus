package com.huiyi.campus.dao.pojo.web.health;

import com.huiyi.campus.dao.entity.phy.PhyHealthEducationEntity;
import com.huiyi.campus.dao.mapper.web.phy.PhyHealthEducationMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-14 15:43
 * @description: 健康宣教
 */
@Repository
public class PhyHealthEducationDao {

    PhyHealthEducationMapper phyHealthEducationMapper;

    /**
     * 查询所有健康宣教
     * @param phyHealthEducationEntity 参数
     * @return 返回值
     */
    public List<PhyHealthEducationEntity> selectHealthEducation(PhyHealthEducationEntity phyHealthEducationEntity) {
        return phyHealthEducationMapper.selectHealthEducation(phyHealthEducationEntity);
    }

    /**
     * 新增健康宣教
     * @param phyHealthEducationEntity 参数
     * @return 返回值
     */
    public int insertHealthEducation(PhyHealthEducationEntity phyHealthEducationEntity) {
        return phyHealthEducationMapper.insertHealthEducation(phyHealthEducationEntity);
    }

    /**
     * 修改健康宣教
     * @param phyHealthEducationEntity 参数
     * @return 返回值
     */
    public int updateHealthEducation(PhyHealthEducationEntity phyHealthEducationEntity) {
        return phyHealthEducationMapper.updateHealthEducation(phyHealthEducationEntity);
    }

    /**
     * 删除健康宣教
     * @param id 参数
     * @return 返回值
     */
    public int deleteHealthEducation(Integer id) {
        return phyHealthEducationMapper.deleteHealthEducation(id);
    }

}
