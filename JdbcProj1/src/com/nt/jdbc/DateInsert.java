package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsert {
	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter person no:");
		int no=sc.nextInt();
		System.out.println("Enter person name:");
		String name=sc.next();
		System.out.println("Enter DOB(dd-MM-yyyy)");
		String dob=sc.next();
		System.out.println("Enter DOJ(yyyy-MM-dd");
		String doj=sc.next();
		
		//Convert String date values to java.sql.Date class obj
		  //for DOB
		    SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
		    java.util.Date udob=sdf1.parse(dob);
		    long ms=udob.getTime();
		    java.sql.Date sqdob=new java.sql.Date(ms);
         //for DOJ
		    java.sql.Date sqdoj=java.sql.Date.valueOf(doj);
		    
	/*	//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); */

		Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///NtAj11","root","root"); 
		    
		    
		//create PreparedStatement obj
		PreparedStatement ps=con.prepareStatement("insert into person_tab values(?,?,?,?)");
		ps.setInt(1,no);
		ps.setString(2,name);
		ps.setDate(3,sqdob);
		ps.setDate(4,sqdoj);
		// execute the Query
		int result=ps.executeUpdate();
		//process the result
		if(result==0)
			System.out.println("Record not inserted");
		else
			System.out.println("Record inserted");
		
		//close jdbc objs
		ps.close();
		con.close();
	}//main
 }//class

