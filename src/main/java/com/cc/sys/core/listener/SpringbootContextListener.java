package com.cc.sys.core.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
/**
 * springboot 容器提供的监听接口
 * @author chenchao
 *
 */
public class SpringbootContextListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("************************************************");
		String CLASS_NAME = event.getClass().getName();
		System.out.println(CLASS_NAME);
		System.out.println("************************************************");
	}

}
