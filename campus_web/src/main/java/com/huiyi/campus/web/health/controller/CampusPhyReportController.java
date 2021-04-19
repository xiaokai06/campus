package com.huiyi.campus.web.health.controller;

import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.web.health.service.CampusHRecordService;
import com.huiyi.campus.web.health.service.CampusPhyReportService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 健康报告管理-校园健康体检报告
 * @date: 2021-04-19 13:46
 * @Version V1.0
 */
@Api(tags = "校园健康体检报告")
@Slf4j
@RestController
@RequestMapping("/preport")
public class CampusPhyReportController {

    @Autowired
    CampusPhyReportService campusPhyReportService;

    @Autowired
    CampusHRecordService campusHRecordService;

    @PostMapping("/selectAllReport")
    public HQJsonResult selectAllReport(@RequestBody StudentInfoRecordDto studentInfoRecordDto) {
        return campusHRecordService.queryStudentInfoRecord(studentInfoRecordDto);
    }


}
