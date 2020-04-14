package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest6 {
	public static void main(String[] args)throws Exception {
		//register jdbc driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		//create PreparedStatement obj
		PreparedStatement ps=con.prepareStatement("select * from emp where ?=?");
		ps.setString(1,"job");
		ps.setString(2,"CLERK");
		ResultSet rs=ps.executeQuery();
		
		//process the ResultSet
		boolean flag=false;
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(6));
			flag=true;
		}
		if(flag==false)
			System.out.println("Record not found");
		
		//close jdbc objs
		rs.close();
		ps.close();
		con.close();
	}//main
}//class


