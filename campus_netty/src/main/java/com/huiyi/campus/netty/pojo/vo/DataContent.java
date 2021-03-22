package com.huiyi.campus.netty.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-03-22 14:50
 * @Version V1.0
 */
@Getter
@Setter
public class DataContent implements Serializable {
    private static final long serialVersionUID = 8021381444738260454L;

    @ApiModelProperty("动作类型")
    private Integer action;
    @ApiModelProperty("用户的聊天内容entity")
    private OnlineChatMsg onlineChatMsg;
    @ApiModelProperty("扩展字段")
    private String extand;

}
