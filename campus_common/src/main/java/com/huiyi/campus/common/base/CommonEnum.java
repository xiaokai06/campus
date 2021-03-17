package com.huiyi.campus.common.base;

/**
 * @author pancm
 * @Title: CommonEnum
 * @Description: 公用描述枚举类
 * @Version:1.0.0
 * @date 2018年6月25日
 */
public enum CommonEnum implements BaseErrorInfoInterface {
    // 数据操作错误定义
    SUCCESS("200", "成功!"),
    SIGNATURE_NOT_MATCH("401", "请求的数字签名不匹配!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    LOGIN_TIMEOUT("504", "登录超时，请重新登录!"),
    NO_DELETE("506", "当前项目使用中，无法删除!"),
    INVALID_TOKEN("507", "token无效，无法登录"),
    REPETITION("508", "该用户代号已存在，请重新输入!"),
    LOGIN_OFFLINE("509", "无法登录，该用户账号登录设备已上限!");

    /**
     * 错误码
     */
    private final String resultCode;

    /**
     * 错误描述
     */
    private final String resultMsg;

    CommonEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }

}
