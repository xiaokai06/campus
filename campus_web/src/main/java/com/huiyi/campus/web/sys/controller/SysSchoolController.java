package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.annotaion.OperLog;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;
import com.huiyi.campus.web.sys.service.SysSchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: yzg
 * @time: 2021-04-06 11:06
 * @description: 学校管理
 */
@Api(tags = "学校管理")
@RestController
@RequestMapping("/school")
@CrossOrigin
public class SysSchoolController {

    SysSchoolService sysSchoolService;

    SysSchoolController(SysSchoolService sysSchoolService) {
        this.sysSchoolService = sysSchoolService;
    }

    @IsLogin
    @ApiOperation("获取所有学校")
    @PostMapping("/getAllSchool")
    public ResultBody getAllSchool(@RequestBody SysSchoolEntity sysSchoolEntity, HttpServletRequest request) {
        String nickName = request.getHeader(CommConstants.ACC);
        return sysSchoolService.selectAllSchool(nickName, sysSchoolEntity);
    }

    @IsLogin
    @ApiOperation("新增学校")
    @PostMapping("/insertSchool")
    @OperLog(operModule = "学校管理-新增", operType = CommConstants.ADD, operDesc = "学校管理-新增学校")
    public ResultBody insertSchoolInfo(@RequestBody SysSchoolEntity sysSchoolEntity) {
        return sysSchoolService.insertSchoolInfo(sysSchoolEntity);
    }

    @IsLogin
    @ApiOperation("修改学校")
    @PostMapping("/updateSchool")
    @OperLog(operModule = "学校管理-修改", operType = CommConstants.UPDATE, operDesc = "学校管理-修改学校")
    public ResultBody updateSchoolInfo(@RequestBody SysSchoolEntity sysSchoolEntity) {
        return sysSchoolService.updateSchoolInfo(sysSchoolEntity);
    }

    @IsLogin
    @ApiOperation("删除学校")
    @GetMapping("/deleteSchool")
    @OperLog(operModule = "学校管理-删除", operType = CommConstants.DELETE, operDesc = "学校管理-删除学校")
    public ResultBody deleteSchoolInfo(@RequestParam Integer id) {
        return sysSchoolService.deleteSchoolInfo(id);
    }

}
