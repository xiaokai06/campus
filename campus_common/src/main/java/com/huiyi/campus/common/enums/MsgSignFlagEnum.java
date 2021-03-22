package com.huiyi.campus.common.enums;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 消息签收状态 枚举
 * @date: 2021-03-22 15:08
 * @Version V1.0
 */
public enum MsgSignFlagEnum {
    unsign(0, "未签收"),
    signed(1, "已签收");

    public final Integer type;
    public final String content;

    MsgSignFlagEnum(Integer type, String content){
        this.type = type;
        this.content = content;
    }

    public Integer getType() {
        return type;
    }
}
