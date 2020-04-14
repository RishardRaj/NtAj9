package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAO {
	private static final String  STUDENT_INSERT_QRY="INSERT INTO STUDENT_TAB VALUES(?,?,?,?,?)";

	public int insert(StudentBO bo){
		try{
		//get the con obj from jdbc con pool
			InitialContext ic=new InitialContext();
		// get DataSoruce obj ref from jndi registry
			DataSource ds=(DataSource)ic.lookup("DsJndi");
		//get con obj from jdbc con pool
			Connection con=ds.getConnection();
		//create PreparedStatement obj
			PreparedStatement ps=con.prepareStatement(STUDENT_INSERT_QRY);
			ps.setInt(1,bo.getSno());
			ps.setString(2,bo.getSname());
			ps.setInt(3,bo.getTotal());
			ps.setFloat(4,bo.getAvg());
			ps.setString(5,bo.getResult());
		//Execute the Query
		int result=ps.executeUpdate();
		return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}//insert

}//class
