package com.huiyi.campus.dao.pojo.web.zx;

import com.huiyi.campus.dao.entity.zx.ZxChatMsgEntity;
import com.huiyi.campus.dao.mapper.web.zx.ZxChatMsgEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-03-23 15:39
 * @Version V1.0
 */
@Repository
public class NUserServiceDao {

    @Autowired
    ZxChatMsgEntityMapper zxChatMsgEntityMapper;

    /**
     * 批量更新消息签收
     * @param msgIdList
     */
    public void batchUpdateMsgSigned(List<String> msgIdList) {
          zxChatMsgEntityMapper.batchUpdateMsgSigned(msgIdList);
    }

    /**
     * 保存聊天消息到数据库
     * @param zxChatMsgEntity
     */
    public void insertMsg(ZxChatMsgEntity zxChatMsgEntity) {
        zxChatMsgEntityMapper.insert(zxChatMsgEntity);
    }
}
