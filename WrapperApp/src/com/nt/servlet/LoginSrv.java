package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSrv extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
	   // General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		String user=req.getParameter("uname");
		String pass=req.getParameter("pwd");
		//b.logic
		if(user.equals("raja@gmail.com")&&pass.equals("rani")){
			 pw.println("<br><h1> Valid Credentials</h1> ");
		}
		else{
			 pw.println("<br><h1> InValid Credentials</h1> ");
		}
		pw.println("<br> From data:"+user+"....."+pass);
		pw.println("<a href='login.html'>home </a>");
		
		//close stream
		pw.close();
	}
}
