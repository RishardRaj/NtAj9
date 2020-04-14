package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SumServlet extends HttpServlet {
    public SumServlet() {
    	System.out.println("SumServlet:0-param constructor");
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Sum Servlet:doGet(-,-)");
		// general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		int val1=Integer.parseInt(req.getParameter("first"));
		int val2=Integer.parseInt(req.getParameter("second"));
		//Perform Addition
		int sum=val1+val2;
		//Display Results
		pw.println("<h1>Result/Sum:</h1> "+sum);
		//close stream
		pw.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}

}
