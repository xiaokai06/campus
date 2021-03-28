package com.huiyi.campus.web.health.controller;

import com.huiyi.campus.common.base.CrRpcResult;
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
     * 创建学生健康档案
     * @return
     */
    @PostMapping("/createStudentInfoRecord")
    public CrRpcResult createStudentInfoRecord(@RequestBody StudentInfoRecordDto studentInfoRecordDto){
        return campusHRecordService.createStudentInfoRecord(studentInfoRecordDto);
    }
    @GetMapping("/get")
    public String get(){
        return "你好";
    }




}
