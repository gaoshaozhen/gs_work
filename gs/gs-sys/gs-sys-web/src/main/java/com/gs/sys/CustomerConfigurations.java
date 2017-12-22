package com.gs.sys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gs.sdk.web.auth.AuthAccessIntecetorHandle;
import com.gs.sdk.web.auth.AuthIntercetorHandle;

/**
 * 自定义配置
 * 
 * @author shaozhen
 *
 */
@Configuration
public class CustomerConfigurations extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthIntercetorHandle()).addPathPatterns(
				"/**"); // 请求进行拦截,进行session验证，没有session就创建一个session
		
		
		AuthAccessIntecetorHandle access = new AuthAccessIntecetorHandle();
		List<String> ips = new ArrayList<>();
		ips.add("127.0.0.1");
		ips.add("localhost");
		access.setAllowIps(ips);
		registry.addInterceptor(access).addPathPatterns(
				"/**"); // 请求进行拦截		
	}
}
