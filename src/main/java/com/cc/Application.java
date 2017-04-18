package com.cc;

import java.nio.charset.Charset;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@ServletComponentScan
@SpringBootApplication
@EnableTransactionManagement
// @EnableScheduling//启动定时任务
// @Import(Dept.class)//用 import注解可以将非扫描包下的bean被spring管理
public class Application extends SpringBootServletInitializer implements TransactionManagementConfigurer  {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Bean(name = "dataSourceTransactionManager")
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	// 创建事务管理器2
	@Bean(name = "jpaTransactionManager")
	public PlatformTransactionManager txManager2(EntityManagerFactory factory) {
		return new JpaTransactionManager(factory); 
	}

	@Resource
	private JpaTransactionManager jpaTransactionManager;
	// 实现接口 TransactionManagementConfigurer 方法，其返回值代表在拥有多个事务管理器的情况下默认使用的事务管理器
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return jpaTransactionManager;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 可实现打成war包在tomcat中部署 注意: 1.该主类需要继承SpringBootServletInitializer类并且重写该方法
	 * 2.在pom.xml中将org.apache.tomcat.embed 的 scope 修改为 provided
	 * 3.在pom.xml中的bulid标签中，添加最终打包名称用来tomcat部署时的上下文名称
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Application.class);
	}

	/**
	 * 使用fastjson作为转换器
	 * @return
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setCharset(Charset.forName("utf-8"));
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}
 
	
	@Value("${spring.upload.maxSize}")
	private String maxSize;//单个文件上传最大尺寸限制
	@Value("${spring.upload.totalSize}")
	private String totalSize;//所有文件最大尺寸限制
	/**
	 * 文件上传大小限制
	 * 
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
		factory.setMaxFileSize(maxSize); // KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize(totalSize);
		// Sets the directory location wherefiles will be stored.
		// factory.setLocation("d:/imgFile");
		return factory.createMultipartConfig();

	}
	
	
	/**
	 * 动态启动停止调度任务所需要注入的类，为在后台的controller中自动注入所用
	 * @return
	 */
	@Bean(name="threadPoolTaskScheduler")
	public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
		return new ThreadPoolTaskScheduler();
	}

	
	
	

}
