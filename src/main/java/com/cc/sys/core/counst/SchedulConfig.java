package com.cc.sys.core.counst;

/**
 * 动态切换调度时间表达式所配置的抽象类，主要声明表达式
 * @author chenchao
 *
 */
public abstract class SchedulConfig {
	
	private static String ExecutionTime = "0/3 * * * * *";

	public static String getExecutionTime() {
		return ExecutionTime;
	}

	public static void setExecutionTime(String executionTime) {
		ExecutionTime = executionTime;
	}
	
	

}
