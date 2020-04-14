package com.nt.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class PoolTest {
	public static void main(String[] args) throws Exception{
		 //create DataSoruce obj pointing Empty Con pool
		OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
		//provide details to create jdbc con pool
		ds.setDriverType("thin");
		ds.setUser("scott");
		ds.setPassword("tiger");
		ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setDatabaseName("xe");
		//get con obj from jdbc con pool
		Connection con=ds.getConnection();
		//create Statement obj
		Statement st=con.createStatement();
		//send and execute SQL Query in DB s/w
		ResultSet rs=st.executeQuery("select * from student");
		//process the ResultSet
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));
		}
		
		//close jdbc objs
		rs.close();
		st.close();
		con.close();
	}//main
}//class

