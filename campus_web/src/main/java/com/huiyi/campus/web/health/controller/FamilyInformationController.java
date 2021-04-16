package com.huiyi.campus.web.health.controller;

import com.huiyi.campus.common.utils.rs.HQJsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 健康体检报告管理-家庭信息
 * @date: 2021-04-16 18:19
 * @Version V1.0
 */
@RestController
@RequestMapping("/family")
public class FamilyInformationController {


    /**
     * 查询家庭信息
     *
     * @return
     */
    @PostMapping("/")
    public HQJsonResult selectFamily() {
        return null;
    }

    /**
     * 添加家庭成员
     *
     * @return
     */
    @PostMapping("/")
    public HQJsonResult addFamilyMember() {
        return null;
    }

    /**
     * 修改家庭成员
     *
     * @return
     */
    @PostMapping("/")
    public HQJsonResult updateFamilyMember() {
        return null;
    }

    /**
     * 删除家庭成员
     *
     * @return
     */
    @PostMapping("/")
    public HQJsonResult deleteFamilyMember() {
        return null;
    }
}
