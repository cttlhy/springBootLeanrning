package com.cc.sys.core.counst;

/***
 * 平台通用常量池枚举集
 * 
 * @author chenchao
 */
public class PlatformConstant {

	/**
	 * 操作类型
	 * @author chenchao
	 */
	public static enum ActionType {
		login, insert, delete, update, select, logout;
		private ActionType() {
		}
	}

	/**
	 * 后期扩展日志所记录所需枚举
	 * @author chenchao
	 */
	public static enum LogType {
		module_operate, system_manage, safety_manage, safety_audit;
		private LogType() {
		}
	}
	
	/**
	 * 操作返回结果类型
	 * @author chenchao
	 */
	public static enum ActionResult {
		success,  failure;
	    private ActionResult() {};
	}
}
