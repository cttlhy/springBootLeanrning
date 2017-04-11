package com.cc.sys.core.counst;

public abstract class SchedulConfig {
	
	private static String ExecutionTime = "0/3 * * * * *";

	public static String getExecutionTime() {
		return ExecutionTime;
	}

	public static void setExecutionTime(String executionTime) {
		ExecutionTime = executionTime;
	}
	
	

}
