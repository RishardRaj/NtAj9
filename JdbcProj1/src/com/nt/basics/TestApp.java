package com.nt.basics;

import java.text.SimpleDateFormat;

public class TestApp {

	public static void main(String[] args)throws Exception {
	
	//Converting String date value to java.util.Date class obj
 	 String s1="20-43-1989"; //gives MM-dd-yyyy
     SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
     java.util.Date ud1=sdf.parse(s1);
     System.out.println(ud1);
    
     //Converting java.util.Date class obj java.sql.Date class obj
     long ms=ud1.getTime();
     java.sql.Date sqd=new java.sql.Date(ms);
     System.out.println(sqd);
     
     /*if the given String date value is there in
       yyyy-MM-dd pattern then it can be converted 
       directly to java.sql.Date class obj wiht out
       converting it to java.util.Date obj
      */
     String s2="1947-8-15"; //yyyy-MM-dd
     java.sql.Date sqd1=java.sql.Date.valueOf(s2);
     System.out.println(sqd1);
     
     //Convering java.sql.Date  obj to java.util.Date obj
     java.util.Date ud2=(java.util.Date)sqd1;
     System.out.println("util date"+ud2);
     
     //Converting java.util.Date obj to String date value
     SimpleDateFormat sdf2=new SimpleDateFormat("MMM-yyyy-dd");
     String s3=sdf2.format(ud2);
     System.out.println(s3);
     
     
     
     
	

	}

}
