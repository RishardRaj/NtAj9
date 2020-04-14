package com.nt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchSrv extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//read form data
		String ss=req.getParameter("ss");
		String engg=req.getParameter("engg");
		//prepare url for send redirection
		String url=null;
		if(engg.equalsIgnoreCase("google")){
			url="https://www.google.co.in/search?q="+ss;
		}
		else if(engg.equalsIgnoreCase("bing")){
			url="http://www.bing.com/search?q="+ss;
		}
		else{
			url="https://in.search.yahoo.com/search?p="+ss;
		}
		//perform SendDirection
		res.sendRedirect(url);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}

}
