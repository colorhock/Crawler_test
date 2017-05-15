package com.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JianDanHtmlParser implements Runnable {
	private String html;
	private int page;
	private String strFolderName;
	private String strid;

	public JianDanHtmlParser(String html, int page,String strFolderName,String strid) {
		this.html = html;
		this.page = page;
		this.strFolderName = strFolderName;
		this.strid = strid;
	}

	public void run() {
		Document doc = Jsoup.parse(html);		
		Elements eles = doc.getElementById("imgString").select("img");	 
		String imageUrl = eles.get(0).attr("abs:src").toString();
		JianDanImageCreator creator = new JianDanImageCreator(imageUrl, page,strFolderName, strid);
		creator.downloadImg();

	}
}


