package com.huiyi.campus.common.utils.rs;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-03-29 14:42
 * @Version V1.0
 */
public abstract class MyBaseException extends RuntimeException {
    private static final long serialVersionUID = 8177301895983119239L;
    String code;
    String msg;
    String requestID;

    public String getcode() {
        return this.code;
    }

    public void setcode(String code) {
        this.code = code;
    }

    public String getmsg() {
        return this.msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

    public MyBaseException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public MyBaseException(SystemErrorEnum error) {
        super(error.getMsg());
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

    public MyBaseException(SystemErrorEnum error, BusinessErrorEnum desEnum) {
        super(error.getMsg() + desEnum.getDescription());
        this.code = error.getCode();
        this.msg = error.getMsg() + desEnum.getDescription();
    }

    public MyBaseException(SystemErrorEnum error, String description) {
        super(error.getMsg() + description);
        this.code = error.getCode();
        this.msg = error.getMsg() + description;
    }

    public MyBaseException(String code, String msg, String requestID) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.requestID = requestID;
    }

    public String getRequestID() {
        return this.requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }
}
