package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.dto.health.StudentHealthInfoDto;
import com.huiyi.campus.dao.entity.phy.PhyItemResultEntity;

import java.util.List;

public interface PhyItemResultMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhyItemResultEntity record);

    int insertSelective(PhyItemResultEntity record);

    PhyItemResultEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhyItemResultEntity record);

    int updateByPrimaryKey(PhyItemResultEntity record);

    int insertSelectiveList(List<PhyItemResultEntity> itemResultEntityList);

    int updateItemResultList(List<PhyItemResultEntity> itemResultEntityList);

    List<PhyItemResultEntity> selectItemListByHealthIdAndRptunitId(String phyHealthId, Integer rptunitid);

    PhyItemResultEntity selectItemResultByHeathId(String phyHealthId);

}