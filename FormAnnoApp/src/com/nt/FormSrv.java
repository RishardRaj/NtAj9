package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/furl","/surl"},name="form",loadOnStartup=1,
                            initParams={@WebInitParam(name="email",value="x@y.com"),
		                                             @WebInitParam(name="msg",value="hello")                                      
                                                    })
public class FormSrv extends HttpServlet {
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		String name=req.getParameter("name");
		pw.println("Given Name"+name);
		//get Servletconfig obj
		ServletConfig cg=getServletConfig();
		System.out.println(cg.getInitParameter("email")+"  "+cg.getInitParameter("msg"));
		System.out.println(cg.getServletName());
	}//doGet(-,-)

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

}//class
