package com.gs.sys.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gs.sys.model.SysUser;
import com.gs.sys.model.SysUserExample;
import com.gs.sys.service.SysUserService;

@Controller
@RequestMapping("/sys/user")
public class SysUserController {
	
	@Autowired
	SysUserService sysUserService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public Object list(){
		
		SysUser user = new SysUser();
		user.setUserCode("sd");
		
		return user;
	}
	
	@RequestMapping("/params")
	@ResponseBody
	public Object getSysUser(SysUser user){
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(user.getUserCode())){
			criteria.andUserCodeEqualTo(user.getUserCode());
		}
		return sysUserService.selectByExample(example);
	}
	
	@RequestMapping("/test")
	public Object test(){
		
		SysUser user = new SysUser();
		user.setUserCode("sd");
		System.out.println("*****************************");
		return new ModelAndView("test");
	}
}
