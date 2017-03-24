package com.cc.sys.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 跳转系统首页
 * @author chenchao
 */
@Controller
@RequestMapping(path="cc/sys/core/controller/sysIndexController")
public class SysIndexController {
	
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
		System.out.println("Hello");
		return "Hello";
	}
	
}
