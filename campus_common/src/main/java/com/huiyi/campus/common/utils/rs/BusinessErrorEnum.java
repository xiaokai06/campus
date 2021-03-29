package com.huiyi.campus.common.utils.rs;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 业务异常枚举
 * @date: 2021-03-29 14:45
 * @Version V1.0
 */
public enum BusinessErrorEnum {

    INVOICE_PHONE_EMAIL_NULL("手机号和邮箱不能同时为空！"),
    INVOICE_PHONE_NULL("手机号不能为空！"),
    INVOICE_PHONE_ERROR("手机号格式错误！"),
    HEALTH_RECORD_INFO_NULL("请求数据不能");


    private String description;

    private BusinessErrorEnum(String description) {
        this.description = description;
    }

    public BusinessErrorEnum format(String str) {
        StringBuilder sb = new StringBuilder(this.getDescription());
        this.description = sb.replace(this.getDescription().indexOf("[ ") + 2, this.getDescription().indexOf(" ]"), str).toString();
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
