package com.helper;

import java.io.InputStream;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import com.Util.StreamUtils;

/**
 * 
 * @author DZY
 *
 */
public class HttpHelper {

	public static String getHtmlStrByUrl(String url, CloseableHttpClient httpClient, String COOKIE, String USER_AGENT, String charset) {
		HttpGet httpGetForFName = new HttpGet(url);
		httpGetForFName.addHeader("User-Agent", USER_AGENT);
		httpGetForFName.addHeader("Cookie", COOKIE);
		CloseableHttpResponse response;
		String html = "";
		try {
			response = httpClient.execute(httpGetForFName);			
			InputStream in = response.getEntity().getContent();
			html = StreamUtils.convertStreamToString(in, charset);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			httpGetForFName.releaseConnection();
		}
		return html;
	}

}
