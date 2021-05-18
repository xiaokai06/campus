package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.dto.sys.PhyProjectDto;
import com.huiyi.campus.web.sys.service.SysProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yzg
 * @time: 2021-05-17 10:40
 * @description: 项目字典
 */
@Api("项目字典")
@RestController
@RequestMapping("/project")
@CrossOrigin
public class SysProjectController {

    private final SysProjectService sysProjectService;

    SysProjectController(SysProjectService sysProjectService) {
        this.sysProjectService = sysProjectService;
    }

    @IsLogin
    @ApiOperation("查询所有项目字典")
    @PostMapping("/selectProject")
    public CrRpcResult getAllProject(@RequestBody PhyProjectDto phyProjectDto) {
        return sysProjectService.selectAllProject(phyProjectDto);
    }

    @IsLogin
    @ApiOperation("查询所有项目归类")
    @GetMapping("/selectProjectType")
    public ResultBody getProjectType() {
        return sysProjectService.selectProjectType();
    }

}
