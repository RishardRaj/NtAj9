//DBSrv.java
package com.nt;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.sql.*;

public class DBSrv extends HttpServlet{
	private static  final String GET_EMP_DETAILS_BY_ENO="select empno,ename,job,sal from emp where empno=?";
	private Connection con;
	private PreparedStatement ps;
	public void init(){
		try{
      //Access ServletContext obj  to read global init params/context params
	     ServletContext sc=getServletContext();
		 String driver=sc.getInitParameter("driver");
		 String url=sc.getInitParameter("url");
		 String user=sc.getInitParameter("dbuser");
		 String pwd=sc.getInitParameter("dbpwd");

      //register jdbc driver
	  Class.forName(driver);
	  //Establish the connection
	  con=DriverManager.getConnection(url,user,pwd);
	  //create PareparedStatement obj
	  ps=con.prepareStatement(GET_EMP_DETAILS_BY_ENO);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//init()

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		//General settings 
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		 //include header 
	       RequestDispatcher rd1=req.getRequestDispatcher("/headurl");
	       rd1.include(req,res);
		
		try{
		//read form data
		int no=Integer.parseInt(req.getParameter("teno"));
		//set value to Query param
		ps.setInt(1,no);
		//execute the Query
		ResultSet rs=ps.executeQuery();
		//proces the ResultSet
		if(rs.next()){
			pw.println("<br> Emp no"+rs.getInt(1));
			pw.println("<br> Emp Name"+rs.getString(2));
			pw.println("<br> Emp Job"+rs.getString(3));
			pw.println("<br> Emp Salary"+rs.getInt(4));
		}
		else{
			pw.println("<font color='red'> Employee not found </font>");
		}

		// add hyperlink
		pw.println("<br><a href='input.html'>Home </a><br><br><br><br>");
		
		   //include footer
	       RequestDispatcher rd2=req.getRequestDispatcher("/footer.html");
	       rd2.include(req,res);
		//close streams
		rs.close();
		pw.close();
		}//try
		catch(Exception e){
			ServletContext sc=getServletContext();
			RequestDispatcher rd=sc.getRequestDispatcher("/eurl");
		
			rd.forward(req,res);
		
		}
	}//doGet(-,-)

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
     doGet(req,res);
	}

	public void destroy(){
		try{
			if(ps!=null)
				ps.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(con!=null)
				con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//destroy()

}//class
//>javac  -d  . DBSrv.java


