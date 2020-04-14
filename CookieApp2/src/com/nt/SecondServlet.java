package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	
	  @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		  // General settings
		  PrintWriter pw=res.getWriter();
		  res.setContentType("text/html");
		  
		  //read form2/req2 data
		  String income=req.getParameter("income");
		  String tax=req.getParameter("tax");
		  //read form1/req1 data form cookies
		  Cookie cookies[]=req.getCookies();
		  String name=null,fname=null;
		  if(cookies!=null){
			  name=cookies[0].getValue();
			  fname=cookies[1].getValue();
		  }//if
		  //write jdbc code to write both form1/req1 and form2/req2 vlaues
		  try{
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			  PreparedStatement ps=con.prepareStatement("insert into Tax_tab values(?,?,?,?)");
			  ps.setString(1,name);
			  ps.setString(2,fname);
			  ps.setString(3,income);
			  ps.setString(4,tax);
			  int result=ps.executeUpdate();
			  
			  //process the result
			  if(result==0)
				  pw.println("<h1> Registration Failed </h1>");
			  else
				  pw.println("<h1> Registration Success </h1>");
				  
		  }//try
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  //Display form1/req1 and form2/req2 values as dynamic web page content
		  pw.println("<br>Form1/req1 data"+name+"....."+fname);
		  pw.println("<br>Form2/req2 data"+income+"....."+tax);
		  //close stream
		  pw.close();
	}//doGet(-,-)
	  
	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class

