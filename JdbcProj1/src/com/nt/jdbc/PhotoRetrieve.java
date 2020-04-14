package com.nt.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PhotoRetrieve {
	public static void main(String[] args)throws Exception {
	  //register jdbc driver
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  //Establish the connection
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	  //create Statement obj
	  Statement st=con.createStatement();
	  //execute the SQL Query
	  ResultSet rs=st.executeQuery("select * from empall");
	  //Retrieve impage
	   InputStream is=null;
	   if(rs.next()){
		   is=rs.getBinaryStream(4);
	   }
	   
	   // create OutputStream pointing to Dest file
	   OutputStream os=new FileOutputStream("newpict.jpg");
	   
	   // store the Image into Dest file
	   byte []buffer=new byte[4096];
	   int bytesRead=0;
	   while((bytesRead=is.read(buffer))!=-1){
		   os.write(buffer,0,bytesRead);
	   }//while
	   
	   System.out.println("Image is retrieved");
	   
	   //close stream
	   is.close();
	   st.close();
	   con.close();
	}//main
}//class

