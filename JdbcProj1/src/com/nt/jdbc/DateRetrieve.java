package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class DateRetrieve {
	public static void main(String[] args)throws Exception {
		
 		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); 
    /*   Class.forName("com.mysql.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql:///NtAj11","root","root"); */
       
		//create Statement obj
		Statement st=con.createStatement();
		//Send and execute SQL Query in DB s/w
		ResultSet rs=st.executeQuery("select * from person_tab");
		//Process the ResultSet
		while(rs.next()){
			int no=rs.getInt(1);
			String name=rs.getString(2);
			java.sql.Date sqdob=rs.getDate(3);
			java.sql.Date sqdoj=rs.getDate(4);
			//convert Date values to String date values
			  //for DOB
			  java.util.Date udob=(java.util.Date)sqdob;
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MMM-dd");
			  String dob=sdf.format(udob);
			  //for DOJ
			  java.util.Date udoj=(java.util.Date)sqdoj;
			  String doj=sdf.format(udoj);
			  
			 System.out.println(no+"  "+name+"  "+dob+"  "+doj);
		   }//while
		
		//close jdbc objs
		rs.close();
		st.close();
		con.close();
	}//main
}//class

