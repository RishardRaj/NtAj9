package com.nt.listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttrsMonitoringListener implements
		HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("AttrListener: attributeAdded(-)");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("AttrListener: attributeRemoved(-)");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("AttrListener: attributeReplaced(-)");

	}

}
