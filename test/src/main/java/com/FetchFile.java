package com;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.vteba.utils.charstr.Char;

public class FetchFile {

	public static void main(String[] args) {
		// http://www.69txt.com/Novel/104/13425.html13615
		// http://www.69txt.com/Novel/104/13425.html
		// /NovelChapter/3/104/13546.txt
		// /NovelChapter/3/104/13547.txt
		for (int i = 425; i <= 615; i++) {
		//for (int i = 425; i <= 425; i++) {
			fetch(i);
		}

	}

	public static String fetchTitle(int i) {
		byte[] bytes = null;
		HttpGet httpGet = null;
		try {
			HttpHost host = new HttpHost("www.69txt.com", 80, "http");
			URI uri = null;
			try {
				URIBuilder uriBuilder = new URIBuilder();
				// 设置请求的路径
				uriBuilder.setPath("/Novel/104/13" + i + ".html");
				uri = uriBuilder.build();
			} catch (URISyntaxException e1) {

			}
			httpGet = new HttpGet(uri);
			// 创建客户端
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			// 发起调用
			CloseableHttpResponse httpResponse = httpClient.execute(host,
					httpGet);
			int status = httpResponse.getStatusLine().getStatusCode();
			if (status == 200) {// 结果正常
				bytes = EntityUtils.toByteArray(httpResponse.getEntity());
				// if (LOGGER.isInfoEnabled()) {
				// LOGGER.info("调用接口返回200正常，url=[{}]，字节size=[{}]",
				// httpPost.getURI().toString(), bytes.length);
				// }
			} else {// 结果异常
				// LOGGER.error("请求的urlPath错误[{}]，响应码是[{}]",
				// httpPost.getURI().toString(), status);
			}
			httpResponse.close();
			httpClient.close();
			if (bytes != null) {
				String str = new String(bytes, Char.UTF8);
				int titleStartIndex = str.indexOf("<strong>") + 8;
				int titleEndIndex = str.indexOf("</strong>");
				String title = str.substring(titleStartIndex, titleEndIndex).replace("*", "和");
				title = title.replace("&nbsp;", " ");
				return title;
			} else {
				System.err.println("没有获取到数据。");
			}
		} catch (ClientProtocolException e) {
			// LOGGER.error("[{}]请求，客户端协议错误。", httpPost.getURI().toString(),
			// e.getMessage());
		} catch (IOException e) {
			// LOGGER.error("[{}]请求IO错误。", httpPost.getURI().toString(), e);
		}
		return Integer.toString(i);
	}
	
	public static void fetch(int i) {
		byte[] bytes = null;
		HttpGet httpGet = null;
		try {
			HttpHost host = new HttpHost("www.69txt.com", 80, "http");
			URI uri = null;
			try {
				URIBuilder uriBuilder = new URIBuilder();
				// 设置请求的路径
				uriBuilder.setPath("/NovelChapter/3/104/13" + i + ".txt");
				uri = uriBuilder.build();
			} catch (URISyntaxException e1) {

			}
			httpGet = new HttpGet(uri);
			// 创建客户端
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			// 发起调用
			CloseableHttpResponse httpResponse = httpClient.execute(host,
					httpGet);
			int status = httpResponse.getStatusLine().getStatusCode();
			if (status == 200) {// 结果正常
				bytes = EntityUtils.toByteArray(httpResponse.getEntity());
				// if (LOGGER.isInfoEnabled()) {
				// LOGGER.info("调用接口返回200正常，url=[{}]，字节size=[{}]",
				// httpPost.getURI().toString(), bytes.length);
				// }
			} else {// 结果异常
				// LOGGER.error("请求的urlPath错误[{}]，响应码是[{}]",
				// httpPost.getURI().toString(), status);
			}
			httpResponse.close();
			httpClient.close();
			if (bytes != null) {
				String str = new String(bytes, Char.UTF8);
				str = str.replace("&nbsp;", "").replace("<br />", "");
				
				String title = fetchTitle(i);
				
				str = title + "\n" + str;
				
				//System.out.println(str);
				File file = new File("D:\\work\\东吴基金\\推送环境工具\\ppyx\\" + (i - 424) + title + ".txt");
				FileWriterWithEncoding writer = new FileWriterWithEncoding(file, Char.UTF8);
				writer.write(str);
				writer.flush();
				writer.close();
			} else {
				System.err.println("没有获取到数据。");
			}
		} catch (ClientProtocolException e) {
			// LOGGER.error("[{}]请求，客户端协议错误。", httpPost.getURI().toString(),
			// e.getMessage());
		} catch (IOException e) {
			// LOGGER.error("[{}]请求IO错误。", httpPost.getURI().toString(), e);
		}
	}
}
