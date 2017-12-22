package com.gs.sdk.web.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

public class ResponseBodyWrapFactoryBean implements InitializingBean {
	@Autowired
	private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

	@Override
	public void afterPropertiesSet() throws Exception {
		List<HandlerMethodReturnValueHandler> returnValueHandlers = requestMappingHandlerAdapter
				.getReturnValueHandlers();
		List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(
				returnValueHandlers);
		decorateHandlers(handlers);
		requestMappingHandlerAdapter.setReturnValueHandlers(Collections
				.unmodifiableList(handlers));
	}

	private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers) {
		for (HandlerMethodReturnValueHandler handler : handlers) {
			if (handler instanceof RequestResponseBodyMethodProcessor) {
				// 用自己的ResponseBody包装类替换掉框架的，达到返回Result的效果
				int index = handlers.indexOf(handler);
				handlers.set(index, new ResponseBodyWrapHandler(handler));
				break;
			}
		}
	}
}
