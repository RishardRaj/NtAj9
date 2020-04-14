package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {
	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student no:");
		int no=sc.nextInt(); //gives 101
		System.out.println("Enter student name");
		String name=sc.next(); //gives ramesh
		System.out.println("Eneter student address");
		String addrs=sc.next(); //gives hyd
		//convert input values as required for SQL Query
		name="'"+name+"'"; //gives 'ramesh'
		addrs="'"+addrs+"'"; //gives 'hyd'
		
		//register jdbc driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		// establish the connection
		Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		// create Statement obj
		Statement st=con.createStatement();
		
		//prepare SQL Query
		  // insert into student values(101,'raja','hyd')
		String qry="insert into student values("+no+","+name+","+addrs+")";
		System.out.println(qry);
		
		//send and execute SQL Query  in DB s/w
		int cnt=st.executeUpdate(qry);
		
		//process the result
		if(cnt==0)
			System.out.println("Record not inserted");
		else
			System.out.println("Record inserted");
		
     //close jdbc objs
		st.close();
		con.close();
		
	}//main
}//class

