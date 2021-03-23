package com.huiyi.campus.netty.service;

import com.huiyi.campus.netty.pojo.vo.OnlineChatMsg;

import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-03-23 10:00
 * @Version V1.0
 */
public interface NUserService {

    /**
     * 批量签收消息
     * @param msgIdList
     */
    void updateMsgSigned(List<String> msgIdList);

    /**
     * 保存聊天消息到数据库
     * @param onlineChatMsg
     * @return
     */
    String saveMsg(OnlineChatMsg onlineChatMsg);
}
