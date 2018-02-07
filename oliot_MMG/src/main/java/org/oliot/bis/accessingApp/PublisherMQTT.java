package org.oliot.bis.accessingApp;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.oliot.bis.configuration.Configuration;

public class PublisherMQTT {
	
	public void initialize() {
		

		try {
			String connString="tcp://"+Configuration.oneM2M_ip + ":" + Configuration.oneM2M_mqtt_port;
			String clientID=Configuration.onem2m_mqtt_client_id;
			
			System .out.println(connString);
			Configuration.client_onem2m = new MqttClient(connString, clientID);
			Configuration.client_onem2m.connect();
			
			
			MqttMessage message = new MqttMessage();
			String topic="/oneM2M/req/"+Configuration.appId+"/:"+Configuration.aeName+"/json";
			
			String appJson= CreatJSON.createApplication(Configuration.aeName, Configuration.appId);
			System.out.println(appJson);
			message.setPayload(appJson.getBytes());
			Configuration.client_onem2m.publish(topic, message);
			
//			String busStopContainerNameJson= CreatJSON.createContainer(Configuration.aeName, Configuration.appId, Configuration.busStopContainerName);
//			message.setPayload(busStopContainerNameJson.getBytes());
//			Configuration.client_onem2m.publish(topic, message);
//			System.out.println(busStopContainerNameJson);
//			
//			String busLineContainerNameJson= CreatJSON.createContainer(Configuration.aeName, Configuration.appId, Configuration.busLineContainerName);
//			message.setPayload(busLineContainerNameJson.getBytes());
//			Configuration.client_onem2m.publish(topic, message);
//			System.out.println(busLineContainerNameJson);
			
			String busEstimationContainerNameJson= CreatJSON.createContainer(Configuration.aeName, Configuration.appId, Configuration.busEstimationContainerName);
			message.setPayload(busEstimationContainerNameJson.getBytes());
			Configuration.client_onem2m.publish(topic, message);
			System.out.println(busEstimationContainerNameJson);
//			String busStopContainerNameJson= CreatJSON.createApplication(Configuration.appId, Configuration.busStopContainerName);
//			message.setPayload(busStopContainerNameJson.getBytes());
//			Configuration.client_onem2m.publish(topic, message);
			
			
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	
}
