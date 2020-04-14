package com.nt;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RequestCountFilter implements Filter {

	private int counter;
	ServletContext sc;
	@Override
	public void init(FilterConfig fg) throws ServletException {
	  sc=fg.getServletContext();
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException {
	  counter++;
	  // keep counter as Servletcontext attribute
	  sc.setAttribute("ReqCnt",counter);
	   
	  fc.doFilter(req, res);
	}
	@Override
	public void destroy() {
	}
}
