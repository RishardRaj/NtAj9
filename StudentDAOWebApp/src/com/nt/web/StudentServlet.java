package com.nt.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

public class StudentServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		int no=Integer.parseInt(req.getParameter("sno"));
		String name=req.getParameter("sname");
		int m1=Integer.parseInt(req.getParameter("m1"));
		int m2=Integer.parseInt(req.getParameter("m2"));
		int m3=Integer.parseInt(req.getParameter("m3"));
		//create VO class obj
		StudentVO vo=new StudentVO(no,name,m1,m2,m3);
		//Convert VO class obj to DTO class obj
		StudentDTO dto=new StudentDTO(vo.getSno(),
				                                                            vo.getSname(),
				                                                            vo.getM1(),
				                                                            vo.getM2(),
				                                                            vo.getM3());
		// use SErvie class b.logic
		 StudentService service=new StudentService();
		 String result=service.generateResult(dto);
		// Present the result
		 pw.println("<h2> Student Result is"+result);
		 
		 //close stream
		 pw.close();
	}//doGet(-,-)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class

