package com.cc.sys.core.bootConfig.globalCF;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cc.sys.core.interceptor.FirstInterceptor;

@Configuration
public class MappingResourceConfig extends WebMvcConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(MappingResourceConfig.class);

	/**
	 * 配置视图解析器
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);
	}

	@Autowired
	private FirstInterceptor firstInterceptor;
	/**
	 * 添加拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(firstInterceptor);
		logger.info("=================>加载自定义拦截器1【com.cc.sys.core.interceptor.FirstInterceptor】");
		super.addInterceptors(registry);
	}

}
