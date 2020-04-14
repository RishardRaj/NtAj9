package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

public class UplSrv1 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		try{
		//create Special request obj to hold uploaded files
		MultipartFormDataRequest mreq=new MultipartFormDataRequest(req);
		//perform uploading
		UploadBean upb=new UploadBean();
		upb.setFolderstore("c:/store");
		upb.setOverwrite(false);
	    upb.store(mreq); //completes file uploading
	   
	    // Display the details of uploaded files
	    pw.println("<h1> The Uploaded files are </h1><br>");
	    Hashtable<String,UploadFile> ht=mreq.getFiles();
	    Enumeration e=ht.elements();
	    while(e.hasMoreElements()){
	    	// Get each uploaded file
	    	UploadFile file=(UploadFile)e.nextElement();
	    	pw.println("<br>"+file.getFileName()+"----"+file.getFileSize());
	    }//while
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
	    //close strem
	    pw.close();
	}//doPost(-,-)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		  doPost(req,res);
	}//doGet(-,-)
}//class

