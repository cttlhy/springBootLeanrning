package com.cc.sys.core.schedul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import com.cc.sys.core.listener.TestServletContextListener;

/**
 * 定时调度任务
 * @author chenchao
 *
 */
@Configuration
public class SysHelloSchedul {
	private static final Logger logger = LoggerFactory.getLogger(TestServletContextListener.class);
	/**
	 * 					秒      分      时       周   月   年
	 * @Scheduled(cron="0 0/2 8-20 * * ?") 每天早八点到晚八点，间隔2分钟执行任务
	 * @Scheduled(cron="0 0/3 8-20 * * ?") 每天早八点到晚八点，间隔3分钟执行任务
	 * @Scheduled(cron="0 0/1 8-20 * * ?") 每天早八点到晚八点，间隔1分钟执行任务
	 */

	@Scheduled(cron = "0/5 * * * * ?") // 每5秒执行一次
	public void sayHelloForU() {
		Thread current = Thread.currentThread();
		logger.info("线程调度类!【com.cc.sys.core.schedul.SysHelloSchedul】 线程ID["+ current.getId()+"]向您问好！");
	}

}
