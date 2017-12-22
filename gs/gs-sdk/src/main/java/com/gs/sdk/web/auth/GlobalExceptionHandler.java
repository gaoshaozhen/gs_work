package com.gs.sdk.web.auth;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.gs.common.utils.JsonUtil;
import com.gs.common.utils.LogMaker;
import com.gs.common.utils.WebUtil;
import com.gs.sdk.BaseResult;
import com.gs.sdk.ServiceException;

public class GlobalExceptionHandler implements HandlerExceptionResolver {
	private Logger log = LogMaker.make();
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {		
		 try {
	            if (isJsonResponse(request, handler)) {
	                //这里通用的做法应该是根据当前MVC配置的解析器来构建返回结果，这里我们默认成为了JSON
	                response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
	                response.getWriter().write(handle(ex));
	                return new ModelAndView();
	            }
	        }
	        catch (Exception e) {
	            log.error("统一处理异常失败：", e);

	            return null;// 不处理
	        }
	        return handle(ex, "error");// 全局错误页面
	}
    protected boolean isJsonResponse(HttpServletRequest request, Object handler) {
        //1、明确要求接受JSON格式
        if (WebUtil.isJsonRequest(request)) {
            return true;
        }
        
        //2、指定的请求原反馈格式为JSON
        if (handler != null) {
            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                //方法上 ResponseBody 标记
                if (handlerMethod.hasMethodAnnotation(ResponseBody.class)) {
                    return true;
                }
                //类上 ResponseBody 标记
                if (AnnotatedElementUtils.hasAnnotation(handlerMethod.getBeanType(), ResponseBody.class)) {
                    return true;
                }
            }
        }
        
        return false;
    }
	 protected String handle(Exception ex) {
	        return JsonUtil.toJson(getErrorDescription(ex));
	}
	private String getMessage(ServiceException ex) {
        // 如果是直接包装底层异常的message，则也返回默认异常提示,该说明不准确。经反复测试，直接包装底层异常也可以，但一开始几次不行，不明白原因
        Throwable cause = ex.getCause();
        if (cause != null 
                && !(cause instanceof ServiceException) 
                && ex.getMessage().equals(cause.getMessage())) {

            return "系统异常。";
        }
        return StringUtils.defaultIfEmpty(ex.getMessage(), "系统异常。");
    }
	
	 protected BaseResult<?> getErrorDescription(Exception ex) {
	        if (ex instanceof ServiceException) {
	            ServiceException se = (ServiceException) ex;
	            Integer errorCode = se.getErrorCode();
	            if (errorCode != null) {
//	                try {
//	                    int code = Integer.valueOf(errorCode);
//	                    return BaseResult.fail(code, getMessage(se));
//	                }
//	                catch (Exception ignore) {}
	                // errorCode 为字符串类型，不能丢，拼到message中去
	                return BaseResult.fail(errorCode,
	                                       new StringBuilder().append('[')
	                                                          .append(se.getErrorCode())
	                                                          .append(']')
	                                                          .append(getMessage(se))
	                                                          .toString());
	            }
	            // 没有写errorCode
	            return BaseResult.fail(getMessage(se));
	        }

	        //不是ServiceException，统一写入默认异常提示
	        return BaseResult.fail("系统异常。");
	    }
	 
	 protected ModelAndView handle(Exception ex, String defaultErrorView) {
	        String view = defaultErrorView;
	       
	        Map<String, Object> model = new HashMap<String, Object>(2);

	        model.put("error_cause", ex);
	        
	        BaseResult<?> error = getErrorDescription(ex);
	        model.put("error_code", error.getCode());
	        model.put("error_message", error.getMessage());
	        
	        return new ModelAndView(view, model);
	    }
}
