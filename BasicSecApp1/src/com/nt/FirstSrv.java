package com.nt;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class FirstSrv extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
 PrintWriter pw=resp.getWriter();
 resp.setContentType("text/html");
 pw.println("page successfully displayed");
pw.println("<center><b>the user name is "+req.getRemoteUser()+"</center></b>");
pw.println("<center><b>the auth type    is "+req.getAuthType()+"</center></b>");
 pw.close();
}// service()
}// class
	