package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestSrv2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form1/req1 data  from the hidden boxes of  form2
		String name=req.getParameter("hname");
		String fname=req.getParameter("hfname");
		String ms=req.getParameter("hms");
		//read form2/req2 data
		String  f2val1=req.getParameter("f2t1");
		String  f2val2=req.getParameter("f2t2");
		
		//write jdbc code to insert both form1/req1  and form2/req2 values
		// ad DB table record.
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			PreparedStatement ps=con.prepareStatement("insert into person_tab values(?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,fname);
			ps.setString(3,ms);
			ps.setString(4,f2val1);
			ps.setString(5, f2val2);
			int result=ps.executeUpdate();
			
			if(result==0)
				 pw.println("<b> Registration failed</b>");
			else
				 pw.println("<b> Registration succeeded</b>");
			
			//close jdbc objs
			ps.close();
			con.close();
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		
		//Display form1/req1 and form2/req2 values
		pw.println("<br>Form1/req1 data"+name+"..."+fname+"...."+ms);
		pw.println("<br>Form2/req2 data"+f2val1+"....."+f2val2);
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)

}//class

