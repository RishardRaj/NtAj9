package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SensitiveTest {
	public static void main(String[] args) throws Exception{
		//register driver and establish the connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//create Senstive ResultSet
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				                                                             ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery("select sno,sname,sadd from student");
		//Process the ResultSet
		int cnt=0;
		while(rs.next()){
			if(cnt==1)
				Thread.sleep(30000);
			rs.refreshRow();
			
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			cnt++;
		}
		
		//close jdbc objs
		rs.close();
		st.close();
		con.close();
	}

}
