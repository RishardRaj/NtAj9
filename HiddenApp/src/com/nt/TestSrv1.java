package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestSrv1 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form1/request1 data
		String name=req.getParameter("name");
		String fname=req.getParameter("fname");
		String ms=req.getParameter("ms");
		// Based on Marital status generate form2 dyanamically
		if(ms.equals("single")){
			pw.println("<form action='t2url' method='get'>");
			pw.println("When do want to marry <input type='text' name='f2t1'><br> ");
			pw.println("Why do want to marry <input type='text' name='f2t2'><br> ");
			pw.println("<input type='submit' value='submit'>");
			// add form1 data to form2 page in the form hidden box values
			pw.println("<input type='hidden' name='hname' value="+name+">");
			pw.println("<input type='hidden' name='hfname' value="+fname+">");
			pw.println("<input type='hidden' name='hms' value="+ms+">");
            pw.println("</form>")	;		
		}
		else{
			pw.println("<form action='t2url' method='get'>");
			pw.println("Spouse Name <input type='text' name='f2t1'><br> ");
			pw.println("No.of children <input type='text' name='f2t2'><br> ");
			pw.println("<input type='submit' value='submit'>");
			pw.println("<input type='hidden' name='hname' value="+name+">");
			pw.println("<input type='hidden' name='hfname' value="+fname+">");
			pw.println("<input type='hidden' name='hms' value="+ms+">");
            pw.println("</form>")	;		
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

