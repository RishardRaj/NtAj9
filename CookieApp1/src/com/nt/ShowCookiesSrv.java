package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCookiesSrv extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1> Cookies are </h1>");
		//read and display the cookies
		Cookie ck[]=req.getCookies();
		if(ck!=null){
			for(Cookie cck: ck){
				pw.println("<br>"+cck.getName()+"......"+cck.getValue());
			}//for
		}//fi
		
		
		//close stream
		pw.close();
		
	}
	
}
