package com.test.football.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//@WebFilter("/*")
public class CORSFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletResponse resp = (HttpServletResponse) res;
		resp.setHeader("Acess-Control-Allow-Origin", "*");
		resp.setHeader("Acess-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		resp.setHeader("Acess-Control-Allow-Headers", "Content-Type, Authorization");
		resp.setHeader("Acess-Control-Max-Age", "3600");
		if("OPTIONS".equalsIgnoreCase(((HttpServletRequest)request).getMethod())) {
			resp.setStatus(HttpServletResponse.SC_OK);
		}else {
			chain.doFilter(request, res);
		}
	}
	
}
