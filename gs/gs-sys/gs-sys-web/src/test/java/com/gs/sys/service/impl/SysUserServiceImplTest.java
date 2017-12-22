package com.gs.sys.service.impl;


import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gs.common.utils.LogMaker;
import com.gs.sys.SysApplication;
import com.gs.sys.model.SysUser;
import com.gs.sys.service.SysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SysApplication.class) //指定启动类
@WebAppConfiguration
public class SysUserServiceImplTest {
	Logger log = LogMaker.make();
	
	@Autowired
	SysUserService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try{
			run();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void run(){
		log.warn("start");
		SysUser user = new SysUser();
		user.setUserCode("sd");
		user.setUserType(1);
		user.setCustId(1l);
		user.setPassword("sd");
		user.setRoleId(1l);
		user.setCreatedCode("sys");
		user.setCreatedDt(new Date());
		service.selectByPrimaryKey(1L);
	}

}
