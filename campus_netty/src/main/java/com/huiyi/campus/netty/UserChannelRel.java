package com.huiyi.campus.netty;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 用户id和channel的关联关系处理
 * @date: 2021-03-22 11:45
 * @Version V1.0
 */
@Slf4j
public class UserChannelRel {
    private static HashMap<String, Channel> manager = new HashMap<>();

    public static void put(String senderId, Channel channel) {
        manager.put(senderId, channel);
    }

    public static Channel get(String senderId) {
        return manager.get(senderId);
    }

    public static void output() {
        for (HashMap.Entry<String, Channel> entry : manager.entrySet()) {
            log.info("UserId: " + entry.getKey()
                    + ", ChannelId: " + entry.getValue().id().asLongText());
        }
    }
}
