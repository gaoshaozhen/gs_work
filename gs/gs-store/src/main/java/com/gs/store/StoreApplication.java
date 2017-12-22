package com.gs.store;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.gs.sdk.web.auth.GlobalExceptionHandler;
import com.gs.sdk.web.wrapper.ResponseBodyWrapFactoryBean;

@SpringBootApplication
public class StoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	@Bean
	public ResponseBodyWrapFactoryBean getResponseBodyWrap() {
		return new ResponseBodyWrapFactoryBean();
	}

	@Bean
	public Producer defaultKaptcha(ConfigurableEnvironment environment) {
		Properties p = new Properties();
		p.put("kaptcha.border", "no");
		p.put("kaptcha.textproducer.char.string", "abcde2345678kfenmnpwx");
		p.put("kaptcha.border.color", "105,179,90");
		p.put("kaptcha.textproducer.font.color", "blue");
		p.put("kaptcha.image.width", "130");
		p.put("kaptcha.image.height", "46");
		p.put("kaptcha.textproducer.font.size", "45");
		p.put("kaptcha.session.key", "code");
		p.put("kaptcha.textproducer.char.length", "4");
		p.put("kaptcha.textproducer.char.space", "3");
		p.put("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		defaultKaptcha.setConfig(new Config(p));
		return defaultKaptcha;
	}
	
	@Bean
	public GlobalExceptionHandler getHandle(){
		return new GlobalExceptionHandler();
		
	}
}
