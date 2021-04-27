package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.dao.vo.sys.SchoolOrganVo;
import com.huiyi.campus.dao.vo.sys.TokenVo;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-26 15:17
 * @description: 用户缓存
 */
public interface UserCacheService {

    /**
     * 通过昵称存储用户信息至缓存
     * @param nickName
     * @param tokenVo
     */
    void setUserCache(String nickName, TokenVo tokenVo);

    /**
     * 通过昵称从缓存获取用户信息
     * @param nickName
     * @return
     */
    TokenVo getUserCache(String nickName);

    /**
     * 通过昵称删除用户缓存
     * @param nickName
     * @return
     */
    void delUserCache(String nickName);

    /**
     * 判断缓存中是否存在改昵称
     * @param nickName
     * @return
     */
    boolean hasUserKey(String nickName);

    /**
     * 通过昵称获取相应的机构-学校
     * @param nickName
     * @return
     */
    List<SchoolOrganVo> getOrganSchool(String nickName);

    /**
     * 通过用户昵称获取所有学校ID
     * @param nickName
     * @return
     */
    List<Integer> getAllSchoolId(String nickName);

}
