package com.huiyi.campus.netty.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 在线聊天记录vo
 * @date: 2021-03-22 15:01
 * @Version V1.0
 */
@Getter
@Setter
public class OnlineChatMsg implements Serializable {

    private static final long serialVersionUID = 3611169682695799175L;
    @ApiModelProperty("发送人ID")
    private String senderId;
    @ApiModelProperty("接收人ID")
    private String receiverId;
    @ApiModelProperty("聊天内容")
    private String msg;
    @ApiModelProperty("消息的签收")
    private String msgId;


}
