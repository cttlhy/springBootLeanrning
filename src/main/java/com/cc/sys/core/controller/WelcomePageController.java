package com.cc.sys.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 目的：对于直接请求网站上下文时，跳转到登录页面
 * @author chenchao
 */
@Controller
public class WelcomePageController {
	private static final Logger logger = LoggerFactory.getLogger(WelcomePageController.class);
	
	@RequestMapping("/")
	public String toWelcomePage(){
		return "redirect:/login/login.jsp";
	}
}
