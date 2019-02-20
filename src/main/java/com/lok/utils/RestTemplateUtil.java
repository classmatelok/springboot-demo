package com.lok.utils;
//
//import java.io.InputStream;
//import java.net.URI;
//import java.security.KeyStore;
//import java.util.List;
//
//import javax.net.ssl.HostnameVerifier;
//import javax.net.ssl.KeyManagerFactory;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSession;
//
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.ssl.SSLContexts;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
public class RestTemplateUtil {
//
//	public void getClient() throws Exception {
//		ClientHttpRequestFactory client = new SimpleClientHttpRequestFactory();
//		RestTemplate template = new RestTemplate(client);// or 自定义的HttpsClientRequestFactory
//
//		getRestTemplate();
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("app", "adminUI");
//		headers.set("usercode", "test8");
//		headers.set("token", "xxxx");
//
//		String httpBody = "{name:test}";
//		HttpEntity<String> httpEntity = new HttpEntity<String>(httpBody, headers);
//		URI uri = URI.create("http://127.0.0.1:9527/restTemplate/doHttpPost");
//
//		ResponseEntity<String> response = template.exchange(uri, HttpMethod.POST, httpEntity, String.class);
//		int codeValue = response.getStatusCodeValue();
//		if (codeValue == 200) {
//			System.out.println("send request success!");
//		}
//
//	}
//
//	private RestTemplate getRestTemplate() {
//		// 新建RestTemplate对象
//		RestTemplate restTemplate = new RestTemplate();
//		
//		// KeyStore用于存放证书，创建对象时 指定交换数字证书的加密标准
//		KeyStore keyStore = KeyStore.getInstance("JKS");
//		InputStream inputStream = xxx;// 通过keypath获取输入流
//		try {
//			// 添加证书
//			keyStore.load(inputStream, keyPassword.toCharArray());
//		} finally {
//			inputStream.close();
//		}
//
//		SSLContext sslContext = SSLContext.getInstance("SSL");
//		// 加载证书材料，构建sslContext
//		sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, keyPassword.toCharArray()).build();
//		// 构建SSL-Socket链接工厂
//		SSLConnectionSocketFactory ssLSocketFactory = new SSLConnectionSocketFactory(sslContext);
//		
//		// Spring提供HttpComponentsClientHttpRequestFactory指定使用HttpClient作为底层实现创建 HTTP请求
//		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory(
//				HttpClients.custom().setSSLSocketFactory(ssLSocketFactory).build());
//		// 设置传递数据超时时长
//		httpRequestFactory.setReadTimeout("");
//		// 设置建立连接超时时长
//		httpRequestFactory.setConnectTimeout("");
//		// 设置获取连接超时时长
//		httpRequestFactory.setConnectionRequestTimeout("");
//		restTemplate.setRequestFactory(httpRequestFactory);
//		return restTemplate;
//	}
}
