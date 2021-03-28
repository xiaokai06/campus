package com.huiyi.campus.web.health.controller;

import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.dao.dto.health.StudentHealthInfoDto;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.web.health.service.CampusHRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 校园健康档案服务控制台模块
 * @date: 2021-03-28 13:35
 * @Version V1.0
 */
@Slf4j
@RestController
@RequestMapping("/hrecord")
public class CampusHRecordController {

    @Autowired
    CampusHRecordService campusHRecordService;

    /**
     * 获取所有学生档案信息
     *
     * @param studentInfoRecordDto
     * @return
     */
    @PostMapping("/queryStudentInfoRecord")
    public CrRpcResult queryStudentInfoRecord(@RequestBody StudentInfoRecordDto studentInfoRecordDto) {
        return campusHRecordService.queryStudentInfoRecord(studentInfoRecordDto);
    }

    /**
     * 创建学生档案信息
     *
     * @return
     */
    @PostMapping("/createStudentInfoRecord")
    public CrRpcResult createStudentInfoRecord(@RequestBody StudentInfoRecordDto studentInfoRecordDto) {
        return campusHRecordService.createStudentInfoRecord(studentInfoRecordDto);
    }

    /**
     * 修改学生档案信息
     *
     * @param studentInfoRecordDto
     * @return
     */
    @PostMapping("/updateStudentInfoRecord")
    public CrRpcResult updateStudentInfoRecord(@RequestBody StudentInfoRecordDto studentInfoRecordDto) {
        return campusHRecordService.updateStudentInfoRecord(studentInfoRecordDto);
    }

    /**
     * 删除学生档案信息
     *
     * @param studentInfoRecordDto
     * @return
     */
    @PostMapping("/deleteStudentInfoRecord")
    public CrRpcResult deleteStudentInfoRecord(@RequestBody StudentInfoRecordDto studentInfoRecordDto) {
        return campusHRecordService.deleteStudentInfoRecord(studentInfoRecordDto);
    }

    /**
     * 创建学生健康档案信息
     *
     * @return
     */
    @PostMapping("/createStudentHealthInfo")
    public CrRpcResult createStudentHealthInfo(@RequestBody StudentHealthInfoDto studentHealthInfoDto) {
        return campusHRecordService.createStudentHealthInfo(studentHealthInfoDto);
    }

    /**
     * 查询学生健康档案信息
     * @param studentHealthInfoDto
     * @return
     */
    @PostMapping("/selectStudentHealthInfo")
    public CrRpcResult selectStudentHealthInfo(@RequestBody StudentHealthInfoDto studentHealthInfoDto) {
        return campusHRecordService.selectStudentHealthInfo(studentHealthInfoDto);
    }


    /**
     * 修改学生健康档案信息
     *
     * @param studentHealthInfoDto
     * @return
     */
    @PostMapping("/updateStudentHealthInfo")
    public CrRpcResult updateStudentHealthInfo(@RequestBody StudentHealthInfoDto studentHealthInfoDto) {
        return campusHRecordService.updateStudentHealthInfo(studentHealthInfoDto);
    }


}
