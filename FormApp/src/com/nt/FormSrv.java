package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormSrv extends HttpServlet {
	
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		
		//General settings
		PrintWriter pw=res.getWriter();
		res.addHeader("Content-Disposition","inline;fileName=info.txt");
		res.setContentType("text/plain");
		//read form data
		String name=req.getParameter("name");
		String addrs=req.getParameter("address");
		int age=Integer.parseInt(req.getParameter("age"));
		String ms=req.getParameter("ms");
		String gender=req.getParameter("gender");
		String qlfy=req.getParameter("qlfy");
		String crs[]=req.getParameterValues("crs");
		String hb[]=req.getParameterValues("hb");
		//write B.logic /request processing logic
		if(gender.equalsIgnoreCase("M")){
			if(age<=5)
				pw.println("<h1> Master."+name+"  u  r Baby Boy </h1>");
			else if(age<=12)
				pw.println("<h1> Master."+name+"  u  r  Boy </h1>");
			else if(age<=19)
				pw.println("<h1> Mr."+name +"  u  r Teenage Boy </h1>");
			else if(age<=35)
					pw.println("<h1> Mr."+name+"  u  r young man </h1>");
			else if(age<=55)
				pw.println("<h1> Mr."+name+"  u  r middle -aged man </h1>");
			else
				pw.println("<h1> Mr."+name+"  u  r budda man </h1>");
		}
		else{
			if(age<=5)
				pw.println("<h1> Master."+name+"  u  r Baby Girl </h1>");
			else if(age<=12)
				pw.println("<h1> Master."+name+"  u  r  Girl </h1>");
			else if(age<=19 )
			{
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1> Mrs."+name+"  u  r teenage Girl </h1>");
				else
					pw.println("<h1> Miss."+name+"  u  r teenage Girl </h1>");
			}
			else if(age<=35){
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1> Mrs."+name+"  u  r young woman </h1>");
				else
					pw.println("<h1> Miss."+name+"  u  r  young woman </h1>");
			}
			else if(age<=55){
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1> Mrs."+name+"  u  r  middle-aged woman </h1>");
				else
					pw.println("<h1> Miss."+name+"  u  r  middle-aged woman </h1>");
			}
			else{
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1> Mrs."+name+"  u  r  old woman </h1>");
				else
					pw.println("<h1> Miss."+name+"  u  r old woman </h1>");
			}
		}//else
		
		//Display form data
		pw.println("<br>Name:"+name);
		pw.println("<br>Age:"+age);
		pw.println("<br>Gender:"+gender);
		pw.println("<br>Martial status:"+ms);
		pw.println("<br>Qualification :"+qlfy);
		pw.println("<br>Addres :"+addrs);
		pw.println("<br>Courses"+Arrays.toString(crs));
		pw.println("<br>Hobies1:"+Arrays.toString(hb));
		
		//add hyperlink
		pw.println("<a href='Form.html'><img src='3.jpg'/></a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	
	public  void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}
	
}//class

