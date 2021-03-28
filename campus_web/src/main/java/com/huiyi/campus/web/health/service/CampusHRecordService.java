package com.huiyi.campus.web.health.service;

import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;

public interface CampusHRecordService {
    CrRpcResult createStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto);
}
