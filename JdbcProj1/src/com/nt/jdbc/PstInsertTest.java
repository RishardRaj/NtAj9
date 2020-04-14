package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PstInsertTest {
	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter students count");
		int cnt=sc.nextInt();
		
		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//prepare SQL Query with params
		String qry="insert into student values(?,?,?)";
		//create PeparedStatement obj
		PreparedStatement ps=con.prepareStatement(qry);
		//read student details from enduser
		for(int i=1;i<=cnt;++i){
			//read each student details
			System.out.println("Enter "+i+" student details");
			System.out.println("Number:");
			int no=sc.nextInt();
			System.out.println("Name:");
			String name=sc.next();
			System.out.println("Address:");
			String addrs=sc.next();
			// set each student details to query params
			ps.setInt(1,no);
			ps.setString(2,name);
			ps.setString(3,addrs);
			// execute the Query
			int result=ps.executeUpdate();
			//process the result
			if(result==0)
				System.out.println(i+" student details are not inserted");
			else
				System.out.println(i+" student details are inserted");
		  }//for
		 
		//close jdbc objs
		    ps.close();
		    con.close();
		}//main
		
	}//class
