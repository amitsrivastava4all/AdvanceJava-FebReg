package com.bmpl.talentfinder.users.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCheckListener
 *
 */
@WebListener
public class SessionCheckListener implements HttpSessionListener {
	private static int counter;
	
	public static int getCounter(){
		return counter;
	}
    /**
     * Default constructor. 
     */
    public SessionCheckListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	counter++;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	if(counter>0){
    	counter--;
    	}
         // TODO Auto-generated method stub
    }
	
}
