package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySqlTest {

	public static void main(String[] args)throws Exception {
	   //register jdbc driver
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("org.gjt.mm.mysql.Driver");
	   //Establis the connection
		//Connection con=DriverManager.getConnection("jdbc:mysql:///NtAj11","root","root");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NtAj11","root","root");
		//create PrepareStatement
		PreparedStatement ps=con.prepareStatement("select * from student");
		//execute the Query
		ResultSet rs=ps.executeQuery();
		//process the ResultSet
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		//close jdbc objs
		rs.close();
		ps.close();
		con.close();

	}//main
}//class

