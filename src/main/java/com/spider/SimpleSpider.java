package com.spider;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.helper.HttpHelper;

public class SimpleSpider {
	private static final int page = 10000;
	private static final String USER_AGENT = "Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Mobile Safari/537.36";
	private static final String COOKIE = "_gat=1; nsfw-click-load=off; gif-click-load=on; _ga=GA1.2.1861846600.1423061484";
	private static final String CHARSET_GB2312 = "GB2312";
	public static void main(String[] args) {
		RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD)
				.setConnectionRequestTimeout(6000).setConnectTimeout(6000).build();
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
		int index = 1509;
		int endindex = 2000;
		
//		String url = "http://m.62fan.com/shaonv/2017/0310/";
		String url = "http://m.yaoqmhw.com/snmh/";
		String strFolderName = "";
		for (int j = index; j < endindex; j++) {
			try {
				String urlToReq = url + index + ".html";
				String html = HttpHelper.getHtmlStrByUrl(urlToReq, httpClient, COOKIE, USER_AGENT, CHARSET_GB2312);
				if (!html.contains("找不到文件或目录")) {
					Document doc = Jsoup.parse(html);
					String titleForhtml = doc.title();
					strFolderName = String.valueOf(index) + titleForhtml.substring(0, titleForhtml.indexOf("_"));
					System.out.println(index+"："+titleForhtml);
					for (int i = 1; i <= page; i++) {
						String strImageId = index + "_" + i + ".html";
						if (i == 1) {
							strImageId = (index) + ".html";
						}
						urlToReq = url + strImageId;
						Thread.sleep(100);
						String htmlForImage = HttpHelper.getHtmlStrByUrl(urlToReq, httpClient, COOKIE, USER_AGENT, CHARSET_GB2312);
						if (!htmlForImage.contains("找不到文件或目录")) {
							System.out.println("存在文件地址" + urlToReq);
							new Thread(new JianDanHtmlParser(htmlForImage, 1, strFolderName, strImageId)).start();
						} else {
							System.out.println("找不到文件或目录" + urlToReq);
							break;
						}

					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			index++;
		}

	}
}
