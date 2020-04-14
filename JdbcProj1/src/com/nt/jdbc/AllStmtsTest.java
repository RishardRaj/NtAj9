package com.nt.jdbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AllStmtsTest extends JFrame implements ActionListener {
	private JLabel lno,lname,lm1,lm2,lm3,lres;
	private JTextField tname,tm1,tm2,tm3,tres;
	private JButton details,result;
	private JComboBox cb;
	private Connection con;
	private Statement st;
	private PreparedStatement ps;
	private CallableStatement cs;
    private ResultSet rs1,rs2;
	
	public AllStmtsTest(){
		System.out.println("AllStmtsTest: 0-param constructor");
		setSize(200,200);
		setLayout(new FlowLayout());
		setTitle("GUI Front End");
		setBackground(Color.GRAY);
		
		lno=new JLabel("Sno");
		add(lno);
		cb=new JComboBox();
		add(cb);
		
		details=new JButton("details");
		details.addActionListener(this);
		add(details);
		
		lname=new JLabel("name");
		add(lname);
		tname=new JTextField(10);
		add(tname);
		
		lm1=new JLabel("Marks1");
		add(lm1);
		tm1=new JTextField(10);
		add(tm1);
		
		lm2=new JLabel("Mark2");
		add(lm2);
		tm2=new JTextField(10);
		add(tm2);
		
		lm3=new JLabel("Mark3");
		add(lm3);
		tm3=new JTextField(10);
		add(tm3);
		
		result=new JButton("result");
		result.addActionListener(this);
		add(result);
		
		lres=new JLabel("Result");
		add(lres);
		tres=new JTextField(10);
		add(tres);
		
		setVisible(true);
		init();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void init(){
		System.out.println("AllStmtsTEst:init()");
		//write jdbc code
	 try{
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
      //write application startup logic(placing sno numbers in combo Box)
      st=con.createStatement();
      rs1=st.executeQuery("select sno from All_student");
      while(rs1.next()){
    	  cb.addItem(rs1.getString(1));
      }
      rs1.close();
      st.close();
      //create PrpearedStatement obj
      ps=con.prepareStatement("select * from All_student where sno=?");
      //create CallableStatement obj
      cs=con.prepareCall("{call FIND_PASS_FAIL(?,?,?,?)}");
      cs.registerOutParameter(4,Types.VARCHAR);
	 }//try
	 catch(Exception e){
		 e.printStackTrace();
	 }
	}//init
		
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("AllStmts:actionPeromed(-)");
	try{	
	  if(ae.getSource()==details){
		  System.out.println("Details btn is clicked");
		//read seleced item from combo Box
		int no=Integer.parseInt((String)cb.getSelectedItem());
		// set the above number as query param valye
		ps.setInt(1,no);
		// execute the query
		rs2=ps.executeQuery();
		
		if(rs2.next()){
		 tname.setText(rs2.getString(2));
		 tm1.setText(rs2.getString(3));
		 tm2.setText(rs2.getString(4));
		 tm3.setText(rs2.getString(5));
		}
		
	  }//if
	  else{
		  System.out.println("Result Btn is clicked");
       // Gather m1,m2,m3 values from text boxes
		  int m1=Integer.parseInt(tm1.getText());
		  int m2=Integer.parseInt(tm2.getText());
		  int m3=Integer.parseInt(tm3.getText());
		  //set above values as IN Param values
		  cs.setInt(1,m1);
		  cs.setInt(2,m2);
		  cs.setInt(3,m3);
		  //call pl/sql procedure
		  cs.execute();
		  //gather result from OUT param
		  String result=cs.getString(4);
		  // place result in text box
		  tres.setText(result);
	     }//else
	   }//try
	  catch(Exception e){
		  e.printStackTrace();
	  }
	}//actionPermethod
	
	public void finalize(){
		//close jdbc objs
		System.out.println("AllStmtsTest:finalize()");
		try{
          if(rs1!=null)
        	  rs1.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		try{
	          if(st!=null)
		        	st.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
		try{
	          if(rs2!=null)
	        	  rs2.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		try{
          if(ps!=null)
	         ps.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	
		try{
          if(cs!=null)
	        	  cs.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		try{
          if(con!=null)
	        	con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}//finalize()
	
	public static void main(String[] args) {
		System.out.println("Main(-)");
		new AllStmtsTest();
		System.runFinalizersOnExit(true);
		
	}//main
}//class
	
