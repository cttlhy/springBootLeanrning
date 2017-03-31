package com.cc.sys.core.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cc.sys.core.dto.SysUser;
import com.cc.sys.core.service.UserService;

/**
 * 目的：index.jsp页面所需要的跳转后台mapping映射
 * 跳转系统首页
 * @author chenchao
 */
@Controller
@RequestMapping(path="cc/sys/core/controller/sysIndexController")
public class SysIndexController {
	private static final Logger logger = LoggerFactory.getLogger(SysIndexController.class);
	
	
	@Resource
	private UserService userService;
	
	@RequestMapping(path="index",method=RequestMethod.GET)
	public ModelAndView gotoIndexPage(HttpServletRequest request, HttpServletResponse reponse){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cc/sys/core/index");
		request.setAttribute("url", "cc/sys/core/controller/sysIndexController/operation/");
		return mav; 
	}
	
	@RequestMapping(path="operation/hello",method=RequestMethod.GET)
	@ResponseBody
	public String sayHello(HttpServletRequest request, HttpServletResponse reponse){
		logger.debug("Hello");
		return "Hello";
	}
	
	
	@RequestMapping(path="operation/testMybatis",method=RequestMethod.GET)
	@ResponseBody
	public SysUser testMybatis(HttpServletRequest request, HttpServletResponse reponse){
		logger.debug("testMybatis");
		SysUser user = userService.selectUserById("1");
		return user;
	}
	
}
