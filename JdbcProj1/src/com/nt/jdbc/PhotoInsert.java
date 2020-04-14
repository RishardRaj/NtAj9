package com.nt.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PhotoInsert {
  public static void main(String[] args)throws Exception {
	  
	/*  // register jdbc driver
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  //Establish the connection
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); */
	  
	  //register jdbc driver
	  Class.forName("com.mysql.jdbc.Driver");
	  //Establish the connection
	  Connection con=DriverManager.getConnection("jdbc:mysql:///NtAj11","root","root");
	  
	  //create PrepareStatement obj
	  PreparedStatement ps=con.prepareStatement("insert into empall values(?,?,?,?)");
	  // locate file
	  File f=new File("src/com/nt/jdbc/tips.gif");
	  InputStream is=new FileInputStream(f);
	  int length=(int)f.length();
	  //set Query param values
	  ps.setInt(1,1001);
	  ps.setString(2,"koala");
	  ps.setInt(3,9000);
	  ps.setBinaryStream(4,is, length);
	  // execute the Query
	  int res=ps.executeUpdate();
	  //process the result
	  if(res==0)
		  System.out.println("Record not inserted");
	  else
		  System.out.println("Record inserted");
	  //clsoe streams
	  ps.close();
	  con.close();
	}//main
}//class

