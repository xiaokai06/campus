package com.huiyi.campus.web.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.common.utils.RedisUtils;
import com.huiyi.campus.dao.vo.sys.TokenVo;
import com.huiyi.campus.web.sys.service.UserCacheService;
import org.springframework.stereotype.Service;

/**
 * @author: yzg
 * @time: 2021-04-26 15:21
 * @description: 用户缓存实现类
 */
@Service
public class UserCacheServiceImpl implements UserCacheService {

    RedisUtils redisUtils;

    UserCacheServiceImpl(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    /**
     * 通过昵称存储用户信息至缓存
     * @param nickName
     * @param tokenVo
     */
    @Override
    public void setUserCache(String nickName, TokenVo tokenVo) {
        String key = CommConstants.USER_INFO + nickName;
        redisUtils.set(key, tokenVo, CommConstants.DEFAULT_EXPIRE_TIME);
    }

    /**
     * 通过昵称从缓存获取用户信息
     * @param nickName
     * @return
     */
    @Override
    public TokenVo getUserCache(String nickName) {
        String key = CommConstants.USER_INFO + nickName;
        String str = JSON.toJSONString(redisUtils.get(key));
        return JSON.parseObject(str, TokenVo.class);
    }

    /**
     * 通过昵称删除用户缓存
     * @param nickName
     * @return
     */
    @Override
    public void delUserCache(String nickName) {
        String key = CommConstants.USER_INFO + nickName;
        redisUtils.del(key);
    }

    /**
     * 判断缓存中是否存在改昵称
     * @param nickName
     * @return
     */
    @Override
    public boolean hasUserKey(String nickName) {
        String key = CommConstants.USER_INFO + nickName;
        return redisUtils.hasKey(key);
    }
}
