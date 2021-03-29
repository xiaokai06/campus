package com.huiyi.campus.common.utils.rs;


import com.huiyi.campus.common.utils.rs.BusinessErrorEnum;
import com.huiyi.campus.common.utils.rs.SystemErrorEnum;
/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-03-29 14:45
 * @Version V1.0
 */
public class SystemException extends MyBaseException {
    private static final long serialVersionUID = 8912473097017237022L;

    public SystemException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public SystemException(SystemErrorEnum error) {
        super(error);
    }

    public SystemException(SystemErrorEnum error, BusinessErrorEnum desEnum) {
        super(error, desEnum);
    }

    public SystemException(SystemErrorEnum error, String description) {
        super(error, description);
    }
}
