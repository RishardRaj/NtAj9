package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SSrv extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		int val=Integer.parseInt(req.getParameter("t1"));
		//cube value
		int cube=val*val*val;
		pw.println("SSrv: Cube value:"+cube);
		
	}//doGet(-,-)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}
	

}
