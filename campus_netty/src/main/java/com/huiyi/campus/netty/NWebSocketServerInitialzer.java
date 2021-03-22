package com.huiyi.campus.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: Netty通讯服务初始化器
 * @date: 2021-03-22 11:25
 * @Version V1.0
 */
public class NWebSocketServerInitialzer extends ChannelInitializer<SocketChannel> {

    /**
     *
     * 通讯初始化器
     * @param socketChannel
     * @throws Exception
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        /**
         * 用于HTTP协议机制
         * 1、websocket 基于http协议，所以要有http编解码器
         * 2、对写大数据流的支持
         * 3、对httpMessage进行聚合，聚合成FullHttpRequest或FullHttpResponse
         * 4、几乎在netty中的编程，都会使用到此hanler
         */
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new ChunkedWriteHandler());
        pipeline.addLast(new HttpObjectAggregator(1024*64));

        /**
         * 增加心跳机制
         * 1、针对客户端，如果在1分钟时没有向服务端发送读写心跳(ALL)，则主动断开,如果是读空闲或者写空闲，不处理
         * 2、自定义的空闲状态检测
         */
        pipeline.addLast(new IdleStateHandler(8,10,12));
        pipeline.addLast(new HeartBeatHandler());

        /**
         * 增加httpWebsocket机制
         * 1、websocket 服务器处理的协议，用于指定给客户端连接访问的路由：/ws
         * 2、本handler会帮你处理一些繁重的复杂的事
         * 3、会帮你处理握手动作： handshaking（close, ping, pong） ping + pong = 心跳
         * 4、对于websocket来讲，都是以frames进行传输的，不同的数据类型对应的frames也不同
         */
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(new ChatHandler());
    }
}
