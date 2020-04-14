package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

public class PsBatch {
  public static void main(String[] args)throws Exception {
	  //register driver and establish the connection
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
   //Create PreparedStatement obj
	  PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
	  
	  //set values to Query params through Batch Processing
	  ps.setInt(1,1001); ps.setString(2,"Rajesh"); ps.setString(3, "hyd");
	  ps.addBatch();
	  
	  ps.setInt(1,1002); ps.setString(2,"Ravi"); ps.setString(3, "vizag");
	  ps.addBatch();
	  
	  //execut the Batch
	  int res[]=ps.executeBatch();
	  
	  System.out.println("res[]="+Arrays.toString(res));
	  
  }
}
