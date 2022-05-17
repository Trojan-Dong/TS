package com.trojan.two.config;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

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
        RestHighLevelClient client = null;
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "rbJ-rq5LlXqHM4dmNj=0"));
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) {
                    return true;
                }
            }).build();
            SSLIOSessionStrategy sessionStrategy = new SSLIOSessionStrategy(sslContext, NoopHostnameVerifier.INSTANCE);
            Header[] myheaders = {
                    new BasicHeader("Authorization", "Basic YWJkaV9hZG1pbjpBRkVEb3ZNclRSeGdjcUpjRW5GREJPcUxIYUdLVHRkOXM5d0Uxd3NpVnI5TVZDenc=")
            };
            client = new RestHighLevelClient(
                    RestClient.builder(new HttpHost(hostName, port, "https")).setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
                        @Override
                        public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpAsyncClientBuilder) {
                            httpAsyncClientBuilder.disableAuthCaching();
                            httpAsyncClientBuilder.setSSLStrategy(sessionStrategy);
                            httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                            return httpAsyncClientBuilder;
                        }
                    })
            );
        } catch (Exception e) {

        }

        return client;
//        //创建ssl client
//public CloseableHttpClient sslClient() {
//        LOGGER.info("HttpClient init start ......");
//        CloseableHttpClient sslClient = null;
//        // 用户认证提供者
//        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY,
//                new UsernamePasswordCredentials(username, password));
//        try {
//            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
//                // 信任所有证书，本地证书
//                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//                    return true;
//                }
//            }).build();
//            HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
//            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
//            sslClient = HttpClients.custom().setSSLSocketFactory(sslsf).setDefaultCredentialsProvider(credentialsProvider).build();
//        } catch (Exception e) {
//            LOGGER.error("HttpClient create error!!", e);
//        }
//        if (sslClient != null) {
//            return sslClient;
//        }
//        return sslClient;
//    }
    }
}
