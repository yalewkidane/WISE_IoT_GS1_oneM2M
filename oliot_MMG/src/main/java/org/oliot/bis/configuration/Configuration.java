package org.oliot.bis.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.json.JSONException;
import org.json.JSONObject;

public class Configuration {

	public static Logger logger;
	public static JSONObject json;
	public static String epcis_ip;
	public static String epcis_port;
	public static String epcis_ip_mqtt;
	public static String epcis_port_mqtt;
	public static String oneM2M_ip;
	public static String oneM2M_port;
	public static String oneM2M_mqtt_port;
	
	public static String csebase="/Mobius"; //    /mobius-yt
	public static String mqtt_client_id="gs1_oneM2M_mmg";
	public static MqttClient client;
	
	public static MqttClient client_onem2m;
	public static String onem2m_mqtt_client_id="onem2m_mqtt_client";
	
	public static String aeName = "Mobius";  //Mobius  mobius-yt
	public static String appId = "BusInformationSystem";
	public static String busStopContainerName="busStop";
	public static String busLineContainerName="busLine";
	public static String busEstimationContainerName="busEstimation";
	
	public static boolean lock_capturer=false;
	
	public static int santandar_bus_Estimation=10;  //Maximum is 1470
	public static int busan_bus_Estimation=10;  //Maximum is 1
	
	public static String serviceKey_busan;
	
	public static int startIndex=0;
	public static int endIndex=0;
	
	public static  Map<String, List<String>> mapBusline_busStop = new LinkedHashMap<String, List<String>>();
	public static List<String> busLineList=new ArrayList<String>();

	public Configuration() {
		// Set Logger
		setLogger();

		// Set Basic Configuration with Configuration.json
		setBasicConfiguration();

	}

	private void setLogger() {
		// Log4j Setting
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.INFO);
		Configuration.logger = Logger.getRootLogger();
	}

	private void setBasicConfiguration() {
		//set the service Key 
		serviceKey_busan="OQX6Z00oyK1KwR40XLTdxvrSq90gpAsadkdL8Tgn48uArTQIBJzn7UnkUi%2FW7%2BD%2BwwEDyqkM%2Byo%2B2dm7iDocMA%3D%3D";
		
		ClassLoader classLoader = getClass().getClassLoader();
		String jsonString = "";
		try {
			jsonString = IOUtils.toString(classLoader.getResourceAsStream("resources/Configuration.json"));
			json = new JSONObject(jsonString);
			
			//epcis_ip
			String epcis_ip = json.getString("epcis_ip");
			if (epcis_ip != null) {
				Configuration.epcis_ip=epcis_ip;
			}
			
			//epcis_port
			String epcis_port = json.getString("epcis_port");
			if (epcis_port != null) {
				Configuration.epcis_port=epcis_port;
			}
			
			//epcis_ip_mqtt
			String epcis_ip_mqtt = json.getString("epcis_ip_mqtt");
			if (epcis_ip_mqtt != null) {
				Configuration.epcis_ip_mqtt=epcis_ip_mqtt;
			}
			
			//epcis_port_mqtt
			String epcis_port_mqtt = json.getString("epcis_port_mqtt");
			if (epcis_port_mqtt != null) {
				Configuration.epcis_port_mqtt=epcis_port_mqtt;
			}
			
			//oneM2M_ip
			String oneM2M_ip = json.getString("oneM2M_ip");
			if (oneM2M_ip != null) {
				Configuration.oneM2M_ip=oneM2M_ip;
			}
			
			//oneM2M_port
			String oneM2M_port = json.getString("oneM2M_port");
			if (oneM2M_port != null) {
				Configuration.oneM2M_port=oneM2M_port;
			}
			
			
		} catch (IOException | JSONException e) {

			e.printStackTrace();

		}
	}
}
