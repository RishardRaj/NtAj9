package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlToOracleTest {

	public static void main(String[] args)throws Exception {
      //register jdbc drivers
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Class.forName("com.mysql.jdbc.Driver");
	   // Establish connections
	   Connection oracon=
		    DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	   Connection mysqlcon=
			DriverManager.getConnection("jdbc:mysql:///NtAj11","root","root");
	   // Create jdbc Statement objs
	   Statement  st=mysqlcon.createStatement();
	   PreparedStatement ps=
		  oracon.prepareStatement("insert into student values(?,?,?)");
	   // send and execute SQL query in mysql
	   ResultSet rs=st.executeQuery("select * from student");
	   // copy records from mysql table to oracle table
	   while(rs.next()){
		   //get each record from mysql db table
		   int no=rs.getInt(1);
		   String name=rs.getString(2);
		   String addrs=rs.getString(3);
		   //write each record to oracle db table
		   ps.setInt(1,no);
		   ps.setString(2,name);
		   ps.setString(3,addrs);
		   ps.executeUpdate();
	   }//while
	   System.out.println("Records are copied");
	   //close jdbc objs
	   rs.close();
	   st.close();
	   ps.close();
	   oracon.close();
	   mysqlcon.close();
	}//main
}//class

