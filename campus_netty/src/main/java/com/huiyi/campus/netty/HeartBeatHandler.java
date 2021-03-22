package com.huiyi.campus.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 用于检测channel的心跳handler, 继承ChannelInboundHandlerAdapter，从而不需要实现channelRead0方法
 * @date: 2021-03-22 11:31
 * @Version V1.0
 */
@Slf4j
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    /**
     * 用户事件触发器
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                log.info("进入读空闲...");
            }else if (event.state() == IdleState.WRITER_IDLE){
                log.info("进入写空闲...");
            }else if (event.state() == IdleState.ALL_IDLE){
                log.info("channel关闭前，users的数量为：" + ChatHandler.users.size());
                Channel channelHandler = ctx.channel();
                channelHandler.close();
                log.info("channel关闭后，users的数量为：" + ChatHandler.users.size());
            }
        }
    }
}
