package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderSrv extends HttpServlet{

  public  void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
      //general settings
         PrintWriter pw=res.getWriter();
         res.setContentType("text/html");
      //header logic
      pw.println("<h1><marquee> H C L  Technologies </marquee></h1>");
       //do not close stream
    
       }
 public  void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
     doGet(req,res);
  }
}