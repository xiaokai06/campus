package com.huiyi.campus.dao.mapper.web.phy;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;
import com.huiyi.campus.dao.vo.health.StudentInfoRecordVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PhyStudentInfoMapper extends BaseMapper<PhyStudentInfoEntity> {
    int deleteByPrimaryKey(String id);

    int insert(PhyStudentInfoEntity record);

    int insertSelective(PhyStudentInfoEntity record);

    PhyStudentInfoEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhyStudentInfoEntity record);

    int updateByPrimaryKey(PhyStudentInfoEntity record);

    List<StudentInfoRecordVo> selectAll(StudentInfoRecordDto studentInfoRecordDto);

    int insertSelectiveList(List<PhyStudentInfoEntity> phyStudentInfoEntityList);
}