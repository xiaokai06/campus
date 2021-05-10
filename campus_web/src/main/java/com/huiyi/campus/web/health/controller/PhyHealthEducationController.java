package com.huiyi.campus.web.health.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.dao.dto.health.PhyHealthEduDto;
import com.huiyi.campus.web.health.service.PhyHealthEducationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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
    public CrRpcResult getHealthEducation(@RequestBody PhyHealthEduDto phyHealthEduDto, HttpServletRequest request) {
        return phyHealthEducationService.selectHealthEducation(phyHealthEduDto, request.getHeader(CommConstants.ACC));
    }

    @IsLogin
    @ApiOperation("新增健康宣教")
    @PostMapping("/insertHealthEducation")
    public ResultBody insertHealthEducation(@RequestBody PhyHealthEduDto phyHealthEduDto, HttpServletRequest request) {
        return phyHealthEducationService.insertHealthEducation(phyHealthEduDto, request.getHeader(CommConstants.ACC));
    }

    @IsLogin
    @ApiOperation("修改健康宣教")
    @PostMapping("/updateHealthEducation")
    public ResultBody updateHealthEducation(@RequestBody PhyHealthEduDto phyHealthEduDto, HttpServletRequest request)  {
        return phyHealthEducationService.updateHealthEducation(phyHealthEduDto, request.getHeader(CommConstants.ACC));
    }

    @IsLogin
    @ApiOperation("删除健康宣教")
    @GetMapping("/deleteHealthEducation")
    public ResultBody deleteHealthEducation(@RequestParam("id") Integer id) {
        return phyHealthEducationService.deleteHealthEducation(id);
    }

    @IsLogin
    @ApiOperation("上传宣教图片")
    @PostMapping("/upLoadImage")
    public ResultBody upLoadImage(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) {
        return phyHealthEducationService.upLoadImage(file, type);
    }

    @IsLogin
    @ApiOperation("下载宣教图片")
    @GetMapping("/downLoad")
    public ResultBody downLoadImage(@RequestParam("id") Integer id) {
        return phyHealthEducationService.downLoadImage(id);
    }

}
