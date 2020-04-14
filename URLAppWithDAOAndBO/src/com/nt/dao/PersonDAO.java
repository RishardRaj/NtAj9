package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.nt.bo.PersonBO;

public class PersonDAO {
   private static final String INSERT_QRY="INSERT INTO INFO VALUES(?,?,?,?,?,?,?)";	

	
	public int insert(PersonBO  bo){
		//write jdbc code
		try{
		
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger");
				PreparedStatement pst=con.prepareStatement(INSERT_QRY);
				pst.setString(1,bo.getName());
				pst.setString(2,bo.getAddrs());
				pst.setString(3,bo.getAge());
				pst.setString(4,bo.getExp());
				pst.setString(5,bo.getSkill());
				pst.setString(6,bo.getCity());
				pst.setString(7,bo.getSal());

				int i = pst.executeUpdate();
				
				return i;
     		}//try
		catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}//insert
}//class
