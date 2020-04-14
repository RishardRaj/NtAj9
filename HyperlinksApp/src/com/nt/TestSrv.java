package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestSrv extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		  //Generl settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read additional req param value
		String pval=req.getParameter("p1");
		// Execute the logic based on the hyperlink that is clicked
		if(pval.equals("link1")){  //for link1
			Locale locale[]=Locale.getAvailableLocales();
			for(Locale l:locale){
				pw.println("<br>"+l.getDisplayCountry());
			}//for
		}//if
		else if(pval.equals("link2")){
			Locale locale[]=Locale.getAvailableLocales();
			for(Locale l:locale){
				pw.println("<br>"+l.getDisplayLanguage());
			}//for
		}//if
		else{
			pw.println("System date and  time "+new java.util.Date());
		}
	
		//add hyperlink
		pw.println("<a href='page.html'>home</a>");
	}//doGet(-,-)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	    doGet(req, res);
	}//doPost(-,-)
}//class
