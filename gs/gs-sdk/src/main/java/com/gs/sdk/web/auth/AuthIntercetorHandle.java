package com.gs.sdk.web.auth;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.gs.common.RedisDictionary;
import com.gs.common.utils.LogMaker;
import com.gs.sdk.redis.JedisUtil;

public class AuthIntercetorHandle extends HandlerInterceptorAdapter {
	private Logger  log = LogMaker.make();
	
	private boolean sessionAuto = false;

	public boolean isSessionAuto() {
		return sessionAuto;
	}

	public void setSessionAuto(boolean sessionAuto) {
		this.sessionAuto = sessionAuto;
	}

	/**
	 * 检查coolie是否有token，有就作为sessionid从redis中查询session，
	 * 存在就取回session数据创建session绑定到当前线程
	 * 无token或没有查询到session就新创建token添加cookie，创建新session绑定到当线程上，
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		SampleSessionContext session = new SampleSessionContext();
		Cookie cookie = WebUtils.getCookie(request, "token");
		String id = cookie != null ? cookie.getValue() : null;
		if(id == null){//cokkie中获取失败则尝试从header中获取
			id = request.getHeader("auth-session-id");
		}
		if (id != null) {
			session.setId(id);
			Map<String, String> r = JedisUtil.getClient().hgetAll(
					RedisDictionary.SESSION_AREA + id);
			if (r != null) {
				session.setAttributes(r);
				String temp = r.get(SampleSessionContext._INLINE); 
				if( temp != null && "true".equals(temp)){
					session.login();
				}
			}			
		}
		if (!session.isInline()) {
			id = createToken(request, response);
			session.setId(id);
			Map<String, String> m = session.getAttributesForStr();
			m.put("id", id);
			JedisUtil.getClient().hmset(RedisDictionary.SESSION_AREA + id, m);
		}
		AuthAccessUtil.set(session);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if(ex != null){
			return;
		}
		SessionContext session = AuthAccessUtil.getSession();
		if (session != null && session.getId() != null) {
			Map<String, String> m = session.getAttributes();
			m.put("id", session.getId());
			JedisUtil.getClient().hmset(
					RedisDictionary.SESSION_AREA + session.getId(), m);
			JedisUtil.getClient().expire(
					RedisDictionary.SESSION_AREA + session.getId(), 30 * 60);
			log.debug("session id:{}", session.getId());
		}
		
	}

	// id取request中sessionid，自己生成的话在未登录时每次请求都会创建，大量未登录请求会生成大量session，redis会撑爆
	private String createToken(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getSession().getId();
		Cookie newCookie = new Cookie("token", id);
		newCookie.setHttpOnly(true);
		newCookie.setPath("/");
		response.addCookie(newCookie);
		log.debug("created session :{}", id);
		return id;
	}
}
