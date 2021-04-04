package com.huiyi.campus.web.sys.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.huiyi.campus.web.sys.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author: yzg
 * @time: 2021-03-30 17:08
 * @description:
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String getToken(String nickName) {
        return JWT.create().withAudience(nickName)// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(UUID.randomUUID().toString()));// 以 uuid 作为 token 的密钥
    }

}