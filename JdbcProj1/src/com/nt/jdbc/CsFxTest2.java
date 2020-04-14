package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

public class CsFxTest2 {
	public static void main(String[] args)throws Exception {
      //read input values
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student no:");
		int no=sc.nextInt();
		
     // register driver and establish the connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	 //create CallableStatement obj
		CallableStatement cs=con.prepareCall("{?=call select_delete_student(?,?)}");
		//register OUT params with jdbc types
		cs.registerOutParameter(1,OracleTypes.CURSOR);
		cs.registerOutParameter(3,Types.INTEGER);
		//set value to IN param
		cs.setInt(2,no);
		// call pl/sql function
		cs.execute();
		//gather results from pl/sql function
		ResultSet rs=(ResultSet)cs.getObject(1);//return param
		System.out.println("Student details");
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
		}
		
		int cnt=cs.getInt(3);
		if(cnt==0)
			System.out.println("Record not deleted");
		else
			System.out.println("Record deleted");
		
		//close jdbc objs
		rs.close();
		cs.close();
		con.close();
	}//main
}//class

