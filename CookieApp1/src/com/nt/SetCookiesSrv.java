package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookiesSrv extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//create InMemory cookies
		  Cookie ck1=new Cookie("TS","hyd");
		  Cookie ck2=new Cookie("AP","amaravathi");
		  res.addCookie(ck1);
		  res.addCookie(ck2);
		//create persistent cookies
		  Cookie ck3=new Cookie("TN","chennai");
		  Cookie ck4=new Cookie("MP","Bhopal");
		  ck3.setMaxAge(40);
		  ck4.setMaxAge(40);
		    res.addCookie(ck3); res.addCookie(ck4);
		    //Generate response
		    pw.println("<b> Cookies are succesfully created </b>");
		    //close stream
		    pw.close();
	}//doGet(-,-)		   
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
	
}//class
