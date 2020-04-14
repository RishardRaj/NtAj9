package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginApp {

  public static void main(String[] args)throws Exception {
	//read inputs
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter username");
	  String user=sc.nextLine(); //gives raja
	  System.out.println("Enter Password");
	  String pass=sc.nextLine(); //gives rani
	  
	
    
    // register jdbc driver and establish the connection
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
      
        //prepare SQL Query with params
      String qry="select count(*) from userlist where uname=? and pwd=?";
      PreparedStatement ps=con.prepareStatement(qry);
      
      //set input values to Query params
      ps.setString(1,user);
      ps.setString(2,pass);
      
       
       //send and execute SQL Query in DB s/w
       ResultSet rs=ps.executeQuery();
       
       //Process the ResultSet
       int cnt=0;
       if(rs.next()){
    	   cnt=rs.getInt(1);
       }
       
       if(cnt==0)
    	   System.out.println("InValid Credentials");
       else
    	  System.out.println("Valid Credentials");
       
       //close jdbc objs
       ps.close();
       rs.close();
       con.close();
	}//main
}//class

