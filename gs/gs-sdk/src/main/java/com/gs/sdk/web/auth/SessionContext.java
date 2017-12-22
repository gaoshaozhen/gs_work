package com.gs.sdk.web.auth;

import java.util.Map;

public interface SessionContext {
	void setAttribute(String key, String value);
	String getAttribute(String key);
	boolean isInline();
	
	void login();
	String getId();
	Map<String, String> getAttributes();
	void setAttributes(Map<String, String> value);
}
