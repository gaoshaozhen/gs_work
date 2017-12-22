package com.gs.sdk.web.wrapper;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.gs.sdk.BaseResult;

public class ResponseBodyWrapHandler implements HandlerMethodReturnValueHandler {
	private final HandlerMethodReturnValueHandler delegate;

	public ResponseBodyWrapHandler(HandlerMethodReturnValueHandler delegate) {
		this.delegate = delegate;
	}

	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		return delegate.supportsReturnType(returnType);
	}

	@Override
	public void handleReturnValue(Object returnValue,
			MethodParameter returnType, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest) throws Exception {
		if (returnValue == null || !(returnValue instanceof BaseResult)) {
			BaseResult<Object> result = BaseResult.success(null, returnValue);
			result.setWrapper(1);
			returnValue = result;
		}
		delegate.handleReturnValue(returnValue, returnType, mavContainer,
				webRequest);
	}
}
