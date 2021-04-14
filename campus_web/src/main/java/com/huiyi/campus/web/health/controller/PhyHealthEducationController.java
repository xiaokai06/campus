package com.huiyi.campus.web.health.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.phy.PhyHealthEducationEntity;
import com.huiyi.campus.web.health.service.PhyHealthEducationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yzg
 * @time: 2021-04-14 14:35
 * @description: 健康宣教
 */
@Api(tags = "健康宣教")
@RestController
@RequestMapping("/phyHe")
@CrossOrigin
public class PhyHealthEducationController {

    PhyHealthEducationService phyHealthEducationService;

    PhyHealthEducationController(PhyHealthEducationService phyHealthEducationService) {
        this.phyHealthEducationService = phyHealthEducationService;
    }

    @IsLogin
    @ApiOperation("获取所有健康宣教列表")
    @PostMapping("/getHealthEducation")
    public CrRpcResult getHealthEducation(@RequestBody PhyHealthEducationEntity phyHealthEducationEntity) {
        return phyHealthEducationService.selectHealthEducation(phyHealthEducationEntity);
    }

    @IsLogin
    @ApiOperation("新增健康宣教")
    @PostMapping("/insertPhyHe")
    public ResultBody insertHealthEducation(@RequestBody PhyHealthEducationEntity phyHealthEducationEntity) {
        return phyHealthEducationService.insertHealthEducation(phyHealthEducationEntity);
    }

    @IsLogin
    @ApiOperation("修改健康宣教")
    @PostMapping("/updatePhyHe")
    public ResultBody updateHealthEducation(@RequestBody PhyHealthEducationEntity phyHealthEducationEntity) {
        return phyHealthEducationService.updateHealthEducation(phyHealthEducationEntity);
    }

    @IsLogin
    @ApiOperation("删除健康宣教")
    @GetMapping("/deletePhyHe")
    public ResultBody deleteHealthEducation(@RequestParam Integer id) {
        return phyHealthEducationService.deleteHealthEducation(id);
    }

}
