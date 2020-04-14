package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ConnPoolServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		String tableName=req.getParameter("table");
		// get con obj from jdbc con pool
		Connection con=makeConnection();
		try{
			//create Statement obj
			Statement st=con.createStatement();
			//send and execute SQL Query in Db s/w
			ResultSet rs=st.executeQuery("select  * from  "+tableName);
			//get ResultSetMetaData
			ResultSetMetaData rsmd=rs.getMetaData();
			int colcnt=rsmd.getColumnCount();
			//print col names as html table row headings
			pw.println("<table border='1' bgcolor='cyan'>");
			pw.println("<tr bgcolor='red'>");
			for(int i=1;i<=colcnt;++i){
				pw.print("<th>"+rsmd.getColumnLabel(i)+"</th>");
			}
			pw.println("</tr>");
			//print col values as db table row values
			while(rs.next()){
				pw.println("<tr bgcolor='yellow'>");
				for(int i=1;i<=colcnt;++i){
					pw.println("<td>"+rs.getString(i)+"</td>");
				}//for
				pw.println("</tr>");
			}//while
			pw.println("</table>");
			pw.println("<a href='index.html'>home</a>");
			//close streams
			rs.close();
			st.close();
			con.close();
			pw.close();
		 }//try
		catch(Exception e){
			pw.println("<b><i> Table not found </b></i>");
		}
	}//doGet(-,-)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
	
	//use-defined method to get con obj from jdbc con pool
	public Connection makeConnection(){
		try{
			// create InitialContext obj pointing jndi registry
			InitialContext ic=new InitialContext();
			//get DataSoruce obj ref from jndi registry
			DataSource ds=(DataSource)ic.lookup("java:/comp/env/mypool");
			//get con obj from con pool
			Connection con=ds.getConnection();
			return con;
		}
		catch(Exception e){
			return null;
		}
		
	}//method

}
