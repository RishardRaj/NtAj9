package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Srv2 extends HttpServlet {
	
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read and display request attribute value
		pw.println("Srv2: attr1 (req) attribute value"+req.getAttribute("attr1"));
		
		//read and display session attribute value
		 HttpSession ses=req.getSession();
				pw.println("<br>Srv2: attr2 (session) attribute value"+ses.getAttribute("attr2"));
				
		//read and display the ServletContext attribute value
		ServletContext sc=getServletContext();
		pw.println("<br>Srv2: attr3 (ServletContext) attribute value"+sc.getAttribute("attr3"));
		
		
				
		
		//forward the request to Srv3
		RequestDispatcher rd=req.getRequestDispatcher("/Srv3");
		rd.forward(req,res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}


}
