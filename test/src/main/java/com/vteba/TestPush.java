package com.vteba;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Log4jConfigurer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.vteba.utils.charstr.Char;
import com.vteba.utils.json.FastJsonUtils;
import com.vteba.web.action.JsonBean;


public class TestPush {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestPush.class);
    
    private static final HttpHost WRITE_HOST;
    
//    private static SSLConnectionSocketFactory factory;
    private static HttpPost httpPost;
    private static HttpPost httpPost2;

    static {
        //WRITE_HOST = new HttpHost("192.168.2.239", 8443, "https");
    	WRITE_HOST = new HttpHost("172.20.204.35", 8081, "http");
        // 这些可以事先生成
//        TrustStrategy trustStrategy = new DefaultTrustFactory();
//        SSLContext sslContext = null;
//        try {
//            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//            sslContext = new SSLContextBuilder()
//            .useSSL()
//            .loadTrustMaterial(keyStore, trustStrategy)
//            .build();
//        } catch (Exception e) {
//            LOGGER.error("构建SSLContext错误。", e.getMessage());
//        }
//        factory = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//        
        RequestConfig config = RequestConfig.custom().setSocketTimeout(900000).setConnectTimeout(9000).build();
        httpPost = new HttpPost("/message/rs/msgs/push/mq");
        httpPost.setConfig(config);
        httpPost2 = new HttpPost("/encrypt/cipher/decode");
        httpPost2.setConfig(config);
        
        
    }
    
    public static void initLogger() {
        try {
            Log4jConfigurer.initLogging("classpath:log4j.xml");
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("没有找到log4j的日志配置文件。", e);
        }
    }
    
    /**
     * @param args
     * @throws IOException 
     */
	public static void main(String[] args) throws IOException {
        
        initLogger();
        
        LOGGER.info("开始测试：：：：：：");
        
//        JsonBean jsonBean = new JsonBean();
        Map<String, String> params = new HashMap<>();
        params.put("title", "这是标题");
        params.put("content", "这是发送的内容");
        params.put("receivers", "huatai_departid_userid");
        params.put("msgtype", "M");
        
//        byte[] jsonBytes = FastJsonUtils.toJsonBytes(params);
//        
//        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(jsonBytes, ContentType.APPLICATION_JSON);
//        httpPost.setEntity(byteArrayEntity);
        
        httpPost = buildHttpPost(params, "/message/rs/msgs/push/mq");
        
        
        
//        RequestConfig config = RequestConfig.custom().setSocketTimeout(900000).setConnectTimeout(9000).build();
//        httpPost.setConfig(config);
        
        byte[] resultBytes = resolve(httpPost, 1);
        if (resultBytes != null) {
        	String str = new String(resultBytes, Char.UTF8);
        	LOGGER.info(str);
        	Map<String, String> result = FastJsonUtils.fromJson(resultBytes, new TypeReference<Map<String, String>>(){});
        	LOGGER.info("返回的结果：：：：：：" + result);
        	String aa = result.get("data");
        	System.out.println(aa);
        	
        	Object object = JSON.parse(resultBytes);
        	System.out.println(object);
        }
        
        //test();
        
    }

	/**
     * 根据请求参数和请求url地址，构建http post请求。
     * @param params 请求参数
     * @param urlPath 请求url地址
     * @return HttpPost实例
     */
    private static HttpPost buildHttpPost(final Map<String, String> params, final String urlPath) {
        // 构建请求uri
        URI uri = null;
        try {
            URIBuilder uriBuilder = new URIBuilder();
            // 设置参数
            for (Entry<String, String> entry : params.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue());
            }
            // 设置请求的路径
            uriBuilder.setPath(urlPath);
            uri = uriBuilder.build();
        } catch (URISyntaxException e1) {
            LOGGER.error("HttpClient创建URI错误。可能传递的参数错误。", e1.getMessage());
            return null;
        }
        
        // 设置post请求
        HttpPost httpPost = new HttpPost(uri);
        // 设置post请求体
//        List<NameValuePair> list = URLEncodedUtils.parse(uri, "UTF-8");
//        try {
//            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
//            httpPost.setEntity(urlEncodedFormEntity);
//        } catch (UnsupportedEncodingException e) {
//            LOGGER.error("设置http请求体参数错误，不支持的编码。", e.getMessage());
//        }
        RequestConfig config = RequestConfig.custom().setSocketTimeout(6000).setConnectTimeout(6000).build();
        httpPost.setConfig(config);
        return httpPost;
    }
	
	public static void test() {
        LOGGER.info("开始测试：：：：：：：：");
//        HttpPost httpPost2 = new HttpPost("/encrypt/cipher/decode");
        
        JsonBean jsonBean2 = new JsonBean();
        
        LOGGER.info("返回数据=[{}]", FastJsonUtils.toJson(jsonBean2));
        byte[] jsonBytes2 = FastJsonUtils.toJsonBytes(jsonBean2);
        
        ByteArrayEntity byteArrayEntity2 = new ByteArrayEntity(jsonBytes2, ContentType.APPLICATION_JSON);
        httpPost2.setEntity(byteArrayEntity2);
        
        RequestConfig config2 = RequestConfig.custom().setSocketTimeout(900000).setConnectTimeout(9000).build();
        httpPost2.setConfig(config2);
        
        byte[] resultBytes2 = resolve(httpPost2, 1);
        if (resultBytes2 != null) {
        	JsonBean result2 = FastJsonUtils.fromJson(resultBytes2, JsonBean.class);
        	LOGGER.info("解密后返回的结果：：：：：[" + result2 + "]");
        }
    }
    
    /**
     * 发起http请求，返回字节数组
     * 
     * @param httpPost
     *            HttpPost
     * @param type
     *            1写，2读
     * @return byte[]
     */
    private static byte[] resolve(final HttpPost httpPost, int type) {
        byte[] bytes = null;
        try {
            HttpHost host = null;
            if (type == 1) {
                host = WRITE_HOST;
            }
            
            // 创建客户端
            CloseableHttpClient httpClient = HttpClientBuilder.create()
                    //.setSSLSocketFactory(factory)
                    .build();
            
            // 发起调用
            CloseableHttpResponse httpResponse = httpClient.execute(host, httpPost);
            int status = httpResponse.getStatusLine().getStatusCode();
            if (status == 200) {// 结果正常
                bytes = EntityUtils.toByteArray(httpResponse.getEntity());
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("调用接口返回200正常，url=[{}]，字节size=[{}]", httpPost.getURI().toString(), bytes.length);
                }
            } else {// 结果异常
                LOGGER.error("请求的urlPath错误[{}]，响应码是[{}]", httpPost.getURI().toString(), status);
            }
            httpResponse.close();
            httpClient.close();
        } catch (ClientProtocolException e) {
            LOGGER.error("[{}]请求，客户端协议错误。", httpPost.getURI().toString(), e);
        } catch (IOException e) {
            LOGGER.error("[{}]请求IO错误。", httpPost.getURI().toString(), e);
        }
        return bytes;
    }
    
}

