package com.cc.sys.core.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.util.StringUtils;
/**
 * ClassName:HttpClientUtils <br/>
 * Description: HTTP工具类. <br/>
 * Date: 2017年3月23日 下午17:18:03 <br/>
 *
 * @author ctt
 * @version 1.0
 * @since 1.7
 */
public class HttpClientUtils {

	/**
	 * 创建参数
	 * @param paramMap
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private static byte[] buildParamter(Map<String, String> paramMap, 
		String encoding) throws UnsupportedEncodingException {
		StringBuilder params = new StringBuilder("");
		
		if (paramMap != null && !paramMap.isEmpty()) {
			for (Map.Entry<String, String> entry : paramMap.entrySet()) {
				if (StringUtils.hasText(params)) {
					params.append("&");
				}
				
				String val = URLEncoder.encode(entry.getValue(), encoding);
				params.append(entry.getKey()).append("=").append(val);
			}
		}
		
		return params.toString().getBytes();
	}

	/**
	 * http get请求
	 * @param urlPath
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public static String doGet(String urlPath, Map<String, String> paramMap) 
			throws IOException {
		return doGet(urlPath, paramMap, "UTF-8");
	}

	/**
	 * http get请求
	 * @param urlPath
	 * @param paramMap
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static String doGet(String urlPath, Map<String, String> paramMap, 
		String charset) throws IOException {
		HttpURLConnection conn = null;
		ByteArrayOutputStream bs = null;
		InputStream is = null;

		byte[] byteArr = new byte[1024];
		try {
			
			if (paramMap != null && !paramMap.isEmpty()) {
				if (urlPath.indexOf('?') == -1) {
					urlPath += "?" + buildParamter(paramMap, charset).toString();
				} else {
					urlPath += "&" + buildParamter(paramMap, charset).toString();
				}
			}
			
			conn = (HttpURLConnection) new URL(urlPath).openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setRequestMethod("GET");
			conn.connect();

			is = conn.getInputStream();
			bs = new ByteArrayOutputStream();
			
			int len = 0;
			while ((len = is.read(byteArr)) != -1) {
				bs.write(byteArr, 0, len);
			}
			
			return new String(bs.toByteArray(), charset);
		} catch (IOException e) {
			throw e;
		} finally {
			if (bs != null) {
				bs.close();
			}
			
			if (is != null) {
				is.close();
			}

			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	/**
	 * HTTP POST请求
	 * @param urlPath
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public static String doPost(String urlPath, Map<String, String> paramMap)
			throws IOException {
		return doPost(urlPath, paramMap, "UTF-8");
	}

	/**
	 * HTTP POST请求
	 * @param urlPath
	 * @param paramMap
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static String doPost(String urlPath, Map<String, String> paramMap, 
			String charset) throws IOException {
		return doPost(urlPath, "application/x-www-form-urlencoded", 
				buildParamter(paramMap, charset), charset);
	}

	/**
	 * HTTP POST请求
	 * @param path
	 * @param contentType
	 * @param body
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static String doPost(String path, String contentType, byte[] body,
			String charset) throws IOException {

		HttpURLConnection conn = null;
		OutputStream os = null;
		ByteArrayOutputStream bs = null;
		InputStream is = null;

		byte[] byteArr = new byte[1024];
		try {
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", contentType);
			conn.connect();

			os = conn.getOutputStream();
			if (os != null) {
				os.write(body);
				os.flush();
			}

			bs = new ByteArrayOutputStream();
			is = conn.getInputStream();
			
			int len = 0;
			while ((len = is.read(byteArr)) != -1) {
				bs.write(byteArr, 0, len);
			}
			
			return new String(bs.toByteArray(), charset);
		} catch (IOException e) {
			throw e;
		} finally {
			if (bs != null) {
				bs.close();
			}
			
			if (is != null) {
				is.close();
			}

			if (os != null) {
				os.close();
			}

			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	/**
	 * HTTP post请求
	 * @param urlPath
	 * @param contentType
	 * @param body
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static String doPost(String urlPath, String contentType, String body, 
			String charset) throws IOException {
		return doPost(urlPath, contentType, body.getBytes(charset), charset);
	}
}
