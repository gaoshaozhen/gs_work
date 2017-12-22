package com.gs.store.web.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.gs.common.utils.LogMaker;
import com.gs.sdk.BaseResult;
import com.gs.sdk.web.HttpGate;
import com.gs.sdk.web.auth.AuthAccessUtil;
import com.gs.sdk.web.auth.SessionContext;
import com.gs.store.dto.SysUserDTO;

@Controller
@RequestMapping("/store")
public class LoginController {
	Logger log = LogMaker.make();
	@Autowired
	Producer producer;

	@GetMapping("/login")
	public Object go() {
		log.debug("sdfcsd*********************************************");
		return new ModelAndView("login");
	}

	@PostMapping("/login")
	@ResponseBody
	public Object login(@RequestParam("userCode") String userCode,
			@RequestParam("password") String password,
			@RequestParam("kaptcha") String kaptcha) {
		if (checkKaptcha(kaptcha)) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("userCode", userCode);
			param.put("password", password);
			BaseResult<List<SysUserDTO>> base = HttpGate.post("/sys/user/params", param, new TypeReference<BaseResult<List<SysUserDTO>>>(){});
			List<SysUserDTO> list = base.getData();
			if(CollectionUtils.isEmpty(list)){
				return BaseResult.fail("用户不存在");
			}
			SysUserDTO user = (SysUserDTO)CollectionUtils.get(list, 0);
			
			SessionContext session = AuthAccessUtil.getSession();
			
			session.setAttribute("userCode", user.getUserCode());
			session.setAttribute("userType", String.valueOf(user.getUserType()));
			session.setAttribute("custId", String.valueOf(user.getCustId()));
			session.setAttribute("roleId", String.valueOf(user.getRoleId()));
			AuthAccessUtil.login();
			return BaseResult.success();
		}
		return BaseResult.fail("验证码不正确");
	}

	@GetMapping("/test")
	public Object test() {

		return new ModelAndView("test");
	}

	@RequestMapping("/kapcha")
	public Object kapcha(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = producer.createText();
		log.debug("验证码：{}", capText);
		AuthAccessUtil.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,
				capText);
		BufferedImage bi = producer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}

	@GetMapping("/index")	
	public Object index() {
		return "index";
	}

	private boolean checkKaptcha(String kaptcha) {
		SessionContext session = AuthAccessUtil.getSession();
		Map<String, String> map = session.getAttributes();
		return Objects.equals(kaptcha, map.get(Constants.KAPTCHA_SESSION_KEY));
	}
}
