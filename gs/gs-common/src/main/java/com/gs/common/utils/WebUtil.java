package com.gs.common.utils;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	public static boolean isJsonRequest(HttpServletRequest request){
		return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest"
				.equals(request.getHeader("X-Requested-With").toString()));
	}
}
