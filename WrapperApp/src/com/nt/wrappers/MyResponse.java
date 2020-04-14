package com.nt.wrappers;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {
      private HttpServletResponse response;
      private CharArrayWriter charWriter;
      
	public MyResponse(HttpServletResponse response) {
		super(response);
		this.response=response;
		charWriter=new CharArrayWriter();
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		PrintWriter pw=new PrintWriter(charWriter);
		return pw;
	}
	
	@Override
	public String toString() {
	  return charWriter.toString();
	}

}
