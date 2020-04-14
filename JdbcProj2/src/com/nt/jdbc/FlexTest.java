package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class FlexTest {
	public static void main(String[] args)throws Exception {
		//Locate properties file
		InputStream is=new FileInputStream("src/com/nt/commons/DBDetails.properties");
		//Load the content of properties file to java.util.Properties class obj
		Properties p=new Properties();
		p.load(is);
		//register jdbc driver
		Class.forName(p.getProperty("driver"));
		//Establish the connection
		Connection con=DriverManager.getConnection(p.getProperty("url"),
				                                                                                    p.getProperty("user"),
				                                                                                    p.getProperty("password"));
		//create Statement obj
		Statement st=con.createStatement();
		//Send and execute SQL Query in DB s/w
		ResultSet rs=st.executeQuery("select * from student");
		//process the ResultSet
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		//close jdbc objs
		rs.close();
		st.close();
		con.close();
	}//main
}//class

