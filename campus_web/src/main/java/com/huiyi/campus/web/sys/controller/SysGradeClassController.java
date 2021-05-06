package com.huiyi.campus.web.sys.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.dao.entity.sys.SysGradeClassEntity;
import com.huiyi.campus.dao.entity.sys.SysGradeEntity;
import com.huiyi.campus.web.sys.service.SysGradeClassService;
import com.huiyi.campus.web.sys.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 班级管理
 * @date: 2021-04-21 14:22
 * @Version V1.0
 */
@RestController
@RequestMapping("/grade")
public class SysGradeClassController {

    @Autowired
    SysGradeClassService sysGradeClassService;
    @Autowired
    UserCacheService userCacheService;

    /**
     * 根据学校id查询年级班级数据
     *
     * @param sysGradeEntity
     * @return
     */
    @IsLogin
    @PostMapping("/queryGradeClass")
    public HQJsonResult queryGradeClass(@RequestBody SysGradeEntity sysGradeEntity) {
        return sysGradeClassService.queryGradeClass(sysGradeEntity);
    }


    /**
     * 新增年级
     *
     * @param sysGradeEntity
     * @return
     */
    @IsLogin
    @PostMapping("/insertGrade")
    public HQJsonResult insertGrade(@RequestBody SysGradeEntity sysGradeEntity) {
        return sysGradeClassService.insertGrade(sysGradeEntity);
    }

    /**
     * 查询年级和班级接口
     *
     * @param sysGradeEntity
     * @return
     */
    @IsLogin
    @PostMapping("/selectGrade")
    public HQJsonResult selectGrade(@RequestBody SysGradeEntity sysGradeEntity, @RequestHeader("acc") String nickName) {
        return sysGradeClassService.selectGrade(sysGradeEntity,nickName);
    }

    /**
     * 修改年级
     *
     * @param sysGradeEntity
     * @return
     */
    @IsLogin
    @PostMapping("/updateGrade")
    public HQJsonResult updateGrade(@RequestBody SysGradeEntity sysGradeEntity) {
        return sysGradeClassService.updateGrade(sysGradeEntity);
    }

    /**
     * 删除年级
     *
     * @param sysGradeEntity
     * @return
     */
    @IsLogin
    @PostMapping("/deleteGrade")
    public HQJsonResult deleteGrade(@RequestBody SysGradeEntity sysGradeEntity) {
        return sysGradeClassService.deleteGrade(sysGradeEntity);
    }

    /**
     * 新增当前年级下的班级
     *
     * @param sysGradeClassEntity
     * @return
     */
    @IsLogin
    @PostMapping("/insertGradeClass")
    public HQJsonResult insertGradeClass(@RequestBody SysGradeClassEntity sysGradeClassEntity) {
        return sysGradeClassService.insertGradeClass(sysGradeClassEntity);
    }

    /**
     * 查询当前年级下的班级
     *
     * @param sysGradeClassEntity
     * @return
     */
    @IsLogin
    @PostMapping("/selectGradeClass")
    public HQJsonResult selectGradeClass(@RequestBody SysGradeClassEntity sysGradeClassEntity) {
        return sysGradeClassService.selectGradeClass(sysGradeClassEntity);
    }

    /**
     * 修改当前年级下的班级
     *
     * @param sysGradeClassEntity
     * @return
     */
    @IsLogin
    @PostMapping("/updateGradeClass")
    public HQJsonResult updateGradeClass(@RequestBody SysGradeClassEntity sysGradeClassEntity) {
        return sysGradeClassService.updateGradeClass(sysGradeClassEntity);
    }

    /**
     * 删除当前年级下的班级
     *
     * @param sysGradeClassEntity
     * @return
     */
    @IsLogin
    @PostMapping("/deleteGradeClass")
    public HQJsonResult deleteGradeClass(@RequestBody SysGradeClassEntity sysGradeClassEntity) {
        return sysGradeClassService.deleteGradeClass(sysGradeClassEntity);
    }

}
