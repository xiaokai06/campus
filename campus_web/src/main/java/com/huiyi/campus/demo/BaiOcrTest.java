package com.huiyi.campus.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-05-18 18:53
 * @Version V1.0
 */
public class BaiOcrTest {
    //设置APPID/AK/SK
    public static final String APP_ID = "24152715";
    public static final String API_KEY = "gIo6Gbsqg2hCfmg9OhPMjB2v";
    public static final String SECRET_KEY = "2f3wV33H91db4bx990EYLgzzYeESBxvg";

    public static void main(String[] args) throws Exception {
        /**
         * 重要提示代码中所需工具类
         * FileUtil,Base64Util,HttpUtil,GsonUtils请从
         * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
         * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
         * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
         * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
         * 下载
         */
        // iocr识别apiUrl
        String recogniseUrl = "https://aip.baidubce.com/rest/2.0/solution/v1/iocr/recognise";


        String filePath = "/Users/yukaili/huiyi/phy/2.jpg";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            // 请求模板参数
            String recogniseParams = "templateSign=f7775382d24ebd1f79693c1184006005&image=" + URLEncoder.encode(imgStr, "UTF-8");
            // 请求分类器参数
            String classifierParams = "classifierId=f7775382d24ebd1f79693c1184006005&image=" + URLEncoder.encode(imgStr, "UTF-8");

            String accessToken = getAuth(API_KEY, SECRET_KEY);

            // 请求模板识别
            String result = HttpUtil.post(recogniseUrl, accessToken, recogniseParams);
            // 请求分类器识别
            // String result = HttpUtil.post(recogniseUrl, accessToken, classifierParams);
            JSONObject jsonObject = new JSONObject(result);
            JSONObject json = jsonObject.getJSONObject("data");
            JSONArray jsonArray = json.getJSONArray("ret");
            List<OcrDto> list = JSON.parseObject(jsonArray.toString(), new TypeReference<List<OcrDto>>() {
            });
            list.forEach(str -> {
                if(str.getWordName().contains("list")){
//                    System.out.println(str.getWordName());
//                    System.out.println(str.getWordName().split("#").toString());
                    System.out.println(str.getWord());
                }

            });
//            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     *
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     */
    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }
}
