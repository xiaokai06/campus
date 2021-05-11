package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.dao.dto.sys.LogDto;
import com.huiyi.campus.web.sys.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yzg
 * @time: 2021-05-11 16:02
 * @description: 日志管理
 */
@Api(tags = "日志管理")
@RestController
@RequestMapping("/log")
@CrossOrigin
public class SysLogController {

    SysLogService sysLogService;

    SysLogController(SysLogService sysLogService) {
        this.sysLogService = sysLogService;
    }

    @IsLogin
    @PostMapping("/loginLog")
    @ApiModelProperty("获取所有登录日志记录")
    public CrRpcResult getLoginLogResult(@RequestBody LogDto logDto) {
        return sysLogService.selectLoginLog(logDto);
    }

    @IsLogin
    @PostMapping("/operLog")
    @ApiModelProperty("获取所有操作日志记录")
    public CrRpcResult getOperLogResult(@RequestBody LogDto logDto) {
        return sysLogService.selectOperLog(logDto);
    }

}
