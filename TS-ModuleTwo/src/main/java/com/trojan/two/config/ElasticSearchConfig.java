package com.trojan.two.config;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ES配置类,给容器中注入一个RestHighLevelClient
 */
@Configuration
public class ElasticSearchConfig {

    @Value("${elasticsearch.hostname}")
    private String hostName;
    @Value("${elasticsearch.port}")
    private int port;

    public static final RequestOptions COMMON_OPTIONS;

    /**
     * 统一设置请求项
     */
    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        COMMON_OPTIONS = builder.build();
    }

    /**
     * 获取ES客户端
     */
    @Bean
    public RestHighLevelClient getClient() {
        RestHighLevelClient client= new RestHighLevelClient(
                RestClient.builder(new HttpHost(hostName, port, "https"))
        );
        Header[] myheaders =  {
                           new BasicHeader("Authorization","Basic YWJkaV9hZG1pbjpBRkVEb3ZNclRSeGdjcUpjRW5GREJPcUxIYUdLVHRkOXM5d0Uxd3NpVnI5TVZDenc=")
                         };
        return client;
    }
}
