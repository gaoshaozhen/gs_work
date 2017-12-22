package com.gs.store.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gs.sdk.BaseResult;
import com.gs.sdk.web.HttpGate;
import com.gs.sys.model.SysCust;

@Controller
@RequestMapping("/store/sys/cust")
public class SysCustController {
	
	@GetMapping()
	public Object go(){
		ModelAndView mv = new ModelAndView("sys/cust");		
		return mv;
	}
	
	@GetMapping("/add")
	public Object add(){
		return new ModelAndView("sys/cust-add");
	}
	
	@GetMapping("/update/{custId}")
	public Object update(@PathVariable("custId") Long custId){
		ModelAndView mv = new ModelAndView("sys/cust-update");
		BaseResult<SysCust> result = HttpGate.get("/sys/cust/" + custId, new TypeReference<BaseResult<SysCust>>(){});
		mv.addObject("cust", result.getData());
		return mv;
	}	
	
	@PostMapping("/update/save")
	@ResponseBody
	public Object updateAndSave(HttpServletResponse rp){
		return BaseResult.success();
	}
	
	@PostMapping("/delete/{id}")
	@ResponseBody
	public Object delete(@PathVariable("id") Long id){
		
		return HttpGate.post("/sys/cust/delete/" + id);
	}
	
}
