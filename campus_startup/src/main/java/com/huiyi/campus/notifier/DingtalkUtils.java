package com.huiyi.campus.notifier;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 钉钉消息通知工具类
 * @date: 2021-04-03 18:15
 * @Version V1.0
 */
@Slf4j
public class DingtalkUtils {

    public static void main(String[] args) {
        pushInfoToDingding("测试消息通知", "1b70b1148521f22b938dfdbab3f027a8fb2f1085d4fa85b2fd59ab76a9852b1c");
    }

    /**
     * 提交消息到钉钉
     *
     * @param textMsg
     * @param dingURL
     */
    public static void pushInfoToDingding(String textMsg, String dingURL) {

        HashMap<String, Object> resultMap = new HashMap<>(8);
        resultMap.put("msgtype", "text");

        HashMap<String, String> textItems = new HashMap<>(8);
        textItems.put("content", textMsg);
        resultMap.put("text", textItems);

        HashMap<String, Object> atItems = new HashMap<>(8);
        atItems.put("atMobiles", null);
        atItems.put("isAtAll", false);
        resultMap.put("at", atItems);

      /*  StringBuilder textMsgBuilder = new StringBuilder(
                "{ \"msgtype\":\"markdown\",\"markdown\":{\"title\":\"告警通知\",\"text\":\"");
        textMsgBuilder.append(textMsg);
        textMsgBuilder.append("\"},\"at\":{\"atMobiles\":[],\"isAtAll\":false}}");
        System.out.println(textMsgBuilder);*/
        dingURL = "https://oapi.dingtalk.com/robot/send?access_token=" + dingURL;
        try {
            HttpClient httpClient = HttpClients.createDefault();
            StringEntity stringEntity = new StringEntity(JSON.toJSONString(resultMap), "utf-8");

            HttpPost httpPost = createConnectivity(dingURL);
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
                log.info("执行结果：{}", result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建http连接
     *
     * @param restUrl
     * @return
     */
    static HttpPost createConnectivity(String restUrl) {
        HttpPost post = new HttpPost(restUrl);
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Accept", "application/json");
        post.setHeader("X-Stream", "true");
        return post;
    }
}
