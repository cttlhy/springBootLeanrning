package com.cc.sys.core.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * http会话监听器每次会话则会发起监听
 * @author chenchao
 *
 */
@WebListener
public class TestHttpSessionListener implements HttpSessionListener {

	@Override 
	public void sessionCreated(HttpSessionEvent se) {
		 System.out.println("Session 被创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		 System.out.println("Session 被销毁");
}

}
