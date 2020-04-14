package com.nt.jdbc;

import java.sql.*;
import java.util.*;

public class CsTest2 {
  public static void main(String[] args)throws Exception {
	 //read inputs
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter emp no:");
	  int no=sc.nextInt();
	  
	  //register driver and establish the connection
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	  
	  //create CallableStatement obj
	  CallableStatement cs=con.prepareCall("{ call get_EmpDetails(?,?,?)}");
	  // register OUT params with jdbc types
	  cs.registerOutParameter(2,Types.VARCHAR);
	  cs.registerOutParameter(3,Types.FLOAT);
	  // set values to IN param
	    cs.setInt(1,no);
	  // call pl/sql procedure
	  cs.execute();
	  // Gather  results from OUT params
	  System.out.println("Name:"+cs.getString(2)+" Salary:"+cs.getFloat(3));
	  //close jdbc objs
	  cs.close();
	  con.close();
  }//main
}//class

