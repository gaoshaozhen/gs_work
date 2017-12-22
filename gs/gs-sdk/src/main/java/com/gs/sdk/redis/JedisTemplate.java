package com.gs.sdk.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface JedisTemplate {
	public String set(String key, String value);
	public String get(String key);
	public Long del(String ...key);
	
	public String hmset(String key, Map<String, String> value);
	public List<String> hmget(String key, String ...field);
	public Long hlen(String key);
	
	public Boolean exists(String key);
	
	public Set<String> hkeys(String key);
	public Map<String, String> hgetAll(String key);
	public Long expire(String key, int seconds);
}
