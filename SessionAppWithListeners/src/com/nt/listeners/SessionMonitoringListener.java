package com.nt.listeners;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionMonitoringListener implements HttpSessionListener {
	  private long start,end;
	  
	  public SessionMonitoringListener(){
			System.out.println("SessionListener:0-param constructor");
		}
	
   //executes when HttpSession obj is created
	public void sessionCreated(HttpSessionEvent hse) {
      start=System.currentTimeMillis();
      //write to log
      hse.getSession().getServletContext()
           .log("Session obj is created at"+new Date());
	}
   //Executes when HttpSession obj is destroued/invalidated
	public void sessionDestroyed(HttpSessionEvent hse) {
		end=System.currentTimeMillis();
		//write to log
		hse.getSession().getServletContext().log("Session invalidated at "
		                     +new Date()+" and sessin duration is"+(end-start)+" ms");
	}

}//class
