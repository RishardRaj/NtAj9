package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrSrv extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("ErrSrv:doGet(-,-)");
		  PrintWriter pw=res.getWriter();
	      res.setContentType("text/html");
	    // Display Guiding message to enduser
	     pw.println("<font color='red'><b><center> Internal problem </font></b></center>");
	     pw.println("<a href='input.html'>Try again </a>");
	     
	     //close stream
	     pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}

}
