package com.assign.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClient {

	static CloseableHttpClient client = HttpClientBuilder.create().build();
	
	public static String GET(String api, String params){
		String url = CommonUtils.GITLAB_URL+CommonUtils.GITLAB_API_VERSION+api+params;
		HttpGet request = new HttpGet(url);
		try {
			HttpResponse response = client.execute(request);
			String jsonStr = EntityUtils.toString(response.getEntity());
			return jsonStr;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String POST(String api, List<NameValuePair> params){
		String url = CommonUtils.GITLAB_URL;
		if(api != null) {
			url = CommonUtils.GITLAB_URL+api;	
		}
		HttpPost post = new HttpPost(url);
		try {
			post.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = client.execute(post);
			String jsonStr = EntityUtils.toString(response.getEntity());
			return jsonStr;
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
