package org.oliot.bis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import org.json.JSONException;
import org.json.JSONObject;
import org.oliot.bis.accessingApp.PublisherMQTT;
import org.oliot.bis.accessingApp.PublisherREST;
import org.oliot.bis.accessingApp.SubscriberThread;
import org.oliot.bis.capturingApp.CaptureBusLine;
import org.oliot.bis.capturingApp.CaptureBusStop;
import org.oliot.bis.capturingApp.EventCapturer;
import org.oliot.bis.configuration.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BISCapture {
	
	private Timer timer;
	public static String count="0";
	
	
	/*
	 * /BIS/CaptureMasterData
	 * city=busan/santander
	 * type=busStop/busLine
	 */
	@ResponseBody
	@RequestMapping(value = "/BIS", method = RequestMethod.GET)
    public String index() {
        return "List of services: [/BIS/CaptureMasterData] \n "
        		+ "/BIS/CaptureMasterData?city=&type=  \n  "
        		+ "city=busan/santander	\n type=busStop/busLine";
    }
	
	@ResponseBody
	@RequestMapping(value = "/BIS/test", method = RequestMethod.GET)
    public String Test() {
		return "Test";
    }
	
	
	
	@ResponseBody
	@RequestMapping(value = "/gs1_getNodeCount", method = RequestMethod.GET)
    public String getNodeCount() {
        return BISCapture.count+"";
    }
	
	@ResponseBody
	@RequestMapping(value = "/gs1_setNodeCount", method = RequestMethod.POST)
    public String setNodeCount(@RequestBody String body) {
		
		try {
			JSONObject jeson= new JSONObject(body);
			BISCapture.count=jeson.get("nodeCount").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return BISCapture.count;
    }
	
	@ResponseBody
	@RequestMapping(value = "/post_gs1", method = RequestMethod.POST)
    public String setConfiguration(@RequestBody String body) {
		
		try {
			JSONObject jeson= new JSONObject(body);
			Configuration.epcis_ip=jeson.get("epcis_ip").toString();
			Configuration.epcis_port=jeson.get("epcis_port").toString();
			Configuration.oneM2M_ip=jeson.get("oneM2M_ip").toString();
			Configuration.oneM2M_port=jeson.get("oneM2M_port").toString();
			Configuration.epcis_ip_mqtt=jeson.get("epcis_ip_mqtt").toString();
			Configuration.epcis_port_mqtt=jeson.get("epcis_port_mqtt").toString();
			Configuration.oneM2M_mqtt_port=jeson.get("oneM2M_mqtt_port").toString();
			
			SubscriberThread sbscriberThread=new SubscriberThread();
			sbscriberThread.start();
			
			
			PublisherREST publisherREST=new PublisherREST();
			publisherREST.initialize();
			
			PublisherMQTT publisherMQTT=new PublisherMQTT();
			publisherMQTT.initialize();
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "epcis_ip:"+Configuration.epcis_ip+"   epcis_port:"+Configuration.epcis_port+"   oneM2M_ip:"+Configuration.oneM2M_ip
        		+"    oneM2M_port:"+Configuration.oneM2M_port+"    " +"epcis_ip_mqtt"+Configuration.epcis_ip_mqtt+"    epcis_port_mqtt:"+Configuration.epcis_port_mqtt;
    }
	
	
	
	
	@RequestMapping(value = "/BIS/CaptureMasterData", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> startMastereCapture(@RequestParam(value = "city") final String city,
			@RequestParam(value = "type") final String type){
		
		String result="";
		
		if(type.equals("busStop")) {
			
			CaptureBusStop captureBusStop=new CaptureBusStop();
			result=captureBusStop.capture(city);
			
		}else if(type.equals("busLine")) {
			CaptureBusLine captureBusLine= new CaptureBusLine();
			result=captureBusLine.capture(city);
		}else {
			result="type needs to be one of the following [busStop, busLine]";
		}
		
		return new ResponseEntity<String>(new String(result), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/BIS/startEventCapture", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> startEventCapture(@RequestParam(value = "city") final  String city, 
			@RequestParam  int startIndex,@RequestParam  int endIndex ){
		
		 String result="[Event capturing started]";
		 
		 
		
		if(city.equals("busan") || city.equals("santander") || city.equals("daejeon")) {
			if (city.equals("busan")) {
				Configuration.startIndex=startIndex;
				Configuration.endIndex=endIndex;
				System.out.println("startIndex:   "+Configuration.startIndex);
				System.out.println("endIndex:  "+Configuration.endIndex);
				//Test
				/*
				List<String> busLineStopListTest=new ArrayList<String>();
				busLineStopListTest.add("174680101");
				Configuration.busLineList.add("5200179000");
				Configuration.mapBusline_busStop.put(Configuration.busLineList.get(0), busLineStopListTest);
				*/
				///*
				CaptureBusLine captureBusLine=new CaptureBusLine();
				Configuration.busLineList=captureBusLine.getBusLines( Configuration.startIndex, Configuration.endIndex);
				for(int i=0; i<Configuration.busLineList.size(); i++) {
					List<String> busLineStopList=captureBusLine.getBusStops(Configuration.busLineList.get(i));
					Configuration.mapBusline_busStop.put(Configuration.busLineList.get(i), busLineStopList);
					
					System.out.println(Configuration.busLineList.get(i)+":  "+Configuration.mapBusline_busStop.get(Configuration.busLineList.get(i)));
				}
				//*/
				//System.out.println(busLineList.get(2));
				result = String.join(" , ", Configuration.busLineList);
			}
			
			
			
			// common to all 
			EventCapturer eventCapturer=new EventCapturer(city);
			timer = new Timer();
			long delay=0;
			//long period=600000;
			long period=120000;
			timer.schedule(eventCapturer, delay, period);
			
		}else if(city.equals("test")) {
			
			Configuration.startIndex=startIndex;
			Configuration.endIndex=endIndex;
			System.out.println("startIndex:   "+Configuration.startIndex);
			System.out.println("endIndex:  "+Configuration.endIndex);
			CaptureBusLine captureBusLine=new CaptureBusLine();
			Configuration.busLineList=captureBusLine.getBusLines( Configuration.startIndex, Configuration.endIndex);
			for(int i=0; i<Configuration.busLineList.size(); i++) {
				List<String> busLineStopList=captureBusLine.getBusStops(Configuration.busLineList.get(i));
				Configuration.mapBusline_busStop.put(Configuration.busLineList.get(i), busLineStopList);
				
				System.out.println("i:  "+Configuration.mapBusline_busStop.get(Configuration.busLineList.get(i)));
			}
			//System.out.println(busLineList.get(2));
			result = String.join(" , ", Configuration.busLineList);
			
			 
		}
		else {
			result="the city should be one of the following [busan, santander, daejeon]";
		}
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/stopEventCapture", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> stopEventCapture() {
		
		timer.cancel();
		timer.purge();
		
		return new ResponseEntity<String>(new String("Event capturing is stoped."), HttpStatus.OK);
	}
	

}
