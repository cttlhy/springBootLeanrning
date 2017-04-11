package com.cc.sys.core.listener;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.springframework.boot.autoconfigure.batch.JobExecutionEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
/**
 * springboot 容器提供的监听接口
 * @author chenchao
 *
 */
public class SpringbootContextListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("listener");
		if(event instanceof JobExecutionEvent){
			System.out.println("调度执行器监听事件..");
		}
		
	}

}
