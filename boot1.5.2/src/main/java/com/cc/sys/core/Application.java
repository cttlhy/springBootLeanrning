package com.cc.sys.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
//@EnableScheduling//启动定时任务
//@Import(User.class)//用 import注解可以将非扫描包下的bean被spring管理
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
