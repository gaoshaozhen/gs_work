package com.gs.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gs.sdk.web.auth.AuthAccessIntecetorHandle;
import com.gs.sdk.web.auth.AuthIntercetorHandle;

@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {
//	springboot 默认对静态资源进行过滤，不必重新设置
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/js/**").addResourceLocations(
//				"classpath:/static/js/");
//		registry.addResourceHandler("/css/**").addResourceLocations(
//				"classpath:/static/css/");
//		registry.addResourceHandler("/image/**").addResourceLocations(
//				"classpath:/static/image/");
//	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthIntercetorHandle()).addPathPatterns(
				"/**"); // 请求进行拦截,进行session验证，没有session就创建一个session
		
		
		AuthAccessIntecetorHandle access = new AuthAccessIntecetorHandle();
		access.setLoginUrl("/store/login");
		List<String> paths = new ArrayList<>();
		paths.add("/store/kapcha");
		paths.add("/error");
		access.setAllowPaths(paths);
		
		registry.addInterceptor(access).addPathPatterns(
				"/**"); // 请求进行拦截
	}
}
