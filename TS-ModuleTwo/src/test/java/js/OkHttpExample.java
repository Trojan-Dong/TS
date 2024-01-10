package js;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

@Slf4j
public class OkHttpExample {
    
    private static final OkHttpClient client = new OkHttpClient();
    
    public static void main(String[] args) {
        //        // 发送GET请求
        //        String url = "https://api.example.com/api/data";
        //        try {
        //            String response = doGetRequest(url);
        //            System.out.println("GET Response: " + response);
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }
        
        // 发送POST请求（JSON参数）
        String postUrl = "https://jiaowu3.nsmc.edu.cn/jsxsd/xk/LoginToXk";
        String jsonBody = "{\"name\":\"John\", \"age\":30}";
        try {
            String postResponse = doPostRequest(postUrl, jsonBody);
            System.out.println("POST Response: " + postResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //        // 发送POST请求（Form表单）
        //        String formUrl = "https://api.example.com/api/submit-form";
        //        FormBody.Builder formBuilder = new FormBody.Builder()
        //                .add("username", "john")
        //                .add("password", "password123");
        //        try {
        //            String formResponse = doPostRequest(formUrl, formBuilder.build());
        //            System.out.println("Form POST Response: " + formResponse);
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }
    }
    
    public static String doGetRequest(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    
    public static String doPostRequest(String url, String jsonBody) throws IOException {
        log.info(url);
        log.info(jsonBody);
        RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"), jsonBody);
        
        Request request = new Request.Builder().url(url).post(body)
//                .header("Content-Type", "application/x-www-form-urlencoded")
                //                .header("Cookie", "JSESSIONID=D17DC66A405A8CB24149C7B8FAA36447; Hm_lvt_85eed71563592d9ecd21eb3c69a7aae2=1704778797,1704872329; SERVERID=121; JSESSIONID=B0A2689A645FE3B0761B881E22B1CD15; Hm_lpvt_85eed71563592d9ecd21eb3c69a7aae2=1704876454")
                .build();
        
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    
    public static String doPostRequest(String url, RequestBody requestBody) throws IOException {
        Request request = new Request.Builder().url(url).post(requestBody).build();
        
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
