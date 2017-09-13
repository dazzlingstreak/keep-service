package com.learning.keep.web.api.test;

import io.swagger.annotations.Api;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by huangdawei on 2017/9/12.
 */
@Path("/test/httpClient")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Api(tags = "测试http请求模块")
public class TestHttpClientApi {

    private static Logger logger = LogManager.getLogger(TestHttpClientApi.class);

    @GET
    @Path("/get")
    public void testGet() {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = "http://www.baidu.hello.com";
        HttpGet httpGet = new HttpGet(url);

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setSocketTimeout(1000 * 5) //这定义了Socket读数据的超时时间,即从服务器获取响应数据需要等待的时间,这里设置为5s
                .setConnectTimeout(1000 * 2) //这定义了通过网络与服务器建立连接的超时时间
                .build();
        httpGet.setConfig(requestConfig);

        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            logger.info("response is {}",response);
            logger.info("entity is {}",entity);
            logger.info("result is {}", EntityUtils.toString(entity));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
