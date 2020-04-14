//Row3.java
import oracle.jdbc.rowset.*;
import java.sql.*;
import java.io.*;

public class WebRowSet {
  public static void main(String[] args)throws Exception
  {
	 //create WebRowSet obj
    OracleWebRowSet Wrs= new OracleWebRowSet();
    Wrs.setUsername("scott");                        
    Wrs.setPassword("tiger");                        
    Wrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
    Wrs.setCommand("SELECT * from student");
    Wrs.execute();
    
	// create Xml file
    FileWriter fw = new FileWriter("D:/student.xml");

    // converts WebRowSet obj Data to xml file content   
    Wrs.writeXml(fw);

	//close streams
	fw.close();
	Wrs.close();
     }//main
}//class
// this  App writes db table data to student.xml file.
//>javac Row3.java
//>java Row3