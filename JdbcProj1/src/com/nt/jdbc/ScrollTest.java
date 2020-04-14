package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScrollTest {
	public static void main(String[] args)throws Exception {
		 //register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//Create PreparedStatement obj with type,mode
		PreparedStatement ps=con.prepareStatement("select * from student",
				                                                                                   ResultSet.TYPE_SCROLL_INSENSITIVE,
				                                                                                   ResultSet.CONCUR_UPDATABLE);
		//create ResultSet obj
		ResultSet rs=ps.executeQuery();
		//process the ResultSet
		System.out.println("Records (Top-Bottom)");
		while(rs.next()){
			System.out.println(rs.getRow()+":-->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		rs.afterLast();
		System.out.println("Records(Bottom-Top)");
		while(rs.previous()){
			System.out.println(rs.getRow()+":-->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		
		// Display the records randomly
		//first record
		rs.first();
		System.out.println(rs.getRow()+":-->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		//last record
		rs.last();
		System.out.println(rs.getRow()+":-->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		//3rd record
		rs.absolute(3);
		System.out.println(rs.getRow()+":-->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		//3rd record from bottom
		rs.absolute(-3);
		System.out.println(rs.getRow()+":-->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		//using relative(+/-n)
		rs.relative(2);
		System.out.println(rs.getRow()+":-->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		
		//2nd record
		rs.absolute(2);
		System.out.println(rs.getRow()+":-->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		
		//Using relative(+/-n)
		rs.relative(-1);
		System.out.println(rs.getRow()+":-->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		
		//close jdbc objs
		rs.close();
		ps.close();
		con.close();
	}//main
}//class

