package com.gs.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gs.sdk.web.wrapper.ResponseBodyWrapFactoryBean;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.gs.sys.**.mapper")
public class SysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysApplication.class, args);

	}
	
	@Bean
	public ResponseBodyWrapFactoryBean get(){
		return new ResponseBodyWrapFactoryBean();
	}

}
