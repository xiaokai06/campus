package com.huiyi.campus.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 聊天服务器
 * @date: 2021-03-22 11:20
 * @Version V1.0
 */
@Slf4j
@Component
public class NWebSocketServer {



    private static class SingletionNettyServer {
        static final NWebSocketServer instance = new NWebSocketServer();
    }

    public static NWebSocketServer getInstance(){
        return SingletionNettyServer.instance;
    }

    private EventLoopGroup mainGroup;
    private EventLoopGroup subGroup;
    private ServerBootstrap server;
    private ChannelFuture future;

    /**
     * webSocket服务
     */
    public NWebSocketServer(){
        mainGroup = new NioEventLoopGroup();
        subGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(mainGroup, subGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new NWebSocketServerInitialzer());
    }

    /**
     * webScoket服务启动器
     */
    public void start() throws InterruptedException {
        this.future = server.bind(9091).sync();
      log.info("netty websocket server 启动完毕......");
    }


}
