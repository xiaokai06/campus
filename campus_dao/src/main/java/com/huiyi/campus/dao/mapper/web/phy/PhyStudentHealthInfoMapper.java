package com.huiyi.campus.dao.mapper.web.phy;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiyi.campus.dao.entity.phy.PhyStudentHealthInfoEntity;
import com.huiyi.campus.dao.vo.health.StudentHealthInfoPhyDateVo;
import com.huiyi.campus.dao.vo.health.StudentHealthInfoVo;
import org.mapstruct.Mapper;

import java.util.List;

public interface PhyStudentHealthInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhyStudentHealthInfoEntity record);

    int insertSelective(PhyStudentHealthInfoEntity record);

    StudentHealthInfoVo selectByPrimaryKey(PhyStudentHealthInfoEntity record);

    int updateByPrimaryKeySelective(PhyStudentHealthInfoEntity record);

    int updateByPrimaryKey(PhyStudentHealthInfoEntity record);

    List<StudentHealthInfoPhyDateVo> selectPhyDateByPhyStudentId(PhyStudentHealthInfoEntity phyStudentHealthInfoEntity);
}