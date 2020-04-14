package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RsmdTest {
	public static void main(String[] args)throws Exception
	{
		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		
		//create Staement obj
		Statement st=con.createStatement();
		//Send and execute SQL Query in DB s/w
		ResultSet rs=st.executeQuery("select * from "+args[0]);
		//create ResultSetMetaData
		ResultSetMetaData rsmd=rs.getMetaData();
		//get Column count
		int cnt=rsmd.getColumnCount();
		//Display col names
		for(int i=1;i<=cnt;++i){
			System.out.print(rsmd.getColumnLabel(i)+"("+rsmd.getColumnTypeName(i)+")   ");
		}
		System.out.println();
		
		
		//Process the ResultSet 
		while(rs.next()){
			for(int i=1;i<=cnt;++i){
			  System.out.print(rs.getString(i)+"\t\t\t\t\t");
			}
			System.out.println();
		}
		
	
		
       //close jdbc objs
		rs.close();
		st.close();
		con.close();
	}//main
 }//class

