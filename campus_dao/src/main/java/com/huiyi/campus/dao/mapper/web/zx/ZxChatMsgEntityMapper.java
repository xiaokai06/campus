package com.huiyi.campus.dao.mapper.web.zx;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiyi.campus.dao.entity.zx.ZxChatMsgEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZxChatMsgEntityMapper extends BaseMapper<ZxChatMsgEntity> {
    int deleteByPrimaryKey(String id);

    int insert(ZxChatMsgEntity record);

    int insertSelective(ZxChatMsgEntity record);

    ZxChatMsgEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZxChatMsgEntity record);

    int updateByPrimaryKey(ZxChatMsgEntity record);

    /**
     * 批量更新消息签收
     * @param msgIdList
     */
    void batchUpdateMsgSigned(List<String> msgIdList);
}