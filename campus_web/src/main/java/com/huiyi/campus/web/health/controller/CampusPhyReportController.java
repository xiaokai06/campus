package com.huiyi.campus.web.health.controller;

import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.dao.dto.health.StudentHealthInfoDto;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.web.health.service.CampusHRecordService;
import com.huiyi.campus.web.health.service.CampusPhyReportService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 体检报告列表查询
     *
     * @param studentInfoRecordDto
     * @param nickName
     * @return
     */
    @PostMapping("/selectAllReport")
    public HQJsonResult selectAllReport(@RequestBody StudentInfoRecordDto studentInfoRecordDto, @RequestHeader("acc") String nickName) {
        return campusHRecordService.queryStudentInfoRecord(studentInfoRecordDto, nickName);
    }

    /**
     * 添加体检报告
     * @param studentHealthInfoDto
     * @return
     */
    @PostMapping("/insertReport")
    public HQJsonResult insertExaminedReport(@RequestBody StudentHealthInfoDto studentHealthInfoDto){
        return campusHRecordService.createStudentHealthInfo(studentHealthInfoDto);
    }

    /**
     * 修改体检报告
     * @param studentHealthInfoDto
     * @return
     */
    @PostMapping("/updateReport")
    public HQJsonResult updateExaminedReport(@RequestBody StudentHealthInfoDto studentHealthInfoDto){
        return campusHRecordService.updateStudentHealthInfo(studentHealthInfoDto);
    }

    /**
     * 根据学生ID查询体检日期
     * @param studentHealthInfoDto
     * @return
     */
    @PostMapping("/selectExaminedDate")
    public HQJsonResult selectExaminedDate(@RequestBody StudentHealthInfoDto studentHealthInfoDto){
        return campusHRecordService.selectPhyDateByPhyStudentId(studentHealthInfoDto);
    }


}
