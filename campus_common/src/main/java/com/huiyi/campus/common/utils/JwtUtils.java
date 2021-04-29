package com.huiyi.campus.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.huiyi.campus.common.base.CommonEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: yzg
 * @time: 2021-04-29 13:47
 * @description: jwt工具类
 */
@Component
public class JwtUtils {

    /**
     * jwt 密钥
     */
    @Value("${jwt.secret}")
    private String SECRET;

    /**
     * 生成签名
     * @param nickName
     * @return
     */
    public String sign(String nickName) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    // 将用户昵称保存到 token 里面
                    .withAudience(nickName)
                    // token 的密钥
                    .sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据token获取用户昵称
     * @param token
     * @return
     */
    public String getNickName(String token) {
        try {
            return JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException e) {
            throw new RuntimeException(CommonEnum.INVALID_TOKEN.getResultMsg());
        }
    }

    /**
     * 校验token
     * @param token
     */
    public void checkSign(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
        } catch (JWTVerificationException exception) {
            throw new RuntimeException(CommonEnum.INVALID_TOKEN.getResultMsg());
        }
    }

}
