//BatchProcessTest.java
package com.nt.jdbc;
import java.sql.*;

public class  BatchProcessTest
{
	public static void main(String args[])throws Exception
	{
          // establish the connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		// create Statement obj
		Statement st=con.createStatement();
		// disable autocommit on DB s/w
		con.setAutoCommit(false);
		// add non-select queries to Batch
		st.addBatch("insert into student values(161,'aaaaa','dddd')");
		st.addBatch("update student set sname='zzz8' where sno>=500");
		st.addBatch("delete from  student where sno=111");

       // send and execute the queries of Batch in db s/w 
		int result[]=st.executeBatch();
		
		boolean flag=false;
		for(int i=0;i<result.length;++i){
			if(result[i]==0){
				flag=true;
				break;
			}//if
		}//for
		if(flag==true){
			con.rollback();
			System.out.println("Tx rolledback");
		}
		else{
			con.commit();
			System.out.println("Tx committed");
		}
	

		//close jdbc objects
     st.close();
	 con.close();
	}//main
}//class

//>javac BatchProcessTest.java
//>java BatchProcess

