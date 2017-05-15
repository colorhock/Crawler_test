package com.stockmarket;

import java.util.List;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.Util.DateUtil;
import com.helper.HttpHelper;
import com.stockmarket.entity.SharePo;
import com.stockmarket.entity.SharereprotPo;
import com.wteamfly.superW.core.dao.SuperDaoProxy;
import com.wteamfly.superW.core.entity.po.UserPo;

public class GetShareData {
	private static final String USER_AGENT = "Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Mobile Safari/537.36";
	private static final String COOKIE = "_gat=1; nsfw-click-load=off; gif-click-load=on; _ga=GA1.2.1861846600.1423061484";
	private static final String CHARSET_UTF8 = "gbk";

	public static void main(String[] args) {
		RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD)
				.setConnectionRequestTimeout(6000).setConnectTimeout(6000).build();
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
		String url = "http://hq.sinajs.cn/list=";

		SuperDaoProxy dao = SuperDaoProxy.getInstance();
		UserPo currentUser = new UserPo();
		currentUser.setUserId(1L);
		SharePo sPoForQuery = new SharePo();
		String htmlForImage = null;
		String urlForData = null;
		try {
			List<SharePo> list = (List<SharePo>) dao.queryList(sPoForQuery);
			for (SharePo sharePo : list) {
				urlForData = url + sharePo.getSharecode();
				htmlForImage = HttpHelper.getHtmlStrByUrl(urlForData, httpClient, COOKIE, USER_AGENT, CHARSET_UTF8);
				htmlForImage = htmlForImage.substring(htmlForImage.indexOf("\"") + 1, htmlForImage.lastIndexOf("\""));
				if (!htmlForImage.equals("")) {
					String[] strForStockArray = htmlForImage.split(",");
					List<SharereprotPo> listForReport = null;
					if (strForStockArray.length > 0) {
						SharereprotPo sharereprotPo = new SharereprotPo();
						sharereprotPo.setShareid(sharePo.getShareid());
						sharereprotPo.setSharename(strForStockArray[0]);
						sharereprotPo.setThetime(strForStockArray[31]);
						listForReport = (List<SharereprotPo>) dao.queryList(sharereprotPo);
						sharereprotPo.setTodaybeginprice(Double.parseDouble(strForStockArray[1]));
						sharereprotPo.setYesterdaycloseprice(Double.parseDouble(strForStockArray[2]));
						sharereprotPo.setNowprice(Double.parseDouble(strForStockArray[3]));
						sharereprotPo.setHighprice(Double.parseDouble(strForStockArray[4]));
						sharereprotPo.setLowprice(Double.parseDouble(strForStockArray[5]));
						sharereprotPo.setBuyprice(Double.parseDouble(strForStockArray[6]));
						sharereprotPo.setSaleprice(Double.parseDouble(strForStockArray[7]));
						sharereprotPo.setDealnum(Integer.parseInt(strForStockArray[8]));
						sharereprotPo.setDealmoney(Double.parseDouble(strForStockArray[9]));
						sharereprotPo.setBuyone1(Double.parseDouble(strForStockArray[10]));
						sharereprotPo.setBuyone2(Double.parseDouble(strForStockArray[11]));
						sharereprotPo.setBuytwo1(Double.parseDouble(strForStockArray[12]));
						sharereprotPo.setBuytwo2(Double.parseDouble(strForStockArray[13]));
						sharereprotPo.setBuythree1(Double.parseDouble(strForStockArray[14]));
						sharereprotPo.setBuythree2(Double.parseDouble(strForStockArray[15]));
						sharereprotPo.setBuyfour1(Double.parseDouble(strForStockArray[16]));
						sharereprotPo.setBuyfour2(Double.parseDouble(strForStockArray[16]));
						sharereprotPo.setBuyfive1(Double.parseDouble(strForStockArray[18]));
						sharereprotPo.setBuyfive2(Double.parseDouble(strForStockArray[19]));
						sharereprotPo.setThedate(DateUtil.StringToDate(strForStockArray[30], DateUtil.YYYY_MM_DD));
						sharereprotPo.setTodaybeginprice(Double.parseDouble(strForStockArray[22]));
						if (listForReport.size() > 0) {
							sharereprotPo.setSharereprotid(listForReport.get(0).getSharereprotid());
							dao.editEntity(sharereprotPo, currentUser);
						} else {
							dao.addEntity(sharereprotPo, currentUser);
						}
					}
				}
				Thread.sleep(100);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("htmlForImage:" + htmlForImage);
			System.out.println("urlForData:" + urlForData);
		}

	}
}
