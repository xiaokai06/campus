package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.annotaion.OperLog;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.dao.entity.sys.SysDeskEntity;
import com.huiyi.campus.web.sys.service.SysDeskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yzg
 * @time: 2021-04-06 17:57
 * @description: 科室字典
 */
@Api(tags = "科室字典")
@RestController
@RequestMapping("/desk")
@CrossOrigin
public class SysDeskController {

    SysDeskService sysDeskService;

    SysDeskController(SysDeskService sysDeskService) {
        this.sysDeskService = sysDeskService;
    }

    @IsLogin
    @ApiOperation("获取所有科室")
    @PostMapping("/getAllDesk")
    public ResultBody getAllDesk(@RequestBody SysDeskEntity sysDeskEntity) {
        return sysDeskService.getAllDesk(sysDeskEntity);
    }

    @IsLogin
    @ApiOperation("新增科室")
    @PostMapping("/insertDesk")
    @OperLog(operModule = "科室字典-新增", operType = CommConstants.ADD, operDesc = "科室字典-新增科室")
    public ResultBody insertDeskInfo(@RequestBody SysDeskEntity sysDeskEntity) {
        return sysDeskService.insertDesk(sysDeskEntity);
    }

    @IsLogin
    @ApiOperation("修改科室")
    @PostMapping("/updateDesk")
    @OperLog(operModule = "科室字典-修改", operType = CommConstants.UPDATE, operDesc = "科室字典-修改科室")
    public ResultBody updateDeskInfo(@RequestBody SysDeskEntity sysDeskEntity) {
        return sysDeskService.updateDesk(sysDeskEntity);
    }

    @IsLogin
    @ApiOperation("删除科室")
    @GetMapping("/deleteDesk")
    @OperLog(operModule = "科室字典-删除", operType = CommConstants.DELETE, operDesc = "科室字典-删除科室")
    public ResultBody deleteDeskInfo(@RequestParam Integer id) {
        return sysDeskService.deleteDesk(id);
    }

}
