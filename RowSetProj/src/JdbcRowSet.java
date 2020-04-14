import oracle.jdbc.rowset.OracleJDBCRowSet;

//program on jdbc rowset 
public class JdbcRowSet 
	{
  public static void main (String []args)throws Exception
  {
	  OracleJDBCRowSet jrowset=new OracleJDBCRowSet();
	  jrowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	  jrowset.setUsername("scott");
	  jrowset.setPassword("tiger");
	  jrowset.setCommand("select * from student");
	  jrowset.execute();
	 
	  while(jrowset.next()){
		  System.out.println(jrowset.getInt(1)+"  "+jrowset.getString(2)+"  "+jrowset.getString(3));
	  }
	  
	  //insert operaiton
	  jrowset.moveToInsertRow();
	  jrowset.updateInt(1,1001);
	  jrowset.updateString(2,"rajesh");
	  jrowset.updateString(3,"hyd");
	  jrowset.insertRow();
	  
	  
	  //close jdbc obj
	  jrowset.close();
  }	  
}
