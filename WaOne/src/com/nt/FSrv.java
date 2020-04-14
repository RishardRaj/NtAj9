package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FSrv extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		int val=Integer.parseInt(req.getParameter("t1"));
		//calc Square value
		int square=val*val;
		pw.println("FSrv: Square :"+square);
		//Include the response of SSrv of WaTwo web application
		     // get SerlvetContext obj of current web application(WaOne)
		          ServletContext sc1=getServletContext();
		     //get ServletContext obj of WaTwo web application
		          ServletContext sc2=sc1.getContext("/WaTwo");
             //get ReqeustDispatcher obj pointing to SSrv prg of WaTwo
		          RequestDispatcher rd=sc2.getRequestDispatcher("/surl");
		          rd.include(req, res);
		
	    //close stream
		          pw.close();
	}//doGet(-,-)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)

}//class

