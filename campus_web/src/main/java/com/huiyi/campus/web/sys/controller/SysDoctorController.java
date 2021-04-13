package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.annotaion.OperLog;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.dao.entity.sys.SysDoctorEntity;
import com.huiyi.campus.web.sys.service.SysDoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yzg
 * @time: 2021-04-06 16:01
 * @description: 医生字典
 */
@Api(tags = "医生字典")
@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class SysDoctorController {

    SysDoctorService sysDoctorService;

    SysDoctorController(SysDoctorService sysDoctorService) {
        this.sysDoctorService = sysDoctorService;
    }

    @IsLogin
    @ApiOperation("获取所有医生")
    @PostMapping("/getAllDoctor")
    public ResultBody getAllDoctor(@RequestBody SysDoctorEntity sysDoctorEntity) {
        return sysDoctorService.selectAllDoctor(sysDoctorEntity);
    }

    @IsLogin
    @ApiOperation("新增医生")
    @PostMapping("/insertDoctor")
    @OperLog(operModule = "医生字典-新增", operType = CommConstants.ADD, operDesc = "医生字典-新增医生")
    public ResultBody insertDoctor(@RequestBody SysDoctorEntity sysDoctorEntity) {
        return sysDoctorService.insertDoctorInfo(sysDoctorEntity);
    }

    @IsLogin
    @ApiModelProperty("修改医生")
    @PostMapping("/updateDoctor")
    @OperLog(operModule = "医生字典-修改", operType = CommConstants.UPDATE, operDesc = "医生字典-修改医生")
    public ResultBody updateDoctor(@RequestBody SysDoctorEntity sysDoctorEntity) {
        return sysDoctorService.updateDoctorInfo(sysDoctorEntity);
    }

    @IsLogin
    @ApiOperation("删除医生")
    @GetMapping("/deleteDoctor")
    @OperLog(operModule = "医生字典-删除", operType = CommConstants.DELETE, operDesc = "医生字典-删除医生")
    public ResultBody deleteDoctor(@RequestBody Integer id) {
        return sysDoctorService.deleteDoctorInfo(id);
    }

}
