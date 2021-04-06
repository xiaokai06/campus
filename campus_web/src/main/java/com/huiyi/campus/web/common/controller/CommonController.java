package com.huiyi.campus.web.common.controller;

import com.huiyi.campus.common.utils.rs.HQJsonResult;
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
     * @return
     */
    @GetMapping("/area")
    public HQJsonResult area() {
        return commonService.area();
    }
}