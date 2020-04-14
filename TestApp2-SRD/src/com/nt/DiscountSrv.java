package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DiscountSrv extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read additional req params that are coming along with request
		float bamt=Float.parseFloat(req.getParameter("bAmt"));
		String iname=req.getParameter("iname");
		//calc Discount amount and final amount
		float discount=bamt*0.3f;
		float finalAmt=bamt-discount;
		//Display the details
		pw.println("<br>Item name"+iname);
		pw.println("<br>Bill Amt:"+bamt);
		pw.println("<br>Discount Amt:"+discount);
		pw.println("<br>Final Amt:"+finalAmt);
  }//doGet(-,-)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	  doGet(req,res);
	}//doPost(-,-)
}//class

