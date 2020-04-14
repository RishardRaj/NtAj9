package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsTest3 {
	
	public static void main(String[] args){
		Scanner sc=null;
		Connection con=null;
		CallableStatement cs=null;
      try{
    	//read inputs
    	 sc=new Scanner(System.in);
    	 String user=null,pwd=null;
    	 if(sc!=null){
    		System.out.println("Enter username:");
    		user=sc.nextLine();
    		System.out.println("Enter password:");
    		pwd=sc.nextLine();
    	 }
    	 //register driver
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 //establish the connection
    	 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
    	 //create CallableStatement obj
    	  if(con!=null)
    	  cs=con.prepareCall("{ call Auth_pro(?,?,?)}");
    	  if(cs!=null){
    	 //register out params with jdbc types
    	  cs.registerOutParameter(3,Types.VARCHAR);
    	 //set values to IN params
    	  cs.setString(1,user);
    	  cs.setString(2,pwd);
    	 // call pl/sql procedure
    	  cs.execute();
    	 //gather results 
    	  String result=cs.getString(3);
    	  System.out.println(result);
    	   }//if
    	  }//try
    	  catch(ClassNotFoundException cnf){
    		  cnf.printStackTrace();
    	  }
    	  catch(SQLException se){
    		  se.printStackTrace();
    	  }
    	  catch(Exception e){
    		  e.printStackTrace();
    	  }
	    finally{
	    	//close jdbc objs
	    	try{
	    		if(cs!=null)
	    			cs.close();
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	try{
	    		if(con!=null)
	    			con.close();
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
	    }//finally
	}//main
 }//class

