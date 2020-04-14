package com.nt;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;



public class PerfTestFilter implements Filter {

	ServletContext sc=null;
	@Override
	public void init(FilterConfig fg) throws ServletException {
        sc=fg.getServletContext();
	}
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException {
		long start=System.currentTimeMillis();
		System.out.println("PerfTestFilter: before fc.doFilter(-,-)");
		fc.doFilter(req,res);
		System.out.println("PerfTestFilter: after fc.doFilter(-,-)");
		long end=System.currentTimeMillis();
		//type casting
		HttpServletRequest hreq=(HttpServletRequest)req;
		//write to log
		sc.log(hreq.getRequestURI()+" has taken "+(end-start)+" ms to process the request");
	}//doFilter(-,-)

	@Override
	public void destroy() {
		
		
	}



}
