package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.dto.health.ExportStudentInfoDto;
import com.huiyi.campus.dao.dto.health.ReportStudentInfoDto;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;
import com.huiyi.campus.dao.vo.health.StudentInfoRecordVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhyStudentInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhyStudentInfoEntity record);

    int insertSelective(PhyStudentInfoEntity record);

    PhyStudentInfoEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhyStudentInfoEntity record);

    int updateByPrimaryKey(PhyStudentInfoEntity record);

    List<StudentInfoRecordVo> selectAll(StudentInfoRecordDto studentInfoRecordDto);

    List<StudentInfoRecordVo> exportStudentInfo(ExportStudentInfoDto exportStudentInfoDto);

    int insertSelectiveList(List<ReportStudentInfoDto> phyStudentInfoEntityList);

    int deleteByPrimaryKeyAndHealthAndItem(String id);

    StudentInfoRecordVo selectStudentByStudentNumber(StudentInfoRecordDto studentInfoRecordDto);

    StudentInfoRecordVo selectByPrimaryStudentKey(PhyStudentInfoEntity phyStudentInfoEntity);
}