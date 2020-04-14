package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class TxMgmtTest {
	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Source Account no:");
		int srcNo=sc.nextInt();
		System.out.println("Enter Dest Account no:");
		int destNo=sc.nextInt();
		System.out.println("Enter Amount to transfer");
		int amt=sc.nextInt();
		
		//register driver and establish the connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		
		//create Statement obj 
		Statement st=con.createStatement();
		//Begin Tx (Disable auto commit mode on DB s/w)
		con.setAutoCommit(false);
		//Prepare Batch
		   //for withdraw operation
		st.addBatch("update jdbc_account set balance=balance-"+amt+" where accno="+srcNo);
		  //for Deposite operation
		st.addBatch("update jdbc_account set balance=balance+"+amt+" where accno="+destNo);
		
		//execute the Batch
		int result[]=st.executeBatch();
		
		//Perform Tx mgmt
		boolean flag=false;
		  for(int i=0;i<result.length;++i){
			  if(result[i]==0){
				  flag=true;
				  break;
			  }//if
		  }//for
		  
		  if(flag==false){
			  con.commit();
			  System.out.println("Tx committed (Money Transfered)");
		  }
		  else{
			  con.rollback();
			  System.out.println("Tx rolledback (Money not Transfered)");
		  }
		  
		  //close jdbc objs
		  st.close();
		  con.close();
	}//main
}//class
