package com.huiyi.campus.config;

import com.huiyi.campus.common.base.CommonEnum;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yzg
 * @date 2018-07-08 22:37
 */
@Component
@ControllerAdvice
public class GloablExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultBody handleException(Exception e) {
        String msg = e.getMessage();
        if (msg != null) {
            if (msg.equals(CommonEnum.INVALID_TOKEN.getResultMsg())) {
                return ResultBody.invalidToken();
            }
            if (msg.equals(CommConstants.NOT_LOGIN)) {
                return ResultBody.loginTimeOut();
            }
        } else {
            msg = CommonEnum.INTERNAL_SERVER_ERROR.getResultMsg();
        }
        return ResultBody.error(msg);
    }
}