package com.gs.sdk.web.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gs.common.utils.LogMaker;

public class AuthAccessIntecetorHandle extends HandlerInterceptorAdapter {
	private Logger log = LogMaker.make();
	private List<String> allowIps = new ArrayList<>();
	private List<String> allowPaths = new ArrayList<>();
	private String loginUrl = null;

	public void setAllowIps(List<String> allowIps) {
		this.allowIps = allowIps;
	}

	public void setAllowPaths(List<String> allowPaths) {
		this.allowPaths.addAll(allowPaths);
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
		allowPaths.add(loginUrl);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String ip = request.getRemoteAddr();
		for (String i : allowIps) {
			if (Objects.equals(i, ip)) {
				return true;
			}
		}
		String path = request.getRequestURI();
		log.debug("path:{}", path);
		for (String p : allowPaths) {
			if (Objects.equals(path, p)) {
				return true;
			}
		}
		boolean d = isAjax(request);
		log.debug("ajax 方式  {}", d);
		// 不在线
		if (!AuthAccessUtil.isInline()) {
			if (isAjax(request)) {
				response.sendError(401, "request is denied by server");
				return false;
			} else if (loginUrl != null) {				
				response.sendRedirect(loginUrl);
			}
			return false;
		}
		return true;
	}

	public static boolean isAjax(HttpServletRequest request) {
		
		return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest"
				.equals(request.getHeader("X-Requested-With").toString()));
	}
}
