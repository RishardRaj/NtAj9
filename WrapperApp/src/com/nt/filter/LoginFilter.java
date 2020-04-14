package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrappers.MyRequest;
import com.nt.wrappers.MyResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException {
		// Create Custom Request
		HttpServletRequest hreq=(HttpServletRequest)req;
		MyRequest mreq=new MyRequest(hreq);
		
		//create Custom Response obj
		HttpServletResponse hres=(HttpServletResponse)res;
		MyResponse mres=new MyResponse(hres);
		 
		//pass request to Servlet
		fc.doFilter(mreq,mres);
		
		String resp=mres.toString().toUpperCase();
		resp=resp+" AmeerPet, Hyd.";
		
		// add Modified response to the Orginal response obj
		PrintWriter pw=res.getWriter();
		pw.println(resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
