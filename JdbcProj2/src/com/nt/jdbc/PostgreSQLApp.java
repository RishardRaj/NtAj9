package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLApp {
	public static void main(String[] args)throws Exception {
		//register jdbc driver
		//Class.forName("org.postgresql.Driver");
		//establish the connection
		//Connection con=DriverManager.getConnection("jdbc:postgresql:MyDb1","postgres","tiger");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/MyDb1","postgres","tiger");
		//create Statement obj
		Statement st=con.createStatement();
		//send and execute SQL Query in DB s/w
		ResultSet rs=st.executeQuery("select * from  Student");
		//process the ResultSet
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		//close jdbc objs
		rs.close();
		st.close();
		con.close();
	}
}
