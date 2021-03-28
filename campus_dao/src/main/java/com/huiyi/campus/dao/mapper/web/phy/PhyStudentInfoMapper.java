package com.huiyi.campus.dao.mapper.web.phy;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PhyStudentInfoMapper extends BaseMapper<PhyStudentInfoEntity> {
    int deleteByPrimaryKey(String id);

    int insert(PhyStudentInfoEntity record);

    int insertSelective(PhyStudentInfoEntity record);

    PhyStudentInfoEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhyStudentInfoEntity record);

    int updateByPrimaryKey(PhyStudentInfoEntity record);
}