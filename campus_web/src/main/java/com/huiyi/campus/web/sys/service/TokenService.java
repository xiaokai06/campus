package com.huiyi.campus.web.sys.service;

/**
 * @author: yzg
 * @time: 2021-03-30 17:07
 * @description: 获取token
 */
public interface TokenService {

    /**
     * 通过昵称获取token
     * @param nickName
     * @return
     */
    String getToken(String nickName);

}
