package com.gs.sdk.web.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * session类 _inline 标记是否在线，不允许覆盖
 * 
 * @author shaozhen
 *
 */
public class SampleSessionContext implements SessionContext {

	private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
	public final static String _INLINE = "_inline";
	private String id = null;
	@Override
	public void setAttribute(String key, String value) {
		if (_INLINE.equals(key)) {
			throw new IllegalArgumentException("inline is not allow as a key!");
		}
		map.put(key, value);
	}

	@Override
	public String getAttribute(String key) {
		// TODO Auto-generated method stub
		return map.get(key);
	}

	@Override
	public boolean isInline() {

		return Boolean.TRUE.equals(map.get(_INLINE)) || "true".equals(map.get(_INLINE));
	}

	@Override
	public void login() {
		map.put(_INLINE, "true");
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}

	@Override
	public Map<String, String> getAttributes() {
		Map<String, String> newMap = new HashMap<>();
		
		for(Map.Entry<String, String> entry : map.entrySet()){
			newMap.put(entry.getKey(), entry.getValue());
		}
		return newMap;
	}
	
	public Map<String, String> getAttributesForStr() {
		Map<String, String> newMap = new HashMap<>();
		
		for(Map.Entry<String, String> entry : map.entrySet()){
			newMap.put(entry.getKey(), String.valueOf(entry.getValue()));
		}
		return newMap;
	}

	@Override
	public void setAttributes(Map<String, String> value) {
		map.putAll(value);
		
	}
	
}
