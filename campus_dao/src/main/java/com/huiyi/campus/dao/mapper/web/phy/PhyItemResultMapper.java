package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.dto.health.PhyItemResultLiverDto;
import com.huiyi.campus.dao.entity.phy.PhyItemResultEntity;
import com.huiyi.campus.dao.vo.health.PhyItemResultBloodVo;
import com.huiyi.campus.dao.vo.health.PhyItemResultLiverVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhyItemResultMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhyItemResultEntity record);

    int insertSelective(PhyItemResultEntity record);

    PhyItemResultEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhyItemResultEntity record);

    int updateByPrimaryKey(PhyItemResultEntity record);

    int insertSelectiveBloodList(List<PhyItemResultBloodVo> itemResultEntityList);

    int insertSelectiveLiverList(List<PhyItemResultLiverVo> itemResultEntityList);

    int updateItemResultList(List<PhyItemResultEntity> itemResultEntityList);

    PhyItemResultEntity selectItemResultByHeathId(String phyHealthId);

    List<PhyItemResultBloodVo> selectBloodListByHealthId(@Param("phyHealthId") String phyHealthId, @Param("rptunitid") Integer rptunitid);

    List<PhyItemResultLiverVo> selectLiverListByHealthId(@Param("phyHealthId") String phyHealthId, @Param("rptunitid") Integer rptunitid);

    int updateItemLiverResultList(List<PhyItemResultLiverVo> itemResultEntityList);

    int updateItemBloodResultList(List<PhyItemResultBloodVo> itemResultEntityList);
}