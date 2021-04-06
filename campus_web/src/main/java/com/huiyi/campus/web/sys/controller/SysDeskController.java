package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysDeskEntity;
import com.huiyi.campus.web.sys.service.SysDeskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yzg
 * @time: 2021-04-06 17:57
 * @description: 科室管理
 */
@Api(tags = "科室管理")
@RestController
@RequestMapping("/desk")
@CrossOrigin
public class SysDeskController {

    SysDeskService sysDeskService;

    SysDeskController(SysDeskService sysDeskService) {
        this.sysDeskService = sysDeskService;
    }

    @ApiOperation("获取所有科室")
    @PostMapping("/getAllDesk")
    public ResultBody getAllDesk(@RequestBody SysDeskEntity sysDeskEntity) {
        return sysDeskService.getAllDesk(sysDeskEntity);
    }

    @ApiOperation("新增科室")
    @PostMapping("/insertDesk")
    public ResultBody insertDeskInfo(@RequestBody SysDeskEntity sysDeskEntity) {
        return sysDeskService.insertDesk(sysDeskEntity);
    }

    @ApiOperation("修改科室")
    @PostMapping("/updateDesk")
    public ResultBody updateDeskInfo(@RequestBody SysDeskEntity sysDeskEntity) {
        return sysDeskService.updateDesk(sysDeskEntity);
    }

    @ApiOperation("删除科室")
    @GetMapping("/deleteDesk")
    public ResultBody deleteDeskInfo(@RequestParam Integer id) {
        return sysDeskService.deleteDesk(id);
    }

}
