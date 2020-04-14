package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args){
		Connection con=null;
		Statement st=null;
		Scanner sc=null;
		try{
		 //read inputs
		 sc=new Scanner(System.in);
		 int no=0;
		 String newname=null,newaddrs=null;
		 if(sc!=null){
			 System.out.println("Enter student no");
			 no=sc.nextInt();
			 System.out.println("Enter student name");
			 newname=sc.next(); //raja
			 System.out.println("Enter student address");
			 newaddrs=sc.next(); //gives hyd
		 }
		 //Convert input values as required for SQL Query
		 newname="'"+newname+"'"; //gives 'raja'
		 newaddrs="'"+newaddrs+"'";// gives 'hyd'
		 
		 //register jdbc driver
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 //Establish the connection
		 con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		 //create Statement obj
		 if(con!=null)
			 st=con.createStatement();
		 //prepare SQL Query
		    // update student set sname='raja',sadd='vizag' where sno=101
		  String qry="update student set sname="+newname+",sadd="+newaddrs+" where sno="+no;
		  System.out.println(qry);
		  //send and execute SQL Query in DB s/w
		  int cnt=0;
		  if(st!=null)
			 cnt=st.executeUpdate(qry);
		  //Process the Result
		  if(cnt==0)
			  System.out.println("Record not found for updation");
		  else
			  System.out.println(cnt+"no.of Record(s) updated");
		 
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
			 if(sc!=null)
				 sc.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			try{
			 if(st!=null)
				st.close();
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

