package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CsTest4 {
	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter initial chars");
		String initchars=sc.next()+"%";
		
	  //register driver and establish the connection
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	  //create CallableStatement obj
	  CallableStatement cs=con.prepareCall("{call get_EmpDetails(?,?)}");
	  //register Out params with jdbc types
	  cs.registerOutParameter(2,OracleTypes.CURSOR);
	  // set values to IN params
	  cs.setString(1,initchars);
	  // call pl/sql procedure
	  cs.execute();
	  // Gather results
	  ResultSet rs=(ResultSet)cs.getObject(2);
	  //process the ResultSet
	   while(rs.next()){
		   System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));
	   }
	  //close jdbc objs
	   cs.close();
	   rs.close();
	   con.close();
	}//main
}//class

