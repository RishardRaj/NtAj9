package com.nt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AuthFilter implements Filter {
	 ServletContext sc;
	 FilterConfig fg;
	@Override
	public void init(FilterConfig fg) throws ServletException {
      this.fg=fg;
      sc=fg.getServletContext();
	}
	


	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException {
		//read form data
		String user=req.getParameter("user");
		String pass=req.getParameter("pwd");
		//type casting
		HttpServletRequest hreq=(HttpServletRequest)req;
		//writer Authentication lgoic
		try{
			Class.forName(fg.getInitParameter("driver"));
			Connection con=DriverManager.getConnection(fg.getInitParameter("url"),
					                                                                                      fg.getInitParameter("dbuser"),
					                                                                                      fg.getInitParameter("dbpwd"));
			PreparedStatement ps=con.prepareStatement("select count(*) from userlist where uname=? and pwd=?");
			ps.setString(1, user);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			int cnt=0;
			if(rs.next()){
				cnt=rs.getInt(1);
			}
			if(cnt==0){
				sc.log(hreq.getRequestURI()+" Authentication failed");
				RequestDispatcher rd=req.getRequestDispatcher("/one.html");
				
				rd.forward(req,res);
				return;
			}
			else{
				sc.log(hreq.getRequestURI()+"  Authentication succeded");
				System.out.println("AuthFilter: before fc.doFilter(-,-)");
				fc.doFilter(req,res);
				System.out.println("AuthFilter: after fc.doFilter(-,-)");
			}
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		
	}

}
