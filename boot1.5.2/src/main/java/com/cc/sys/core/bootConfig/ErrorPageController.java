package com.cc.sys.core.bootConfig;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 实现错误页面路径请求重定向映射
 * @author chenchao
 */
@Controller
public class ErrorPageController implements ErrorController{
	
	
	private static final String ERROR_PATH = "/error";  
	
	
	@RequestMapping(value=ERROR_PATH)  
    public String handleError(){  
        return "jsp/error";  
    } 
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	public ErrorPageController() {
		super();
		System.out.println("ErrorPageController---------------<");
	}
	
	

}
