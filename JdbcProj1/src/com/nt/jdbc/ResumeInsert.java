package com.nt.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ResumeInsert {
	public static void main(String[] args)throws Exception
	{ //read input values
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter student no:");
	    int no=sc.nextInt();
	    System.out.println("Enter student name:");
	    String name=sc.next();
	    System.out.println("Enter Path of resume doc");
	    String resumePath=sc.next();
	    //create Char Stream pointing to resume doc
	    File file=new File(resumePath);
	    Reader reader=new FileReader(file);
	    int length=(int)file.length();
	    
	   // register jdbc driver
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	   //Establish the connection
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger");
	   //PreparedStatement obj
	   PreparedStatement ps=con.prepareStatement("insert into studentDetails values(?,?,?)");
	   //set values to query params
	   ps.setInt(1,no);
	   ps.setString(2,name);
	   ps.setCharacterStream(3,reader,length);
	   //execute the Query
	   int result=ps.executeUpdate();
	   
	   if(result==0){
		   System.out.println("Record not inserted");
	   }
	   else{
		   System.out.println("Record inserted");
	   }
		   
	   //close streams
	   reader.close();
	   ps.close();
	   con.close();
		
	}//main
}//class

