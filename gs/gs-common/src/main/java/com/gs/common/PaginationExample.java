package com.gs.common;

import java.util.HashMap;
import java.util.Map;

public class PaginationExample {
	private String orderByClause;

	private boolean distinct;

	private Integer limit;

	private Integer offset;

	private Map<String, Object> formData = null;

	public PaginationExample() {
		this.formData = new HashMap<String, Object>();
	}

	public PaginationExample(Map<String, Object> properties) {
		this.formData = properties;
	}

	public Map<String, Object> getFormData() {
		return formData;
	}

	public Object get(String key) {
		return formData.get(key);
	}

	public Object put(String key, Object value) {
		return formData.put(key, value);
	}

	public Object remove(String key) {
		return formData.remove(key);
	}

	public boolean containsKey(String key) {
		return formData.containsKey(key);
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String toString() {
		return new StringBuilder(formData.toString()).append("limit=")
				.append(limit).append(", offset=").append(offset)
				.append("orderByclause=").append(orderByClause).toString();
	}
}
