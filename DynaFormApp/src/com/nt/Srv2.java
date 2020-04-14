package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Srv2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form1/req2 data
		String name=req.getParameter("name");
		String fname=req.getParameter("fname");
		String ms=req.getParameter("ms");
		//read form2/req2 data
		String  f2val1=req.getParameter("f2t1");
		String  f2val2=req.getParameter("f2t2");
		
		//Display form1/req1 and form2/req2 values
		pw.println("<br>Form1/req1 data"+name+"..."+fname+"...."+ms);
		pw.println("<br>Form2/req2 data"+f2val1+"....."+f2val2);
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)

}//class

