package com.huiyi.campus.dao.mapper.web.phy;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiyi.campus.dao.entity.phy.PhyStudentHealthInfoEntity;
import com.huiyi.campus.dao.vo.health.StudentHealthInfoVo;
import org.mapstruct.Mapper;

@Mapper
public interface PhyStudentHealthInfoMapper extends BaseMapper<PhyStudentHealthInfoEntity> {
    int deleteByPrimaryKey(String id);

    int insert(PhyStudentHealthInfoEntity record);

    int insertSelective(PhyStudentHealthInfoEntity record);

    StudentHealthInfoVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhyStudentHealthInfoEntity record);

    int updateByPrimaryKey(PhyStudentHealthInfoEntity record);
}