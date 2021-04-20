package com.huiyi.campus.web.common.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.dao.dto.common.SchoolDto;
import com.huiyi.campus.web.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 公共接口
 * @date: 2021-04-06 17:11
 * @Version V1.0
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    CommonService commonService;

    /**
     * 省市区三级联动查询
     *
     * @return
     */
    @IsLogin
    @GetMapping("/area")
    public HQJsonResult area() {
        return commonService.area();
    }

    /**
     * 根据用户ID与教育局ID查询当前所归属学校
     *
     * @param schoolDto
     * @return
     */
    @IsLogin
    @PostMapping("/selectSchoolByUserId")
    public HQJsonResult selectSchoolByUserId(@RequestBody SchoolDto schoolDto) {
        return commonService.selectSchoolByUserId(schoolDto);
    }
    /**
     * 根据用户id查询教育局机构id
     */
    @IsLogin
    @PostMapping("/selectOrganByOrganId")
    public HQJsonResult selectOrganByOrganId(@RequestBody SchoolDto schoolDto){
        return commonService.selectOrganByOrganId(schoolDto);
    }

    /**
     * 根据学校ID查询专业班级
     *
     * @param schoolDto
     * @return
     */
    @IsLogin
    @PostMapping("/selectClassBySchoolId")
    public HQJsonResult selectClassBySchoolId(@RequestBody SchoolDto schoolDto) {
        return commonService.selectClassBySchoolId(schoolDto);
    }

    /**
     * 参数字典表查询
     */
    @IsLogin
    @GetMapping("/selectType")
    public HQJsonResult selectType() {
        return commonService.selectType();
    }
}
