package com.gs.sdk.redis;

public class JedisUtil {
	
	public static JedisTemplate getClient(){
		return Holder.tem;
	}
	
	private static class Holder{
		public static JedisTemplate tem = new DefaultJedisTemplate();
	}
}
