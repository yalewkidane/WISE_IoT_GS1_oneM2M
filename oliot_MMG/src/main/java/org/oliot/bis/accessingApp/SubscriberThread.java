package org.oliot.bis.accessingApp;

public class SubscriberThread extends Thread{
	
	public void run(){
		
		new Subscriber().subscribe();
	}

}
