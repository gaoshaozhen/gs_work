package com.gs.sdk.web.auth;

import java.lang.reflect.InvocationTargetException;

public class AuthAccessUtil {
	private static ThreadLocal<SessionContext> local = new ThreadLocal<>();
	
	public static void set(SessionContext session){
		local.set(session);
	}
	
	public static void remove(){
		local.remove();
	}
	
	public static SessionContext getSession(){
		return local.get();
	}
	
	public static boolean isInline(){
		SessionContext session = getSession();
		
		return session != null ? session.isInline() : false;
	}
	
	public static void login(){
		SampleSessionContext session = (SampleSessionContext) getSession();
		session.login();
	}
	
	public static <T> T getAttribute(String key, Class<T> cl) {
		SessionContext session = getSession();
		if (session != null) {
			String value = session.getAttribute(key);
			try {
				return cl.getConstructor(String.class).newInstance(value);
			} catch (NoSuchMethodException | SecurityException
					| InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(new Long(null));

	}

}
