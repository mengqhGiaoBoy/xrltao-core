package com.xrltao.util;

import com.google.gson.Gson;
import com.xrltao.config.XrltaoType;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.message.ReusableMessage;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/8 21:58
 * @Description http请求工具类
 */
public class HttpClientUtil {

    public static final Gson GSON_BEAN = new Gson();

    /*
     * @author mengqh
     * @date 2020/1/11 13:41
     * @param [url]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @description 发送get请求
     */
    public static Map<String, Object> doGet(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 设置自定义配置
        RequestConfig config = RequestConfig.custom().setConnectTimeout(5000) // 设置连接超时
                .setConnectionRequestTimeout(6000) // 设置请求超时
                .setRedirectsEnabled(true).build();// 允许重定向

        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(config);

        try {
            // 发送请求
            CloseableHttpResponse response = httpClient.execute(httpGet);
            // 判断状态码
            if (response.getStatusLine().getStatusCode() == XrltaoType.HTTP_RESPONSE_STATUS_SUCCEED) {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                String entityStr = EntityUtils.toString(entity);
                Map<String, Object> map = GSON_BEAN.fromJson(entityStr, Map.class);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String doPost(String url, String data, int timeOut) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 设置自定义配置
        RequestConfig config = RequestConfig.custom().setConnectTimeout(5000) // 设置连接超时
                .setConnectionRequestTimeout(6000) // 设置请求超时
                .setRedirectsEnabled(true).build();// 允许重定向

        HttpPost httpPost = new HttpPost(url);
        // 设置消息头
        httpPost.addHeader("Content-Type", "text/html;UTF-8");
        httpPost.setConfig(config);
        if (data != null && data instanceof String){
            // 设置消息体
            StringEntity stringEntity = new StringEntity(data, "UTF-8");
            httpPost.setEntity(stringEntity);
        }

        try {
            // 发送请求相应
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == XrltaoType.HTTP_RESPONSE_STATUS_SUCCEED){
                String strEntity = EntityUtils.toString(httpResponse.getEntity());
                return strEntity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
