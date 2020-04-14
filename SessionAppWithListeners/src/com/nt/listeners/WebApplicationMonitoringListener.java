package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebApplicationMonitoringListener implements
		ServletContextListener {
   long start,end;
   
   public WebApplicationMonitoringListener(){
		System.out.println("ServletContext:0-param constructor");
	}

	
	// executes when SErvletContext obj is created
	public void contextInitialized(ServletContextEvent sce) {
       start=System.currentTimeMillis();
       //get ServletContext 
       ServletContext sc=sce.getServletContext();
       //write to log file
       sc.log(sc.getContextPath()+
    		   " is deployed/started/reloaded at"+new Date());
     }
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		end=System.currentTimeMillis();
		//get SErvletcontext
		ServletContext sc=sce.getServletContext();
	       //write to log file
		sc.log(sc.getContextPath()+" is stopped/undeployed at"+new Date()+
				"and it is in running mode for"+(end-start)+"  ms");
	}


}
