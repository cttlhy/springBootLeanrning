package com.cc.sys.core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class TestServletContextListener implements ServletContextListener  {
	private static final Logger logger = LoggerFactory.getLogger(TestServletContextListener.class);
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("ServletContex初始化");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("ServletContex销毁");
	}

}
