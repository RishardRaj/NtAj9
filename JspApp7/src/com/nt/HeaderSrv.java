package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderSrv extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//Writer Header logic
		pw.println("<marquee><h1 style='color:red'> HCL Technologies </h1></marquee>");
		
		//do not close stream
		//pw.close();
	}//doGet(-,-)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}
}//class
