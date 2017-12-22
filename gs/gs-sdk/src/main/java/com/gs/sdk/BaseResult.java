package com.gs.sdk;

public class BaseResult<T> {
	private Integer code = null;
	private String message = null;
	private T data = null;
	private Integer wrapper;

	// 无参构造函数用以先构建对象再设置参数，不能删除
	public BaseResult() {
	}

	public BaseResult(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public BaseResult(StatusEnum status, String message, T data) {
		this.code = status.getValue();
		this.message = message;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static BaseResult<Object> success() {
		return new BaseResult<Object>(StatusEnum.SUCCESS, null, null);
	}

	public static BaseResult<Object> success(String message) {
		return new BaseResult<Object>(StatusEnum.SUCCESS, message, null);
	}

	public static BaseResult<Object> success(String message, Object data) {
		return new BaseResult<Object>(StatusEnum.SUCCESS, null, data);
	}

	public static BaseResult<Object> fail() {
		return new BaseResult<Object>(StatusEnum.FAIL, null, null);
	}

	public static BaseResult<Object> fail(String message) {
		return new BaseResult<Object>(StatusEnum.FAIL, message, null);
	}
	public static BaseResult<Object> fail(int code, String message) {
		return new BaseResult<Object>(code, message, null);
	}

	public static BaseResult<Object> fail(String message, Object data) {
		return new BaseResult<Object>(StatusEnum.FAIL, null, data);
	}

	public Integer getWrapper() {
		return wrapper;
	}

	public void setWrapper(Integer wrapper) {
		this.wrapper = wrapper;
	}
}
