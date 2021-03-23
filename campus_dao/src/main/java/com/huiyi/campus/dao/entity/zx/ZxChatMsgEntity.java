package com.huiyi.campus.dao.entity.zx;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Setter
@Getter
@TableName("zx_chat_msg")
public class ZxChatMsgEntity implements Serializable {
    private String id;

    private String sendUserId;

    private String acceptUserId;

    private String msg;

    private Integer signFlag;

    private Date createTime;

    private static final long serialVersionUID = 1L;

}