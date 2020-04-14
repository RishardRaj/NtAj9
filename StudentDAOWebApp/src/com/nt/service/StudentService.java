package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentService {
	
	public String  generateResult(StudentDTO dto){
		// write B.logic
		int total=dto.getM1()+dto.getM2()+dto.getM3();
		float avg=total/3.0f;
		String result=null;
		if(avg<=35)
			result="fail";
		else
			result="pass";
		// prepare BO obj having persistent data
		StudentBO bo=new StudentBO(dto.getSno(),dto.getSname(),total,avg,result);
		
		//create Service class obj
		StudentDAO  dao=new StudentDAO();
		int status=dao.insert(bo);
		if(status==0)
			return "Student Registration Failed";
		else
			return  "Student Registration succeeded with no"+dto.getSno();
		
	}//generateResult(-)

}//class
