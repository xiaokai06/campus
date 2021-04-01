package com.huiyi.campus.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.annotaion.PassToken;
import com.huiyi.campus.common.base.CommonEnum;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.common.utils.*;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author yzg
 * @date 2020/10/13 0013
 * @description: 拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    AESUtils aesUtils;
    @Autowired
    RSAUtils rsaUtils;
    @Autowired
    SysUserDao sysUserDao;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        String aesToken = httpServletRequest.getHeader(CommConstants.TOKEN);
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有已经登录的注解
        if (method.isAnnotationPresent(IsLogin.class)) {
            IsLogin userLoginToken = method.getAnnotation(IsLogin.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (aesToken == null) {
                    logger.info("无token，请重新登录");
                    throw new RuntimeException("无token，请重新登录");
                }
                String token = aesUtils.decrypt(aesToken);
                try {
                    String nickName = JWT.decode(token).getAudience().get(0);
                    if (!StringUtils.isEmpty(nickName)) {
                        boolean bl = redisUtils.hasKey(CommConstants.USER_INFO + nickName);
                        if (!bl) {
                            SysUserEntity sysUserEntity = sysUserDao.selectUserByNickName(nickName);
                            if (null == sysUserEntity) {
                                throw new RuntimeException("用户不存在，请重新登录");
                            }
                        }
                    }
                } catch (JWTDecodeException j) {
                    throw new RuntimeException(CommonEnum.SIGNATURE_NOT_MATCH.getResultMsg());
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
