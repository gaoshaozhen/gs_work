package com.gs.sys.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.common.PaginationExample;
import com.gs.sdk.BaseResult;
import com.gs.sdk.web.auth.AuthAccessUtil;
import com.gs.sys.model.SysCust;
import com.gs.sys.service.SysCustService;

@Controller
@RequestMapping("/sys/cust")
public class SysCustController {

	@Autowired
	SysCustService sysCustService;

	@RequestMapping("/list")
	@ResponseBody
	public Object list(
			@RequestParam(required = false, value = "limit", defaultValue = "30") Integer limit,
			@RequestParam(required = false, value = "offset", defaultValue = "0") Integer offset,
			@RequestParam(required = false, value = "custName") String custName,
			@RequestParam(required = false, value = "custId") Long custId) {
		PaginationExample example = new PaginationExample();
		example.setLimit(limit);
		example.setOffset(offset);
		if (custId != null) {
			example.put("custId", custId);
		}
		if (StringUtils.isNotBlank(custName)) {
			example.put("custName", custName);
		}
		example.put("custPid", AuthAccessUtil.getAttribute("custId", Long.class));
		return sysCustService.list(example);
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Object add(SysCust cust){
		sysCustService.add(cust);
		return BaseResult.success();
	}
	
	@PostMapping("/update")
	@ResponseBody
	public Object update(SysCust cust){
		sysCustService.update(cust);
		return BaseResult.success();
	}
	
	@PostMapping("/delete/{id}")
	@ResponseBody
	public Object delete(@PathVariable("id") Long id){
		sysCustService.delete(id);
		return BaseResult.success();
	}
	
	@RequestMapping("/{custId}")
	@ResponseBody
	public SysCust get(@PathVariable("custId") Long custId){
		SysCust cust = sysCustService.selectByPrimaryKey(custId);
		return sysCustService.selectByPrimaryKey(custId);
	}
	
}
