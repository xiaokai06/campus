package com.huiyi.campus.netty;


import com.huiyi.campus.common.enums.MsgActionEnum;
import com.huiyi.campus.common.utils.JsonUtils;
import com.huiyi.campus.common.utils.SpringUtil;
import com.huiyi.campus.netty.pojo.vo.DataContent;
import com.huiyi.campus.netty.pojo.vo.OnlineChatMsg;


import com.huiyi.campus.netty.service.NUserService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 消息处理handler
 * @date: 2021-03-22 11:35
 * @Version V1.0
 */
@Slf4j
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    /**
     * 用于记录和管理所有客户端的channle
     */
    public static ChannelGroup users = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 消息通道读取
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        /**
         * 1、获取客户端传输的消息
         */
        String cliContent = msg.text();

        Channel currentChannel = ctx.channel();

        DataContent dataContent = JsonUtils.jsonToPojo(cliContent, DataContent.class);
        Integer action = dataContent.getAction();
        //2、判断消息类型，根据不同的类型来处理不同的业务
        if (action.equals(MsgActionEnum.CONNECT.type)){
            //2.1、当websocket 第一次open的时候，初始化Channel，把用户的Channel和userid关联起来
            String senderId = dataContent.getOnlineChatMsg().getSenderId();
            UserChannelRel.put(senderId, currentChannel);
        }else if(action.equals(MsgActionEnum.CHAT.type)){
            //2.2、聊天类型的消息，把聊天记录保存到数据库（注：需要进行加密后保存库内），同事标记消息的签收状态[未签收]
            OnlineChatMsg onlineChatMsg = dataContent.getOnlineChatMsg();
            String msgText = onlineChatMsg.getMsg();
            String receiverId = onlineChatMsg.getReceiverId();
            String senderId = onlineChatMsg.getSenderId();

            //保存消息到数据库，并且标记为未签收
            NUserService nUserService = (NUserService) SpringUtil.getBean("nUserServiceImpl");
            String msgId = nUserService.saveMsg(onlineChatMsg);
            onlineChatMsg.setMsgId(msgId);
            DataContent dataContentMsg = new DataContent();
            dataContentMsg.setOnlineChatMsg(onlineChatMsg);
            /**
             * 发送消息
             */
            // 从全局用户Channel关系中获取接受方的channel
            Channel receiverChannel = UserChannelRel.get(receiverId);
            if (receiverChannel == null) {
                // TODO channel为空代表用户离线，推送消息（JPush，个推，小米推送）
            } else {
                // 当receiverChannel不为空的时候，从ChannelGroup去查找对应的channel是否存在
                Channel findChannel = users.find(receiverChannel.id());
                if (findChannel != null) {
                    // 用户在线
                    receiverChannel.writeAndFlush(
                            new TextWebSocketFrame(
                                    JsonUtils.objectToJson(dataContentMsg)));
                } else {
                    // 用户离线 TODO 推送消息
                }
            }
        }else if (action.equals(MsgActionEnum.SIGNED.type)){
            //2.3、签收消息类型，针对具体的消息进行签收，修改数据库中对应消息的签收状态[已签收]
            NUserService nUserService = (NUserService) SpringUtil.getBean("nUserServiceImpl");
            String msgIdsStr = dataContent.getExtand();
            String msgIds[] = msgIdsStr.split(",");

            List<String> msgIdList = new ArrayList<>();
            for (String mid : msgIds){
                if (StringUtils.isNoneBlank(mid)){
                    msgIdList.add(mid);
                }
            }
            log.info(msgIdList.toString());
            if (msgIdList != null && !msgIdList.isEmpty() && msgIdList.size() >0){
                nUserService.updateMsgSigned(msgIdList);
            }
        }else if(action.equals(MsgActionEnum.KEEPALIVE.type)){
            //2.4、心跳类型的消息，
            log.info("收到来自channel为[" + currentChannel + "]的心跳包...");

        }
    }

    /**
     * 添加通道
     * 当客户端连接服务端之后（打开连接）
     * 获取客户端的channle，并且放到ChannelGroup中去进行管理
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        users.add(ctx.channel());
    }

    /**
     * 移除通道
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        String channelId = ctx.channel().id().asShortText();
        log.info(("客户端被移除，channelId为：" + channelId));
        users.remove(ctx.channel());
    }

    /**
     * 捕获异常关闭
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        /**
         * 发生异常之后关闭连接（关闭channel），随后从ChannelGroup移除
         */
        ctx.channel().close();
        users.remove(ctx.channel());
    }
}
