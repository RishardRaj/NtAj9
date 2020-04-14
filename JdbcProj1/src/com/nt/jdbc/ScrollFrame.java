package com.nt.jdbc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ScrollFrame extends JFrame implements ActionListener {
	private JLabel lno,lname,ladd;
	private JTextField tno,tname,tadd;
	private JButton  bfirst,bnext,bprevious,blast;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	
	public ScrollFrame(){
		setTitle("Scrolling App");
		setSize(400,300);
		setLayout(new FlowLayout());
		
		lno=new JLabel("student no");
		add(lno);
		tno=new JTextField(10);
		add(tno);
		
		lname=new JLabel("student name");
		add(lname);
		tname=new JTextField(10);
		add(tname);
		
		ladd=new JLabel("student address");
		add(ladd);
		tadd=new JTextField(10);
		add(tadd);
		
		bfirst=new JButton("First");
		bfirst.addActionListener(this);
		add(bfirst);
		
		bnext=new JButton("Next");
		bnext.addActionListener(this);
		add(bnext);
		
		blast=new JButton("Last");
		blast.addActionListener(this);
		add(blast);
		
		bprevious=new JButton("Previous");
		bprevious.addActionListener(this);
		add(bprevious);
		
		setVisible(true);
		makeConnection();
	}//consturctor
	
	private void makeConnection(){
		try{
		//register driver 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//create Statement obj with type,mode
		st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				                                                              ResultSet.CONCUR_UPDATABLE);
		rs=st.executeQuery("select * from student");
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		
	}//makeConnection()
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try{
		System.out.println(ae.getActionCommand());
		boolean flag=false;
		if(ae.getSource()==bfirst){
			rs.first();
			flag=true;
		}
		else if(ae.getSource()==blast){
			rs.last();
			flag=true;
		}
		else if(ae.getSource()==bnext){
			if(!rs.isLast()){
				rs.next();
				flag=true;
			}
		}
		else{
			if(!rs.isFirst()){
				rs.previous();
				flag=true;
			}
		}
		//set the record values to text boxes
		if(flag==true){
			tno.setText(rs.getString(1));
			tname.setText(rs.getString(2));
			tadd.setText(rs.getString(3));
		}
		  
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
	}//actionPerfomed(-)
	
	public static void main(String[] args) {
		new ScrollFrame();
	}//main
}//class

