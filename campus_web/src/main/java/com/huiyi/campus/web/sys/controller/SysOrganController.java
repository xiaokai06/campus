package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.annotaion.OperLog;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.dao.entity.sys.SysOrganEntity;
import com.huiyi.campus.web.sys.service.SysOrganService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: yzg
 * @time: 2021-04-06 11:06
 * @description: 机构管理
 */
@Api(tags = "机构管理")
@RestController
@RequestMapping("/organ")
@CrossOrigin
public class SysOrganController {

    SysOrganService sysOrganService;

    SysOrganController(SysOrganService sysOrganService){
        this.sysOrganService = sysOrganService;
    }

    @IsLogin
    @ApiOperation("获取所有机构")
    @PostMapping("/getAllOrgan")
    public ResultBody getAllOrgan(@RequestBody SysOrganEntity sysOrganEntity, HttpServletRequest request) {
        String nickName = request.getHeader(CommConstants.ACC);
        return sysOrganService.selectAllOrgan(nickName,sysOrganEntity);
    }

    @IsLogin
    @ApiOperation("新增机构")
    @PostMapping("/insertOrgan")
    @OperLog(operModule = "机构管理-新增", operType = CommConstants.ADD, operDesc = "机构管理-新增机构")
    public ResultBody insertOrgan(@RequestBody SysOrganEntity sysOrganEntity) {
        return sysOrganService.insertOrganInfo(sysOrganEntity);
    }

    @IsLogin
    @ApiOperation("修改机构")
    @PostMapping("/updateOrgan")
    @OperLog(operModule = "机构管理-修改", operType = CommConstants.UPDATE, operDesc = "机构管理-修改机构")
    public ResultBody updateOrgan(@RequestBody SysOrganEntity sysOrganEntity) {
        return sysOrganService.updateOrganInfo(sysOrganEntity);
    }

    @IsLogin
    @ApiOperation("删除机构")
    @GetMapping("/deleteOrgan")
    @OperLog(operModule = "机构管理-删除", operType = CommConstants.DELETE, operDesc = "机构管理-删除机构")
    public ResultBody deleteOrgan(@RequestParam Integer id) {
        return sysOrganService.deleteOrganInfo(id);
    }

}
