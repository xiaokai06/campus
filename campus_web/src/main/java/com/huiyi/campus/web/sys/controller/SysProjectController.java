package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.dto.sys.PhyProjectDto;
import com.huiyi.campus.dao.entity.phy.PhyProject;
import com.huiyi.campus.dao.entity.phy.PhySexAgeRef;
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

    @IsLogin
    @ApiOperation("新增项目字典")
    @PostMapping("/insertProject")
    public ResultBody insertProject(@RequestBody PhyProject phyProject) {
        return sysProjectService.insertProject(phyProject);
    }

    @IsLogin
    @ApiOperation("修改项目字典")
    @PostMapping("/updateProject")
    public ResultBody updateProject(@RequestBody PhyProject phyProject) {
        return sysProjectService.updateProject(phyProject);
    }

    @IsLogin
    @ApiOperation("删除项目字典")
    @GetMapping("/deleteProject")
    public ResultBody deleteProject(@RequestParam("id") Integer id) {
        return sysProjectService.deleteProject(id);
    }

    @IsLogin
    @ApiOperation("查询性别年龄参考值")
    @GetMapping("/selectSexAgeRef")
    public ResultBody selectSexAgeRef(@RequestParam("id") Integer id) {
        return sysProjectService.selectSexAgeRef(id);
    }

    @IsLogin
    @ApiOperation("新增性别年龄参考值")
    @PostMapping("/insertSexAgeRef")
    public ResultBody insertSexAgeRef(@RequestBody PhySexAgeRef phySexAgeRef) {
        return sysProjectService.insertPhySexAgeRef(phySexAgeRef);
    }

    @IsLogin
    @ApiOperation("修改性别年龄参考值")
    @PostMapping("/updateSexAgeRef")
    public ResultBody updateSexAgeRef(@RequestBody PhySexAgeRef phySexAgeRef) {
        return sysProjectService.updatePhySexAgeRef(phySexAgeRef);
    }

    @IsLogin
    @ApiOperation("删除性别年龄参考值")
    @GetMapping("/deleteSexAgeRef")
    public ResultBody deleteSexAgeRef(@RequestParam("id") Integer id) {
        return sysProjectService.deletePhySexAgeRef(id);
    }

}
