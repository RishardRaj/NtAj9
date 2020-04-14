package com.nt.jdbc;

import java.sql.*;
import java.util.*;

public class CsTest1 {
  public static void main(String[] args)throws Exception {
	 //read inputs
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter value1:");
	  int val1=sc.nextInt();
	  System.out.println("Enter Value2:");
	  int val2=sc.nextInt();
	  //register driver and establish the connection
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	  //create CallableStatement obj
	  CallableStatement cs=con.prepareCall("{ call first_pro(?,?,?)}");
	  // register OUT params with jdbc types
	  cs.registerOutParameter(3,Types.INTEGER);
	  // set values to IN param
	  cs.setInt(1,val1);
	  cs.setInt(2,val2);
	  // call pl/sql procedure
	  cs.execute();
	  //gaher result from OUT param
	  System.out.println("sum "+cs.getInt(3));
	  //close jdbc objs
	  cs.close();
	  con.close();
  }//main
}//class

