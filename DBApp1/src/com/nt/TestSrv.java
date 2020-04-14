package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestSrv extends HttpServlet {
	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		 //general settings
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html");
		 //access ServletConfing obj
		 ServletConfig cg=getServletConfig();
		 pw.println("Init param dbuser value"+cg.getInitParameter("dbuser"));
		 pw.println("<br>Logical name of current servlet"+cg.getServletName());
		 pw.println("<br> Servletconfig obj class name"+cg.getClass());
		 
		 //access ServletContext obj
		 ServletContext sc=getServletContext();
		 pw.println("<br> ServletContext obj class name"+sc.getClass());
		 
		 pw.println("<br> Server info:"+sc.getServerInfo());
		    // Tomcat/8.0.3
		 pw.println("<br> Servet api version:"+sc.getMajorVersion()
				                                                                +"."+sc.getMinorVersion());
		   //  3.1
		 pw.println("<br> Context path "+sc.getContextPath());
		  //  /DBApp1
		 pw.println("<br> Path of web application"+sc.getRealPath("/"));
		  // D:/Tomcat 8.0/webapps/DBApp
		 pw.println("<br> path of input.html file"+sc.getRealPath("/input.html"));
		 // D:/Tomcat 8.0/webapps/DBApp/input.html
		 pw.println("<br> MIME type of input.html"+sc.getMimeType("input.html"));
		 // text/html
		 
		 sc.log("hai  date "+new java.util.Date());
		 
		 
		 
		 
		 
		 
		 //close stream
		 pw.close();
	}//doGet(-,-)

}
