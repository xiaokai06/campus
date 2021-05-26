package com.huiyi.campus.web.health.controller;

import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.dao.dto.health.PhyReportDto;
import com.huiyi.campus.dao.dto.health.StudentHealthInfoDto;
import com.huiyi.campus.web.health.service.CampusHRecordService;
import com.huiyi.campus.web.health.service.CampusPhyReportService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/phy")
public class CampusPhyReportController {

    private final CampusPhyReportService campusPhyReportService;
    private final CampusHRecordService campusHRecordService;

    CampusPhyReportController(CampusPhyReportService campusPhyReportService,
                              CampusHRecordService campusHRecordService) {
        this.campusHRecordService = campusHRecordService;
        this.campusPhyReportService = campusPhyReportService;
    }

    /**
     * 体检报告列表查询
     *
     * @return
     */
    @PostMapping("/selectPhyReport")
    public CrRpcResult selectAllReport(@RequestBody PhyReportDto phyReportDto) {
        return campusPhyReportService.selectPhyReport(phyReportDto);
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
