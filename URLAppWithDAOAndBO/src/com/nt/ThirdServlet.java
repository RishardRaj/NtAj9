package com.nt;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.bo.PersonBO;
import com.nt.dao.PersonDAO;

public class ThirdServlet extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,  IOException 
	{
		res.setContentType( "text/html" ) ;
		PrintWriter pw = res.getWriter( ) ;

		String city=req.getParameter("city");
		String sal=req.getParameter("sal");

		HttpSession session = req.getSession(false) ;   

		String name = (String)session.getAttribute("name");
		String addr = (String)session.getAttribute("Addr");
		String age = (String)session.getAttribute("age");
		String exp = (String)session.getAttribute("exp");
		String skils = (String)session.getAttribute("skils");
		try{
		//write  form1/req1, form2/req2 and form3/req3 values to DB table as record
		// using DAO class
		PersonDAO dao=new PersonDAO();
		//create BO obj
		PersonBO bo=new PersonBO();
		bo.setName(name);
		bo.setAge(age);
		bo.setAddrs(addr);
		bo.setExp(exp);
		bo.setSkill(skils);
		bo.setCity(city);
		bo.setSal(sal);
		//Use DAO class
		int result=dao.insert(bo);

			 if(result > 0)
			 {
				pw.println("<BODY BGCOLOR=cyan>");
				pw.println("<CENTER><H1><FONT COLOR=red>Successfully Inserted  </FONT></H1></CENTER>");

				pw.println("<a href= personal.html>Home</a>");
				pw.println("</table></body>");
			 }
			 else
			 {
				pw.println("<BODY BGCOLOR=cyan>");
				pw.println("<CENTER><H1><FONT COLOR=red>Try Again</FONT></H1></CENTER>");
				pw.println("<a href= personal.html>Home</a>");
			  }
			 pw.println("<br><br>Session id is"+session.getId());
			  System.out.println("end of the Application");
		} // try
		catch(Exception e)
		{
			e.printStackTrace();
			pw.println("<BODY BGCOLOR=cyan>");
			pw.println("<CENTER><H1><FONT COLOR=red>Try Again</FONT></H1></CENTER>");
			pw.println("<a href= personal.html>Home</a>");
		}
	} // service()
} // class