package com.nt.jdbc;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ResumeRetrieve {
	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student no:");
		int no=sc.nextInt();
	   // register jdbc driver
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	   //Establish the connection
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger");
	   //create ParepareStaement obj
	   PreparedStatement ps=con.prepareStatement("select * from StudentDetails where sno=?");
	   ps.setInt(1,no);
	   //execute the Query
	   ResultSet rs=ps.executeQuery();
	   //process the ResultSet
	   Reader reader=null;
	   if(rs.next()){
		  System.out.println(rs.getInt(1)+" "+rs.getString(2));
		  reader=rs.getCharacterStream(3);
	   }
	   else{
		   System.out.println("Record not found");
	   }
	   //Create Stream pointing to Dest file
	   Writer writer=new FileWriter("newResume.txt");
	   //write buffer based logic to strore retrieved
	   // resume in dest file.
	   char buffer[]=new char[2048];
	   int charsRead=0;
	   while((charsRead=reader.read(buffer))!=-1){
		   writer.write(buffer,0,charsRead);
	   }
	   System.out.println("Text Doc is retrieved");
	   
	   //close streams
	   reader.close();
	   writer.close();
	   ps.close();
	   con.close();
	}//main
}//class

