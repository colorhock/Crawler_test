package com.stockmarket;

import java.io.IOException;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.helper.HttpHelper;
import com.stockmarket.entity.SharePo;
import com.wteamfly.superW.core.dao.SuperDaoProxy;
import com.wteamfly.superW.core.entity.po.UserPo;

/**
 * 
 * @author DZY
 *
 */
public class GetStockList {
	private static final int page = 166;
	private static final String USER_AGENT = "Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) "
			+ "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Mobile Safari/537.36";
	private static final String COOKIE = "_gat=1; nsfw-click-load=off; gif-click-load=on;"
			+ " _ga=GA1.2.1861846600.1423061484";
	private static final String CHARSET_UTF8 = "UTF-8";

	public static void main(String[] args) throws IOException {
		RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD)
				.setConnectionRequestTimeout(6000).setConnectTimeout(6000).build();
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
		String url = "http://www.yz21.org/stock/info/";
		String urlToReq = "";
		SuperDaoProxy dao = SuperDaoProxy.getInstance();
		UserPo currentUser = new UserPo();
		currentUser.setUserId(1L);
		try {
			for (int i = 1; i <= page; i++) {
				String strParams = "/stocklist_" + i + ".html";
				if (i == 1) {
					strParams = "";
				}
				urlToReq = url + strParams;
				// sleep 100 millis
				Thread.sleep(100);
				String htmlForStock = HttpHelper.getHtmlStrByUrl(urlToReq, httpClient, COOKIE, USER_AGENT, CHARSET_UTF8);
				if (!htmlForStock.contains("您要找的页面可能被移走了")) {
					System.out.println("存在" + urlToReq);
					Document doc = Jsoup.parse(htmlForStock);
					Elements trs = doc.getElementById("All_stocks1_DataGrid1").select("tr");
					SharePo sharePo = new SharePo();
					for (int j = 1; j < trs.size(); j++) {
						Elements tds = trs.get(j).select("td");
						sharePo = new SharePo();
						Element link = tds.get(1).select("a").first();
						String relHref = link.attr("href");
						String strtype = "";
						if (relHref.contains("sh")) {
							strtype = "sh";
						} else if (relHref.contains("sz")) {
							strtype = "sz";
						}
						
						sharePo.setSharecode(strtype + tds.get(1).text());
						if(dao.queryCount(sharePo) == 0){
							sharePo.setSharename(tds.get(2).text());
							sharePo.setCompanyname(tds.get(3).text());
							sharePo.setCompanyshort(tds.get(4).text());
							dao.addEntity(sharePo, currentUser);
							System.out.println("sharecode:" + sharePo.getSharecode());
						}

					}

				} else {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpClient.close();
		}

	}
}
