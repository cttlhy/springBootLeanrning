package com.cc.sys.core.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cc.sys.core.counst.SchedulConfig;
import com.cc.sys.core.dto.SysUser;
import com.cc.sys.core.service.UserService;
import com.github.pagehelper.PageInfo;

/**
 * 目的：index.jsp页面所需要的跳转后台mapping映射 跳转系统首页
 * 
 * @author chenchao
 */
@Controller
@RequestMapping(path = "cc/sys/core/controller/sysIndexController")
public class SysIndexController {
	private static final Logger logger = LoggerFactory.getLogger(SysIndexController.class);

	@Resource
	private UserService userService;
	
	@Resource
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;
	
	private ScheduledFuture<?> schedule;//启动调度后的任务对象
	

	@RequestMapping(path = "index", method = RequestMethod.GET)
	public ModelAndView gotoIndexPage(HttpServletRequest request, HttpServletResponse reponse) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cc/sys/core/index");
		request.setAttribute("url", "cc/sys/core/controller/sysIndexController/operation/");
		return mav;
	}

	@RequestMapping(path = "operation/hello", method = RequestMethod.GET)
	@ResponseBody
	public String sayHello(HttpServletRequest request, HttpServletResponse reponse) {
		logger.debug("Hello");
		return "Hello";
	}

	@RequestMapping(path = "operation/testMybatis", method = RequestMethod.GET)
	@ResponseBody
	public SysUser testMybatis(HttpServletRequest request, HttpServletResponse reponse) {
		logger.debug("testMybatis");
		SysUser user = userService.selectUserById("1");
		return user;
	}

	@RequestMapping(path = "operation/testPageHelper", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<SysUser> testPageHelper(HttpServletRequest request, HttpServletResponse reponse) {
		logger.debug("testPageHelper");
		PageInfo<SysUser> users = userService.listUsers2();
		return users;
	}

	@RequestMapping(path = "operation/testNoPageHelper", method = RequestMethod.GET)
	@ResponseBody
	public List<SysUser> testNoPageHelper(HttpServletRequest request, HttpServletResponse reponse) {
		logger.debug("testPageHelper");
		List<SysUser> users = userService.listUsers();
		return users;
	}

	@RequestMapping(path = "operation/deleteById/{id}", method = RequestMethod.GET)
	@ResponseBody
	public int deleteById(@PathVariable String id, HttpServletRequest request, HttpServletResponse reponse)
			throws Exception {
		logger.debug("deleteById");
		int res = userService.deleteById(Integer.parseInt(id));
		return res;
	}

	@RequestMapping(path = "operation/insert", method = RequestMethod.GET)
	@ResponseBody
	public int insert(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		logger.debug("insert");
		int res = 0;
		res = userService.insert();
		return res;
	}

	@RequestMapping(path = "operation/removeAllCache", method = RequestMethod.GET)
	@ResponseBody
	public String removeAllCache(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		logger.debug("removeAllCache");
		String msg = userService.removeAllCache();
		return msg;
	}

	@RequestMapping(path = "operation/changeExcutionTime", method = RequestMethod.POST)
	@ResponseBody
	public String changeExcutionTime(@RequestParam String excutionTime) {
		SchedulConfig.setExecutionTime(excutionTime);
		return "更改成功.";
	}
	@RequestMapping(path = "operation/start_A_Task", method = RequestMethod.GET)
	@ResponseBody
	public String start_A_Task(){
		System.out.println(threadPoolTaskScheduler.getPoolSize());
		schedule = threadPoolTaskScheduler.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("start_A_Task,启动成功：-->"+ new Date());
			}
		}, new Trigger() {
			
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				CronTrigger cronTrigger = new CronTrigger(SchedulConfig.getExecutionTime());
				return cronTrigger.nextExecutionTime(triggerContext);
			}
		});
		return "启动任务成功！";
	}
	@RequestMapping(path = "operation/stop_the_started_Task", method = RequestMethod.GET)
	@ResponseBody
	public String stop_the_started_Task(){
		if(schedule!=null){//如果存在调度执行，再关闭
			schedule.cancel(true);
		}
		return "任务关闭";
	}
	
	

}
