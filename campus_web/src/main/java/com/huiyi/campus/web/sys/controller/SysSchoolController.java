package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;
import com.huiyi.campus.web.sys.service.SysSchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("获取所有学校")
    @PostMapping("/getAllSchool")
    public ResultBody getAllSchool(@RequestBody SysSchoolEntity sysSchoolEntity) {
        return sysSchoolService.selectAllSchool(sysSchoolEntity);
    }

    @ApiOperation("新增学校")
    @PostMapping("/insertSchool")
    public ResultBody insertSchoolInfo(@RequestBody SysSchoolEntity sysSchoolEntity) {
        return sysSchoolService.insertSchoolInfo(sysSchoolEntity);
    }

    @ApiOperation("修改学校")
    @PostMapping("/updateSchool")
    public ResultBody updateSchoolInfo(@RequestBody SysSchoolEntity sysSchoolEntity) {
        return sysSchoolService.updateSchoolInfo(sysSchoolEntity);
    }

    @ApiOperation("删除学校")
    @GetMapping("/deleteSchool")
    public ResultBody deleteSchoolInfo(@RequestParam Integer id) {
        return sysSchoolService.deleteSchoolInfo(id);
    }

}
