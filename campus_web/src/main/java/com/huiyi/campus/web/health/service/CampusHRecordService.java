package com.huiyi.campus.web.health.service;

import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.dao.dto.health.ExportStudentInfoDto;
import com.huiyi.campus.dao.dto.health.StudentHealthInfoDto;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface CampusHRecordService {
    HQJsonResult createStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto);

    HQJsonResult queryStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto,String nickName);

    HQJsonResult createStudentHealthInfo(StudentHealthInfoDto studentHealthInfoDto);

    HQJsonResult updateStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto);

    HQJsonResult deleteStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto);

    HQJsonResult updateStudentHealthInfo(StudentHealthInfoDto studentHealthInfoDto);

    HQJsonResult selectStudentHealthInfo(StudentHealthInfoDto studentHealthInfoDto);

    String exportStudentInfoFile(ExportStudentInfoDto exportStudentInfoDto, HttpServletResponse response,String nickName);

    String importStudentInfoFile(MultipartFile file);

    HQJsonResult selectPhyDateByPhyStudentId(StudentHealthInfoDto studentHealthInfoDto);

    PhyStudentInfoEntity selectByStudentId(String studentId);

    HQJsonResult selectStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto);
}
