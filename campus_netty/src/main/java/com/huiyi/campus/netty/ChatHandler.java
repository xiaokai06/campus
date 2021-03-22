package com.huiyi.campus.netty;

import com.alibaba.druid.support.json.JSONUtils;
import com.huiyi.campus.common.enums.MsgActionEnum;
import com.huiyi.campus.common.utils.JsonUtils;
import com.huiyi.campus.netty.pojo.vo.DataContent;
import com.huiyi.campus.netty.pojo.vo.OnlineChatMsg;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

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

        }else if (action.equals(MsgActionEnum.SIGNED.type)){
            //2.3、签收消息类型，针对具体的消息进行签收，修改数据库中对应消息的签收状态[已签收]

        }else if(action.equals(MsgActionEnum.KEEPALIVE.type)){
            //2.4、心跳类型的消息，

        }





        log.info("接收到客户端的数据：" + cliContent);
        users.writeAndFlush(
                new TextWebSocketFrame("[服务器在]" + LocalDateTime.now()
                        + "接受到消息, 消息为：" + cliContent));
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
        users.remove(ctx.channel());
        /**
         * 触发handlerRemoved，ChannelGroup会自动移除对应客户端的channel
         */
        log.info("客户端断开，channle对应的长id为：" + ctx.channel().id().asLongText());
        log.info("客户端断开，channle对应的短id为：" + ctx.channel().id().asShortText());
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
