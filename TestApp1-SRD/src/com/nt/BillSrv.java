package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BillSrv extends  HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		String name=req.getParameter("iname");
		float price =Float.parseFloat(req.getParameter("iprice"));
		float qty= Float.parseFloat(req.getParameter("qty"));
		// Calc Bill amount
		float billAmt=price*qty;
		if(billAmt>=50000){
			//redirect the request to Discount Srv
			res.sendRedirect("http://localhost:7080/TestApp2-SRD/discounturl?bAmt="+billAmt+"&iname="+name);
		
		}
		else{
			//Dispaly Bill Details
			pw.println("<br> Name="+name);
			pw.println("<br> Bill Amt="+billAmt);
			
		}//else
		
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	 doGet(req,res);
	}//doPost(-,-)
}//class

