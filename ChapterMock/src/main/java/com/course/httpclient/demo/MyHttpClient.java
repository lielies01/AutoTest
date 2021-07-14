package com.course.httpclient.demo;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {


    /**
     * 无参测试
     */
    @Test
    public void test1() {

        // 创建Http客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 客户端发送Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为：" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为：" + responseEntity.getContentLength());
                System.out.println("响应内容为：" + responseEntity);
                System.out.println("响应内容为：" + EntityUtils.toString(responseEntity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            try {
                if (httpClient != null) {
                    httpClient.close();
                }

                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}