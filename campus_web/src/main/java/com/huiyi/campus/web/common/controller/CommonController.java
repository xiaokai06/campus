package com.huiyi.campus.web.common.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.utils.JsonUtils;
import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.common.utils.rs.SystemErrorEnum;
import com.huiyi.campus.dao.dto.common.SchoolDto;
import com.huiyi.campus.dao.vo.sys.TokenVo;
import com.huiyi.campus.web.common.service.CommonService;
import com.huiyi.campus.web.sys.service.UserCacheService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    UserCacheService userCacheService;

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
     * 根据学校id或教育局ID查询当前所归属学校
     *
     * @param schoolDto
     * @return
     */
    @IsLogin
    @PostMapping("/selectSchoolBySchoolIdAndOrganId")
    public HQJsonResult selectSchoolBySchoolIdAndOrganId(@RequestBody SchoolDto schoolDto, @RequestHeader("acc") String nickName) {
        TokenVo tokenVo = userCacheService.getUserCache(nickName);
        if (JsonUtils.checkObjAllFieldsIsNull(tokenVo)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        schoolDto.setOrganId(tokenVo.getOrganId());
        schoolDto.setSchoolId(tokenVo.getSchoolId());

//        String schoolId = String.valueOf(schoolDto.getSchoolId());
//        if (StringUtils.isEmpty(schoolId)) {
//            schoolDto.setSchoolId(Integer.valueOf("15"));
//        }
        return commonService.selectSchoolBySchoolIdAndOrganId(schoolDto);
    }

    /**
     * 根据机构id查询教育局机构id
     */
    @IsLogin
    @PostMapping("/selectOrganByOrganId")
    public HQJsonResult selectOrganByOrganId(@RequestBody SchoolDto schoolDto, @RequestHeader("acc") String nickName) {
        TokenVo tokenVo = userCacheService.getUserCache(nickName);
        if (JsonUtils.checkObjAllFieldsIsNull(tokenVo)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        schoolDto.setOrganId(tokenVo.getOrganId());
        schoolDto.setSchoolId(tokenVo.getSchoolId());
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

    /**
     * 测试接口-忽略
     *
     * @param orgId
     * @param schoolId
     * @return
     */
    @PostMapping("/test")
    public List<Integer> test(@RequestParam("orgId") Integer orgId, @RequestParam("schoolId") Integer schoolId) {
        return commonService.getSchoolIdStr(orgId, schoolId);

    }
}
