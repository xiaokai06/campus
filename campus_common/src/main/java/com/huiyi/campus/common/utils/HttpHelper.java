package com.huiyi.campus.common.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

@Slf4j
public class HttpHelper {

    public static String postMethod(String url, String jsonString) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(60000).setConnectionRequestTimeout(60000)
                .setSocketTimeout(60000).build();
        post.setConfig(requestConfig);
        String response = null;
        try {
            StringEntity s = new StringEntity(jsonString, "UTF-8");   // 中文乱码在此解决
            s.setContentType("application/json");
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                response = IOUtils.toString(entity.getContent(), StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            client.close();
        }
        return response;
    }

    /**
     * put方式请求
     *
     * @return
     */
    public static String sendPutWithJson(String url, String json) {
        String returnValue = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            //第一步：创建HttpClient对象
            httpClient = HttpClients.createDefault();

            //第二步：创建httpPost对象
            HttpPut httpPost = new HttpPut(url);

            //第三步：给httpPost设置JSON格式的参数
            StringEntity requestEntity = new StringEntity(json, "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("X-Requested-With", "XMLHttpRequest");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(requestEntity);

            //第四步：发送HttpPost请求，获取返回值
            returnValue = String.valueOf(httpClient.execute(httpPost));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //第五步：处理返回值
        return returnValue;
    }

    /**
     * POST请求（xml格式）
     */
    public static String xmlPost(String urlStr, String xmlInfo) {
        try {
            URL url = new URL(urlStr);
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Cache-Control", "no-cache");
            con.setRequestProperty("Content-Type", "text/xml");

            OutputStreamWriter out = new OutputStreamWriter(con
                    .getOutputStream());
            log.info("XML请求地址为：" + "\n" + urlStr);
            log.info("XML请求数据为：" + "\n" + xmlInfo);
            out.write(new String(xmlInfo.getBytes(StandardCharsets.UTF_8)));
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con
                    .getInputStream(), StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
