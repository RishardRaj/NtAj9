package com.nt.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class PerformanceMonitoringReqListerner implements
		ServletRequestListener {
	
	public PerformanceMonitoringReqListerner(){
		System.out.println("ReqListener:0-param constructor");
	}
	
	long start,end;

	//executes when req obj is created 
	public void requestInitialized(ServletRequestEvent sre) {
		start=System.currentTimeMillis();
	}//method

	//execute when request obj is destroyed
	public void requestDestroyed(ServletRequestEvent sre) {
    end=System.currentTimeMillis();
    // get request obj
    HttpServletRequest req=(HttpServletRequest)sre.getServletRequest();
    //write to log file
    sre.getServletContext().log(req.getRequestURL()
    		                  +" has taken "+(end-start)+" ms to process request");
	}//method
}//class
