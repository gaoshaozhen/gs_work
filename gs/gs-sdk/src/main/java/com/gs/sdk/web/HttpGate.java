package com.gs.sdk.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;









import com.fasterxml.jackson.core.type.TypeReference;
import com.gs.common.Configurations;
import com.gs.common.utils.BeanUtil;
import com.gs.common.utils.JsonUtil;
import com.gs.common.utils.LogMaker;
import com.gs.sdk.BaseResult;
import com.gs.sdk.ServiceException;
import com.gs.sdk.web.auth.AuthAccessUtil;

public class HttpGate {

	private static Logger log = LogMaker.make();
	
	public static <T> T get(String url, Class<T> c){
		return JsonUtil.toObject(get(url), c);
	}
	
	public static <T> T get(String url, TypeReference<T> target){
		return JsonUtil.toObject(get(url), target);
	}
	
	public static <T> T post(String url, Object param, Class<T> c){
		return JsonUtil.toObject(post(url, param), c);
	}
	
	@SuppressWarnings("unchecked")
	public static  BaseResult<Object> post(String url){
		return  JsonUtil.toObject(getContent(Configurations.getProperty("gate.host") + url, "post",
				null), BaseResult.class);
	}
	
	public static <T> T post(String url, Class<T> c){
		return JsonUtil.toObject(getContent(Configurations.getProperty("gate.host") + url, "post",
				null), c);
	}
	
	public static <T> T post(String url, Object param, TypeReference<T> target){
		return JsonUtil.toObject(getContent(Configurations.getProperty("gate.host") + url, "post",
				param), target);
	}

	public static String get(String url) {
		return getContent(Configurations.getProperty("gate.host") + url, "get",
				null);
	}

	public static String post(String url, Object params) {		
		return getContent(Configurations.getProperty("gate.host") + url,
				"post", params);
	}

	/**
	 * 
	 * @param url
	 * @param type
	 * @param params map或者javabean
	 * @param headers
	 * @return
	 */
	public static String getContent(String url, String type, Object params, Header... headers) {
		String result = null;
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse resp = null;
		try {
			if ("get".equalsIgnoreCase(type)) {
				HttpGet httpGet = new HttpGet(url);
				if(AuthAccessUtil.isInline()){
					httpGet.addHeader("auth-session-id", AuthAccessUtil.getSession().getId());
				}
				if(headers != null){
					for(Header header : headers){
						httpGet.addHeader(header);
					}
				}
				resp = client.execute(httpGet);
			} else if ("post".equalsIgnoreCase(type)) {
				HttpPost httpPost = new HttpPost(url);
				if(AuthAccessUtil.isInline()){
					httpPost.addHeader("auth-session-id", AuthAccessUtil.getSession().getId());
				}
				
				if(headers != null){
					for(Header header : headers){
						httpPost.addHeader(header);
					}
				}
				if (params != null) {
					
					HttpEntity en = new UrlEncodedFormEntity(parseNameValuePair(params), "UTF-8"); 
					httpPost.setEntity(en);	
				}
				resp = client.execute(httpPost);
			} else {
				throw new RuntimeException("httpGate not surport" + type);
			}
			StatusLine status = resp.getStatusLine();
			if (status.getStatusCode() == 200) {
				result = EntityUtils.toString(resp.getEntity());
			} else {
				log.warn("response {} is not 200, {}", status.getStatusCode(),resp.getAllHeaders());
				throw new ServiceException("系统异常");
			}
		} catch (ParseException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if (resp != null) {
					resp.close();
				}
				client.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<NameValuePair> parseNameValuePair(Object params) {
		List<NameValuePair> list = new ArrayList<>();
		if (params instanceof Map) {
			Map<Object, Object> map = (Map<Object, Object>) params;
			for (Map.Entry<Object, Object> entry : map.entrySet()) {
				list.add(new BasicNameValuePair(entry.getKey().toString(),
						entry.getValue().toString()));
			}
		} else {
			Map<String, Object> map = BeanUtil.beanToMap(params);
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				list.add(new BasicNameValuePair(entry.getKey(), entry.getValue() != null ? entry.getValue().toString() : null));
			}
		}
		return list;
	}
	
	
	
	public static void main (String[]args){
		
		A a = new A();
		a.setX("assd");
		a.setTest("sd");
		Map<String, Object> p = new HashMap<>();
		p.put("custName", "s敌方dsd");
//		Map<String, Object> map = BeanUtil.beanToMap(p);
//		System.out.println(map);
		
		post("/sys/cust/delete/1");
	}
}

