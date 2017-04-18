package com.cc.sys.core.event;

import org.springframework.context.ApplicationEvent;

public class SpringBootEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;

	public SpringBootEvent(Object source) {
		super(source);
		System.out.print(source.getClass().getName());
	}

}
