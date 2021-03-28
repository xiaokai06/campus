package com.huiyi.campus.web.health.service;

import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.dao.dto.health.StudentHealthInfoDto;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;

public interface CampusHRecordService {
    CrRpcResult createStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto);

    CrRpcResult queryStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto);

    CrRpcResult createStudentHealthInfo(StudentHealthInfoDto studentHealthInfoDto);

    CrRpcResult updateStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto);

    CrRpcResult deleteStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto);

    CrRpcResult updateStudentHealthInfo(StudentHealthInfoDto studentHealthInfoDto);

    CrRpcResult selectStudentHealthInfo(StudentHealthInfoDto studentHealthInfoDto);
}
