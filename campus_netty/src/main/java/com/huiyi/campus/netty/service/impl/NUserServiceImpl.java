package com.huiyi.campus.netty.service.impl;

import com.huiyi.campus.common.enums.MsgSignFlagEnum;
import com.huiyi.campus.common.utils.idworker.Sid;
import com.huiyi.campus.dao.entity.zx.ZxChatMsgEntity;
import com.huiyi.campus.dao.pojo.web.zx.NUserServiceDao;
import com.huiyi.campus.netty.pojo.vo.OnlineChatMsg;
import com.huiyi.campus.netty.service.NUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 用户聊天业务服务
 * @date: 2021-03-23 10:00
 * @Version V1.0
 */
@Service
public class NUserServiceImpl implements NUserService {
    @Autowired
    NUserServiceDao nUserServiceDao;
    @Autowired
    Sid sid;



    /**
     * 批量更新消息签收
     * @param msgIdList
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateMsgSigned(List<String> msgIdList) {
        nUserServiceDao.batchUpdateMsgSigned(msgIdList);
    }

    /**
     * 保存聊天消息到数据库
     * @param onlineChatMsg
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public String saveMsg(OnlineChatMsg onlineChatMsg) {
        ZxChatMsgEntity zxChatMsgEntity = new ZxChatMsgEntity();
        String msgId = sid.nextShort();
        zxChatMsgEntity.setId(msgId);
        zxChatMsgEntity.setAcceptUserId(onlineChatMsg.getReceiverId());
        zxChatMsgEntity.setSendUserId(onlineChatMsg.getSenderId());
        zxChatMsgEntity.setCreateTime(new Date());
        zxChatMsgEntity.setSignFlag(MsgSignFlagEnum.unsign.type);
        zxChatMsgEntity.setMsg(onlineChatMsg.getMsg());
        nUserServiceDao.insertMsg(zxChatMsgEntity);
        return msgId;
    }
}
