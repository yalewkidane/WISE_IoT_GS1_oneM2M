package org.oliot.bis.accessingApp;

import org.oliot.bis.configuration.Configuration;

public class PublisherREST {
public void initialize() {
		
		try {
			
			System.out.println("[ID-AE] AE Create request : " + Configuration.aeName);
			RestPublisherUtility.aeRegistrationMessage(Configuration.aeName, Configuration.appId);
			
			
			System.out.println("[ID-AE] AE busStop container Create request" + Configuration.busStopContainerName);
			RestPublisherUtility.containerCreateMessage(Configuration.appId, Configuration.busStopContainerName);
			
			System.out.println("[ID-AE] AE busStop container Create request" + Configuration.busLineContainerName);
			RestPublisherUtility.containerCreateMessage(Configuration.appId, Configuration.busLineContainerName);
			
			System.out.println("[ID-AE] AE busStop container Create request" + Configuration.busEstimationContainerName);
			RestPublisherUtility.containerCreateMessage(Configuration.appId, Configuration.busEstimationContainerName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void createContainerID(String serviceType, String containerID) {
		if(serviceType.equals("busStop")) {
			try {
				System.out.println("[ID-AE] AE container Create request" + Configuration.busStopContainerName+"/"+containerID);
				RestPublisherUtility.containerCreateMessage(Configuration.appId, Configuration.busStopContainerName+"/"+containerID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(serviceType.equals("busLine")) {
			try {
				System.out.println("[ID-AE] AE container Create request" + Configuration.busLineContainerName+"/"+containerID);
				RestPublisherUtility.containerCreateMessage(Configuration.appId, Configuration.busLineContainerName+"/"+containerID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(serviceType.equals("busEstimation")) {
			try {
				System.out.println("[ID-AE] AE container Create request" + Configuration.busEstimationContainerName+"/"+containerID);
				RestPublisherUtility.containerCreateMessage(Configuration.appId, Configuration.busEstimationContainerName+"/"+containerID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void createContentInstant(String serviceType, String containerID, String content) {
		if(serviceType.equals("busStop")) {
			try {
				System.out.println("[ID-AE] AE_busStop Content Instant created @  :  " + Configuration.busStopContainerName+"/"+containerID);
				RestPublisherUtility.contentInstanceCreateMessage(Configuration.appId, Configuration.busStopContainerName+"/"+containerID, content, "busStop");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(serviceType.equals("busLine")) {
			try {
				System.out.println("[ID-AE] AE_busLine Content Instant created @  :  " + Configuration.busLineContainerName+"/"+containerID);
				RestPublisherUtility.contentInstanceCreateMessage(Configuration.appId, Configuration.busLineContainerName+"/"+containerID, content, "busLine");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(serviceType.equals("busEstimation")) {
			try {
				System.out.println("[ID-AE] AE_busEstimation Content Instant created @  :  " + Configuration.busEstimationContainerName+"/"+containerID);
				RestPublisherUtility.contentInstanceCreateMessage(Configuration.appId, Configuration.busEstimationContainerName+"/"+containerID, content, "busEstimation");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
