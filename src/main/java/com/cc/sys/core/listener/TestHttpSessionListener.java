package com.cc.sys.core.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * http会话监听器每次会话则会发起监听
 * @author chenchao
 *
 */
@WebListener
public class TestHttpSessionListener implements HttpSessionListener {
	private static final Logger logger = LoggerFactory.getLogger(TestHttpSessionListener.class);
	@Override 
	public void sessionCreated(HttpSessionEvent se) {
		logger.info("Session 被创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.info("Session 被销毁");
}

}
