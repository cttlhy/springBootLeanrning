package com.cc.sys.core.bootConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 实现错误页面路径请求重定向映射
 * @author chenchao
 */
@Controller
public class ErrorPageController implements ErrorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ErrorPageController.class);
	private static final String ERROR_PATH = "/error";  
	
	
	@RequestMapping(value=ERROR_PATH)  
    public String handleError(){  
		logger.info("重定向/error资源地址到-->login/error.jsp");
        return "redirect:/login/error.jsp";  
    } 
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}
