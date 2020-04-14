//program on cached rowset
//Row1.java
import oracle.jdbc.rowset.OracleCachedRowSet;
public class CacheRowSet 
{
  public static void main (String []args)throws Exception
  {
	  //create RowSet obj
	OracleCachedRowSet  crowset= new OracleCachedRowSet();

      crowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
      crowset.setUsername("scott");
      crowset.setPassword("tiger");
      crowset.setCommand("select   sno,sname,sadd  from student");
      crowset.execute();//executes Query
      System.out.println("stop DB....");
     Thread.sleep(30000);
	  
      System.out.println("query executed");
	  while (crowset.next())
      {
         System.out.println (crowset.getInt(1)+"  "+crowset.getString(2)+"  "+crowset.getString(3) );
       }
	  
	  crowset.setReadOnly(false);
	  //Insert operation
	    crowset.moveToInsertRow();
	  crowset.updateInt(1,801);
	  crowset.updateString(2,"ramesh");
	  crowset.updateString(3,"hyd");
	  crowset.insertRow();
	  System.out.println("Start DB...");
	  Thread.sleep(30000);
	  crowset.acceptChanges();
	  

	  
	  

	
	  crowset.close();
  }	 //main 
}//class
