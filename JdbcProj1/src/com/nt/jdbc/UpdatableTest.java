package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdatableTest {

	public static void main(String[] args)throws Exception {

		 //register jdbc driver and establish the connection
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		//create Updatable ResultSet
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				                                                              ResultSet.CONCUR_UPDATABLE);
		// execute the ResultSet
		ResultSet rs=st.executeQuery("select * from student");
		
		//process the ResultSet
		System.out.println("Records");
		while(rs.next()){
			System.out.println(rs.getInt(1)+"     "+rs.getString(2)+"     "+rs.getString(3));
		}
		
	/*	//To insert new record
		rs.moveToInsertRow();
		rs.updateInt(1,899);
		rs.updateString(2,"ramesh");
		rs.updateString(3,"hyd");
		rs.insertRow();
		System.out.println("Record inserted"); */
		
	/*	//To update the record
		rs.absolute(4);
		rs.updateString(3,"vizag");
		rs.updateRow(); */
		
	 //To delete record
		 rs.absolute(5);
		 rs.deleteRow();
		
		
		
		

	}

}
