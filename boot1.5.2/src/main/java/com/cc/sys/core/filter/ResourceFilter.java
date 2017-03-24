package com.cc.sys.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
/**
 * 对所有的请求进行过滤
 * @author chenchao
 */
@WebFilter(filterName="ResourceFilter",urlPatterns= {"/html/*","/resource/*"})
@Order(value=1)
public class ResourceFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURL().toString();
		System.out.println("被过滤器检测到的请求地址:-->"+path);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
}
