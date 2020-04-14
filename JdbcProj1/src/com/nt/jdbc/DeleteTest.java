package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter stduent no:");
		int no=sc.nextInt();
		//register jdbc driver
		Class.forName("oracle.jdbc.OracleDriver");
		// establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		
		// create Statement obj
		Statement st=con.createStatement();
	
		//prepare Query
		    // delete from student where sno=901
		String qry="delete from student where sno="+no;
		System.out.println(qry);
		
		//send and execute SQL Query in DB s/w
		int result=st.executeUpdate(qry);
		//process the result
		if(result==0)
			System.out.println("Record not deleted");
		else
			System.out.println(result+" no.of records are deleted");
		//close jdbc objs 
		st.close();
		con.close();

	}//main
}//class

