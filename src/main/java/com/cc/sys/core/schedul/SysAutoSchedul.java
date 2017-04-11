package com.cc.sys.core.schedul;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import com.cc.sys.core.counst.SchedulConfig;

@Configuration
@EnableScheduling
public class SysAutoSchedul implements SchedulingConfigurer{
	
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
		taskRegistrar.addTriggerTask(new Runnable() {
			@Override
			public void run() {
				System.out.println("实现动态构建定时任务打印语句,SysAutoSchedul定时调度已经启动"+ new Date());
			}
		}, new Trigger() {
			
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				CronTrigger cronTrigger = new CronTrigger(SchedulConfig.getExecutionTime());
				return cronTrigger.nextExecutionTime(triggerContext);
			}
		});
		
	}

	
	
}
