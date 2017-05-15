package com.spider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class JianDanImageCreator {
	private static int count = 0;
	private String imageUrl;
	private int page;
	private String strid;
	private String strFolderName;
	private String basePath = "E:/jiandan/image/1";

	public JianDanImageCreator(String imageUrl, int page, String strFolderName, String strid) {
		this.imageUrl = imageUrl;
		this.page = page;
		this.strFolderName = strFolderName;
		this.strid = strid;
		this.basePath = "E:/jiandan/image/" + strFolderName;
	}

	public void downloadImg() {
		File dir = new File(basePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String imageName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
		try {
			File file = new File(basePath + "/" + strid + "--" + imageName);
			OutputStream os = new FileOutputStream(file);
			URL url = new URL(imageUrl);
			InputStream is = url.openStream();
			byte[] buffer = new byte[3068];
			int len;
			while ((len = is.read(buffer)) > 0) {
				os.write(buffer, 0, len); 
			}
			is.close();
			os.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}