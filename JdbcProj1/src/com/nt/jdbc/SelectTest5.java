package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest5 {
	public static void main(String[] args)throws Exception
	{
		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	
		//create PreparedStatement obj
		PreparedStatement ps=con.prepareStatement(null);
		
		//send and execute SQL Query in DB s/w
		ResultSet rs=ps.executeQuery("select * from emp");
		
		//Process the ResultSet
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));
		}
		
		
		
       //close jdbc objs
		rs.close();
		ps.close();
		con.close();
	}//main
 }//class

