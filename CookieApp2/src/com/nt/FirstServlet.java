package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form1/req1 data
		String name=req.getParameter("name");
		String fname=req.getParameter("fname");
		//Strore form1/req1 data as cookie values
		Cookie ck1=new Cookie("name",name);
		Cookie ck2=new Cookie("fname",fname);
		//add cookies  to the response
		res.addCookie(ck1); res.addCookie(ck2);
		// Generate form2/req2 dynamically from here
		pw.println("<form action='surl' method='get'>");
		pw.println("Income for this year : <input type='text' name='income'> <br>");
		pw.println("Tax : <input type='text' name='tax'> <br>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}

}
