package com.gs.sdk;

public class ServiceException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer errorCode;
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public ServiceException(String message){
		super(message);
	}
	public ServiceException(String message, Throwable e){
		super(message, e);
	} 
}
