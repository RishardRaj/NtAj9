package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

 

public class ValidateFilter implements Filter {
	
	public ValidateFilter() {
	 System.out.println("ValidateFilter:0-param constructor");
	}

	@Override
	public void init(FilterConfig fg) throws ServletException {
		System.out.println("ValidateFilter:init(-)");
	}

	

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException {
		System.out.println("Validate Filter :doFilter(-,-)");
		//general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		int val1=Integer.parseInt(req.getParameter("first"));
		int val2=Integer.parseInt(req.getParameter("second"));
		if(val1<0 || val2<0){
			pw.println("<i><h1> Invalid Inputs !!!!</h1></i>");
			return;
		}
		else{
			System.out.println("ValidateFilter: before fc.doFilter(-,-)");
			fc.doFilter(req,res);
			System.out.println("ValidateFilter: after fc.doFilter(-,-)");
		}
	}//doFilter(-,-)
	
	@Override
	public void destroy() {
	System.out.println("ValidateFilter: destroy()");
	}
}//class

