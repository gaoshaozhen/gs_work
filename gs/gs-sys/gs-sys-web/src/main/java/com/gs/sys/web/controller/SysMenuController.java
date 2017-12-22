package com.gs.sys.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.sys.service.SysMenuService;

@Controller
@RequestMapping("/sys/menu")
public class SysMenuController {
	
	@Autowired
	SysMenuService sysMenuService;
	
	@RequestMapping("/all")
	@ResponseBody
	public Object getAllMenu(){
		return sysMenuService.getAllMenu();
	}
}
