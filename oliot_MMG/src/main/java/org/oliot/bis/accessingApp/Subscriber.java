package org.oliot.bis.accessingApp;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.oliot.bis.configuration.Configuration;
/*
 * Subscribes to EPCIS to get bus information data
 */
public class Subscriber implements MqttCallback  {
	
	

	public void subscribe() {
		try {
			
			String connString="tcp://"+Configuration.epcis_ip_mqtt + ":" + Configuration.epcis_port_mqtt;
			String clientID=Configuration.mqtt_client_id;
			
			System .out.println(connString);

			Configuration.client = new MqttClient(connString, clientID);
			Configuration.client.connect();
			Configuration.client.setCallback(this);
			Configuration.client.subscribe("/epcis/#");
			
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Messegae arrived");
		long startTime = System.currentTimeMillis();
		System.out.println(topic);
		if(topic.equals("/epcis/Service/EventCapture")) {
			Configuration.lock_capturer=true;
			System.out.println("lock_capturer turned on ");
			new ResultTranslator().translate(message.toString());
			System.out.println("lock_capturer turned off ");
			Configuration.lock_capturer=false;
		}else {
			System.out.println(message);
		}
		System.out.println((System.currentTimeMillis()-startTime)/1000);
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
