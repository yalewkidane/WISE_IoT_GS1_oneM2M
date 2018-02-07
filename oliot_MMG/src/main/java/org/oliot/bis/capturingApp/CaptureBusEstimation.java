package org.oliot.bis.capturingApp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.oliot.bis.configuration.Configuration;
import org.oliot.bis.model.BusEstimationSemantic;
import org.oliot.bis.service.utility.ExistingQueryService;
import org.oliot.bis.service.utility.ISO8601;

public class CaptureBusEstimation {
	
	
	public String capture(String city) {
		String result="Error occured";
		if(city.equals("busan")) {
			result="result from busan";
			
			List<BusEstimationSemantic> busEstimations=new ArrayList<>();
			
			for(int i=0; i<Configuration.busLineList.size();i++) {
				
				System.out.println(Configuration.busLineList.get(i)+":  "+Configuration.mapBusline_busStop.get(Configuration.busLineList.get(i)));
				List<String> busStops=Configuration.mapBusline_busStop.get(Configuration.busLineList.get(i));
				int listCount=busStops.size();
				CaptureBusLine  captureBusLine=new CaptureBusLine();
				
				
				//BusEstimationSemantic busEstimation=captureBusLine.getBusEstimation(Configuration.busLineList.get(i), busStops.get(listCount-1));
				
				
				
				
				
				
				
				int counter=listCount-1;
				int staions= 0;
				while(counter>=0) {
					if(staions>1) {
						System.out.println("Calculation");
						staions--;
						BusEstimationSemantic busEstimation=new BusEstimationSemantic();
						busEstimation.setRemainingStations(staions+"");
						busEstimation.setRemainingDistances("NA");
						busEstimation.setId("urn:epc:id:sgtin:88000269.102."+busStops.get(counter)+"."+Configuration.busLineList.get(i));
						busEstimation.setRefBusStop("urn:epc:id:sgtin:88000269.100."+busStops.get(counter));
						busEstimation.setRefBusLine("urn:epc:id:sgtin:88000269.100."+Configuration.busLineList.get(i));
						busEstimation.setShortID(Configuration.busLineList.get(i).substring(4, 7));
						String min_val=ISO8601.IntervalToString("0", "0", "0", "0", staions+"", "0");
						busEstimation.setRemainingTimes(min_val);
						//location
						busEstimation.setLocation("NA");
						
						//comapnyName
						busEstimation.setCompanyName("NA");
						
						//dateModified
						TimeZone tz = TimeZone.getTimeZone("UTC");
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
						df.setTimeZone(tz);
						String nowAsISO = df.format(new Date());
						busEstimation.setDateModified(nowAsISO);
						
						busEstimations.add(busEstimation);
						counter--;
						
						System.out.println(busEstimation.getId());
						System.out.println(busEstimation.getRemainingStations());
					}else {
						BusEstimationSemantic busEstimation=captureBusLine.getBusEstimation(Configuration.busLineList.get(i), busStops.get(counter));
						busEstimations.add(busEstimation);
						try {
							staions= Integer.parseInt(busEstimation.getRemainingStations());
						}catch(Exception e) {
							staions= 0;
						}
						counter--;
						
						System.out.println("counter:  " + counter);
						System.out.println(busEstimation.getId());
						System.out.println(busEstimation.getRemainingStations());
					}
					
				}
				
				CaptureEventEPCIS captureEPCIS=new CaptureEventEPCIS();
				result=captureEPCIS.capturBusEstimation(busEstimations, "busan");
				
			}
			
			
		}else if(city.equals("santander")) {
			
			try {//limit=1000
				int limit1=0; 
				int limit2=0;
				if(Configuration.santandar_bus_Estimation>1000) {
					limit1=1000;
					limit2=Configuration.santandar_bus_Estimation-1000;
				}else {
					limit1=Configuration.santandar_bus_Estimation;
					limit2=0;
				}
				String data=ExistingQueryService.SecureQuery("https://mu.tlmat.unican.es:8443/v2/entities?limit="+limit1+"&type=BusArrivalEstimation");
				List<BusEstimationSemantic> busEstimations=translateSantadar(data); //limit=470
				if(limit2 !=0) {
					data=ExistingQueryService.SecureQuery("https://mu.tlmat.unican.es:8443/v2/entities?limit="+limit2+"&offset=1000&type=BusArrivalEstimation");
					busEstimations.addAll(translateSantadar(data));
				}
				System.out.println("Bus Estimation number : "+ busEstimations.size());
				CaptureEventEPCIS captureEPCIS=new CaptureEventEPCIS();
				result=captureEPCIS.capturBusEstimation(busEstimations, "santander");
			} catch ( Exception   e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			result="city needs to be one of the following [busan, santander]";
		}
		return result;
	}
	
	public List<BusEstimationSemantic> translateSantadar(String data) {

		List<BusEstimationSemantic> busEstimations = new ArrayList<>();
		JSONArray jsonarray;
		try {
			jsonarray = new JSONArray(data);
			for (int i = 0; i < jsonarray.length(); i++) {
				JSONObject jsonobject = jsonarray.getJSONObject(i);
				BusEstimationSemantic busEstimation=new BusEstimationSemantic();
				//id 
				try {
					String id = jsonobject.getString("id");
					busEstimation.setId(id);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				//refBusStop 
				try {
					String refBusStop =jsonobject.getString("refBusStop");
				    JSONObject refBusStopObject = new JSONObject(refBusStop);
				    String refBusStopValue=refBusStopObject.getString("value");
				    busEstimation.setRefBusStop(refBusStopValue);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				//refBusLine 
				try {
					String refBusLine =jsonobject.getString("refBusLine");
				    JSONObject refBusLineObject = new JSONObject(refBusLine);
				    String refBusLineValue=refBusLineObject.getString("value");
				    busEstimation.setRefBusLine(refBusLineValue);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				//remainingDistances 
				try {
					String remainingDistances =jsonobject.getString("remainingDistances");
				    JSONObject remainingDistancesObject = new JSONObject(remainingDistances);
				    String remainingDistancesValue=remainingDistancesObject.getString("value");
				    busEstimation.setRemainingDistances(remainingDistancesValue);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				//remainingTimes 
				try {
					String remainingTimes =jsonobject.getString("remainingTimes");
				    JSONObject remainingTimesObject = new JSONObject(remainingTimes);
				    String remainingTimesValue=remainingTimesObject.getString("value");
				    busEstimation.setRemainingTimes(remainingTimesValue);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				//destinationBusLines 
				try {
					String destinationBusLines =jsonobject.getString("destinationBusLines");
				    JSONObject destinationBusLinesObject = new JSONObject(destinationBusLines);
				    String destinationBusLinesValue=destinationBusLinesObject.getString("value");
				    busEstimation.setDestinationBusLines(destinationBusLinesValue);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				//shortID 
				busEstimation.setShortID("NA");
				
				//remainingStations 
				busEstimation.setRemainingStations("NA");
				
				//companyName 
				busEstimation.setCompanyName("NA");
				
				
				//location 
				busEstimation.setLocation("NA");
				
				//dateModified
				try {
					String dateModified =jsonobject.getString("dateModified");
				    JSONObject dateModifiedObject = new JSONObject(dateModified);
				    String dateModifiedValue=dateModifiedObject.getString("value");
				    busEstimation.setDateModified(dateModifiedValue);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				busEstimations.add(busEstimation);
			}
			
		}catch (JSONException e) {
			e.printStackTrace();
		}
		
		

		return busEstimations;
	}
	
	
	public List<BusEstimationSemantic> translateBusan(String data) {

		List<BusEstimationSemantic> busStops = new ArrayList<>();

		return busStops;
	}
}