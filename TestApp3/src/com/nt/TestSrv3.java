package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestSrv3 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read s1 req param value.
		String pval=req.getParameter("s1");
		
		if(pval.equals("add")){  //add button
			int val1=Integer.parseInt(req.getParameter("t1"));
			int val2=Integer.parseInt(req.getParameter("t2"));
			int result=val1+val2;
			pw.println("Sum ="+result);
		}
		else if(pval.equals("sub")){  //add subtraction
			int val1=Integer.parseInt(req.getParameter("t1"));
			int val2=Integer.parseInt(req.getParameter("t2"));
			int result=val1-val2;
			pw.println("Sub ="+result);
		}
		else if(pval.equals("mul")){
			int val1=Integer.parseInt(req.getParameter("t1"));
			int val2=Integer.parseInt(req.getParameter("t2"));
			int result=val1*val2;
			pw.println("Mul ="+result);
		}
		else if(pval.equals("link1")){
			Properties props=System.getProperties();
			pw.println("System properties"+props);
		}
		else{
			Date d=new Date();
			pw.println("System Date"+d);
		}
		
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)

}//class
