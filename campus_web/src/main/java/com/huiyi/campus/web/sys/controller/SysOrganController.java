package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysOrganEntity;
import com.huiyi.campus.web.sys.service.SysOrganService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("获取所有机构")
    @PostMapping("/getAllOrgan")
    public ResultBody getAllOrgan(@RequestBody SysOrganEntity sysOrganEntity) {
        return sysOrganService.selectAllOrgan(sysOrganEntity);
    }

    @ApiOperation("新增机构")
    @PostMapping("/insertOrgan")
    public ResultBody insertOrgan(@RequestBody SysOrganEntity sysOrganEntity) {
        return sysOrganService.insertOrganInfo(sysOrganEntity);
    }

    @ApiOperation("修改机构")
    @PostMapping("/updateOrgan")
    public ResultBody updateOrgan(@RequestBody SysOrganEntity sysOrganEntity) {
        return sysOrganService.updateOrganInfo(sysOrganEntity);
    }

    @ApiOperation("删除机构")
    @GetMapping("/deleteOrgan")
    public ResultBody deleteOrgan(@RequestParam Integer id) {
        return sysOrganService.deleteOrganInfo(id);
    }

}
