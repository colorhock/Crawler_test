package com.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class StreamUtils {
	public static void writeToFile(InputStream in, String path) {
		File file = new File(path);
		try {
			FileOutputStream out = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int len;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 
	 */
	public static String convertStreamToString(InputStream in, String charset) {
		StringBuilder sb = new StringBuilder();
		try {
			
			InputStreamReader isr = new InputStreamReader(in, charset);
			BufferedReader reader = new BufferedReader(isr);
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "/n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();

	}
}
