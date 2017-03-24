package com.cc.sys.core.util;

import javax.servlet.http.HttpServletRequest;

public class ViewUtil {
	public static String getRequestPath(HttpServletRequest request) {
		String path = request.getContextPath();

		if (path.equals("/")) {
			path = "";
		}
		String basePath = "";
		if (request.getServerPort() == 80)
			basePath = request.getScheme() + "://" + request.getServerName() + path + "/";
		else {
			basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
					+ "/";
		}
		return basePath;
	}
}
