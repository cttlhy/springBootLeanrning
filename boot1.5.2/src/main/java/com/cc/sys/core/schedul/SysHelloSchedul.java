package com.cc.sys.core.schedul;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时调度任务
 * @author chenchao
 *
 */
@Configuration
public class SysHelloSchedul {

	/**
	 * 					秒      分      时       周   月   年
	 * @Scheduled(cron="0 0/2 8-20 * * ?") 每天早八点到晚八点，间隔2分钟执行任务
	 * @Scheduled(cron="0 0/3 8-20 * * ?") 每天早八点到晚八点，间隔3分钟执行任务
	 * @Scheduled(cron="0 0/1 8-20 * * ?") 每天早八点到晚八点，间隔1分钟执行任务
	 */

	@Scheduled(cron = "0/5 * * * * ?") // 每5秒执行一次
	public void sayHelloForU() {
		Thread current = Thread.currentThread();
		System.out.println("Hello, My Friend! 线程ID["+ current.getId()+"]向您问好！");
	}

}
