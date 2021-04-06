package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysDoctorEntity;
import com.huiyi.campus.web.sys.service.SysDoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yzg
 * @time: 2021-04-06 16:01
 * @description: 医生管理
 */
@Api(tags = "医生管理")
@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class SysDoctorController {

    SysDoctorService sysDoctorService;

    SysDoctorController(SysDoctorService sysDoctorService) {
        this.sysDoctorService = sysDoctorService;
    }

    @ApiOperation("获取所有医生")
    @PostMapping("/getAllDoctor")
    public ResultBody getAllDoctor(@RequestBody SysDoctorEntity sysDoctorEntity) {
        return sysDoctorService.selectAllDoctor(sysDoctorEntity);
    }

    @ApiOperation("新增医生")
    @PostMapping("/insertDoctor")
    public ResultBody insertDoctor(@RequestBody SysDoctorEntity sysDoctorEntity) {
        return sysDoctorService.insertDoctorInfo(sysDoctorEntity);
    }

    @ApiModelProperty("修改医生")
    @PostMapping("/updateDoctor")
    public ResultBody updateDoctor(@RequestBody SysDoctorEntity sysDoctorEntity) {
        return sysDoctorService.updateDoctorInfo(sysDoctorEntity);
    }

    @ApiOperation("删除医生")
    @GetMapping("/deleteDoctor")
    public ResultBody deleteDoctor(@RequestBody Integer id) {
        return sysDoctorService.deleteDoctorInfo(id);
    }

}
