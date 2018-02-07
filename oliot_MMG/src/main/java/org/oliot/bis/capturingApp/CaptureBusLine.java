package org.oliot.bis.capturingApp;


import java.io.IOException;
import java.io.StringReader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.oliot.bis.service.utility.ExistingQueryService;
import org.oliot.bis.service.utility.ISO8601;
import org.oliot.bis.configuration.Configuration;
import org.oliot.bis.model.BusEstimationSemantic;
import org.oliot.bis.model.BusLineSematic;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CaptureBusLine extends Translator {
	
	public String capture(String city) {
		String result="Error occured";
		if(city.equals("busan")) {
			result="result from busan";
			Configuration.logger.info("Busan Bus Line capturing started");
			try {
				String serviceKey = Configuration.serviceKey_busan;
				String ur1_1 ="http://data.busan.go.kr/openBus/service/busanBIMS2/busInfo?serviceKey="+serviceKey;
				String data = ExistingQueryService.normalquery(ur1_1);
				List<BusLineSematic> busLines=translateBusan(data);
				CaptureEPCIS captureEPCIS=new CaptureEPCIS();
				result=captureEPCIS.captureBusLine(busLines, "busan");
				int status=CaptureUtility.registerEPCIS(result);
				System.out.println("result : " + status);
				return status+"";
				//System.out.println(result);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//List<BusStopSemantic> busStops=translateBusan(result);
		}else if(city.equals("santander")) {
			try {
				String data=ExistingQueryService.SecureQuery("https://mu.tlmat.unican.es:8443/v2/entities?limit=33&type=busLine");
				List<BusLineSematic> busLines=translateSantadar(data);
				CaptureEPCIS captureEPCIS=new CaptureEPCIS();
				result=captureEPCIS.captureBusLine(busLines, "santander");
				int status=CaptureUtility.registerEPCIS(result);
				System.out.println("result : " + status);
				return status+"";
			}catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			
		}else {
			result="city needs to be one of the following [busan, santander]";
		}
		return result;
	}
	
	public List<BusLineSematic> translateBusan(String data){
		List<BusLineSematic> busLines=new ArrayList<>();
		String serviceKey = Configuration.serviceKey_busan;
		
		//id refBusStops localID shortID name refStartBusStop refEndBusStop busLineType startTime endTime intervalNorm intervalHoli intervalPeak dateModified 
		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		NodeList nList = document.getElementsByTagName("item");
		System.out.println(nList.getLength()+ "  lines");
		// TODO   i < nList.getLength();
		for (int i = 0; i < 2; i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;
			BusLineSematic busLine=new BusLineSematic();
			
			Configuration.logger.info("Proccessing line : "+ i + " ... ");
			
			//id 
			String lineId="0000";
			if(element.getElementsByTagName("lineId").item(0) != null) {
				lineId=element.getElementsByTagName("lineId").item(0).getFirstChild().getNodeValue();
			}
			busLine.setId("urn:epc:id:sgtin:88000269.101."+lineId);
			
			//refBusStops 
			List<String> refBusStops=new ArrayList<>();
			try {
				String url_withLineId="http://data.busan.go.kr/openBus/service/busanBIMS2/busInfoRoute?lineid="+lineId+"&serviceKey="+serviceKey;
				String data_refBusStops = ExistingQueryService.normalquery(url_withLineId);
				document = builder.parse(new InputSource(new StringReader(data_refBusStops)));
				NodeList nList_refBusStops = document.getElementsByTagName("item");
				
				String nodeId="00000";
				Element element_0=(Element)nList_refBusStops.item(0);
				
				if(element_0.getElementsByTagName("nodeId").item(0) != null) {
					nodeId=element_0.getElementsByTagName("nodeId").item(0).getFirstChild().getNodeValue();
				}
				busLine.setRefStartBusStop("urn:epc:id:sgtin:88000269.100."+nodeId);
				refBusStops.add("urn:epc:id:sgtin:88000269.100."+nodeId);
				for (int j = 1; j < nList_refBusStops.getLength(); j++) {
					Node nNodet_refBusStops = nList_refBusStops.item(j);
					Element elementt_refBusStops = (Element) nNodet_refBusStops;
					if(elementt_refBusStops.getElementsByTagName("nodeId").item(0) != null) {
						nodeId=elementt_refBusStops.getElementsByTagName("nodeId").item(0).getFirstChild().getNodeValue();
					}
					refBusStops.add("urn:epc:id:sgtin:88000269.100."+nodeId);
				}
				busLine.setRefEndBusStop("urn:epc:id:sgtin:88000269.100."+nodeId);
				
			} catch (IOException  |SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			busLine.setRefBusStops(refBusStops.toString());
			
			//localID 
			String buslinenum="0";
			if(element.getElementsByTagName("buslinenum").item(0) != null) {
				buslinenum=element.getElementsByTagName("buslinenum").item(0).getFirstChild().getNodeValue();
			}
			busLine.setLocalID(buslinenum);
			
			//shortID 
			busLine.setShortID(lineId);
			
			//name 
			String bustype="bustype-Defoult";
			if(element.getElementsByTagName("bustype").item(0) != null) {
				bustype=element.getElementsByTagName("bustype").item(0).getFirstChild().getNodeValue();
			}
			busLine.setName(bustype);
			
			//refStartBusStop 
			
			//refEndBusStop 
			
			//busLineType 
			String companyid="companyid-Defoult";
			if(element.getElementsByTagName("companyid").item(0) != null) {
				companyid=element.getElementsByTagName("companyid").item(0).getFirstChild().getNodeValue();
			}
			busLine.setBusLineType(companyid);
			
			//startTime 
			String firsttime="00:00";
			if(element.getElementsByTagName("firsttime").item(0) != null) {
				firsttime=element.getElementsByTagName("firsttime").item(0).getFirstChild().getNodeValue();
			}
			busLine.setStartTime(firsttime);
			//endTime 
			String endtime="00:00";
			if(element.getElementsByTagName("endtime").item(0) != null) {
				endtime=element.getElementsByTagName("endtime").item(0).getFirstChild().getNodeValue();
			}
			busLine.setEndTime(endtime);
			
			//intervalNorm 
			String headwayNorm="0";
			if(element.getElementsByTagName("headwayNorm").item(0) != null) {
				headwayNorm=element.getElementsByTagName("headwayNorm").item(0).getFirstChild().getNodeValue();
			}
			busLine.setIntervalNorm(headwayNorm);
			
			//intervalHoli 
			String headwayHoli="0";
			if(element.getElementsByTagName("headwayHoli").item(0) != null) {
				headwayHoli=element.getElementsByTagName("headwayHoli").item(0).getFirstChild().getNodeValue();
			}
			busLine.setIntervalHoli(headwayHoli);
			//intervalPeak 
			String headwayPeak="0";
			if(element.getElementsByTagName("headwayPeak").item(0) != null) {
				headwayPeak=element.getElementsByTagName("headwayPeak").item(0).getFirstChild().getNodeValue();
			}
			busLine.setIntervalPeak(headwayPeak);
			
			//dateModified
			busLine.setDateModified("NA");
			
			busLines.add(busLine);
			
		}
		Configuration.logger.info("Capturing bus line done");
		
		return busLines;
	}
	
	
	
	

	
	
	public List<BusLineSematic> translateSantadar(String data) {
		
		List<BusLineSematic> busLines=new ArrayList<>();
		JSONArray jsonarray;
		try {
			jsonarray = new JSONArray(data);
			for (int i = 0; i < jsonarray.length(); i++) {
				JSONObject jsonobject = jsonarray.getJSONObject(i);
				BusLineSematic busLine=new BusLineSematic();
				//id
				try {
					String id = jsonobject.getString("id");
					busLine.setId(id);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				//localID
				try {
					String localID =jsonobject.getString("localID");
				    JSONObject localIDObject = new JSONObject(localID);
				    String localIDValue=localIDObject.getString("value");
				    busLine.setLocalID(localIDValue);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				//shortID
				try {
					String shortId =jsonobject.getString("shortID");
				    JSONObject shortIDObject = new JSONObject(shortId);
				    String shortIdValue=shortIDObject.getString("value");
				    busLine.setShortID(shortIdValue);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				//name
				try {
					String name =jsonobject.getString("name");
				    JSONObject nameObject = new JSONObject(name);
				    String nameValue=nameObject.getString("value");
				    busLine.setName(nameValue);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				//refBusStops
				try {
					String refBusStops =jsonobject.getString("refBusStops");
				    JSONObject refBusStopsObject = new JSONObject(refBusStops);
				    String refBusStopsValue=refBusStopsObject.getString("value");
				    busLine.setRefBusStops(refBusStopsValue);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				//refStartBusStop
				busLine.setRefStartBusStop("NA");
				//refEndBusStop
				busLine.setRefEndBusStop("NA");
				//busLineType
				busLine.setBusLineType("NA");
				//startTime
				busLine.setStartTime("NA");
				//endTime
				busLine.setEndTime("NA");
				//intervalNorm
				busLine.setIntervalNorm("NA");
				//intervalHoli
				busLine.setIntervalHoli("NA");
				//intervalPeak
				busLine.setIntervalPeak("NA");
				//dateModified
				try {
					String dateModified =jsonobject.getString("dateModified");
				    JSONObject dateModifiedObject = new JSONObject(dateModified);
				    String dateModifiedValue=dateModifiedObject.getString("value");
				    busLine.setDateModified(dateModifiedValue);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				
				
				busLines.add(busLine);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		return busLines;
		
	}
	
	
	public List<String> getBusLines(int startIndex, int endIndex){
		List<String> busList=new ArrayList<>();
		
		String serviceKey = Configuration.serviceKey_busan;
		String ur1_1 ="http://data.busan.go.kr/openBus/service/busanBIMS2/busInfo?serviceKey="+serviceKey;
		String data;
		try {
			data = ExistingQueryService.normalquery(ur1_1);
			try {
				document = builder.parse(new InputSource(new StringReader(data)));
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			NodeList nList = document.getElementsByTagName("item");
			if(startIndex>nList.getLength())
				startIndex=nList.getLength();
			if(endIndex>nList.getLength())
				endIndex=nList.getLength();
			
			for (int i = startIndex; i < endIndex; i++) {
				Node nNode = nList.item(i);
				Element element = (Element) nNode;
				String lineId="0000";
				if(element.getElementsByTagName("lineId").item(0) != null) {
					lineId=element.getElementsByTagName("lineId").item(0).getFirstChild().getNodeValue();
					busList.add(lineId);
				}
				
			}
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		
		return busList;
	}
	
	
	public List<String> getBusStops(String busline){
		List<String> busStops=new ArrayList<>();
		//refBusStops 
		try {
			String url_withLineId="http://data.busan.go.kr/openBus/service/busanBIMS2/busInfoRoute?lineid="+busline+"&serviceKey="+Configuration.serviceKey_busan;
			String data_refBusStops = ExistingQueryService.normalquery(url_withLineId);
			document = builder.parse(new InputSource(new StringReader(data_refBusStops)));
			NodeList nList_refBusStops = document.getElementsByTagName("item");
			
			String nodeId="00000";
			
			for (int j = 0; j < nList_refBusStops.getLength(); j++) {
				Node nNodet_refBusStops = nList_refBusStops.item(j);
				Element elementt_refBusStops = (Element) nNodet_refBusStops;
				if(elementt_refBusStops.getElementsByTagName("nodeId").item(0) != null) {
					nodeId=elementt_refBusStops.getElementsByTagName("nodeId").item(0).getFirstChild().getNodeValue();
				}
				busStops.add(nodeId);
			}
			
		} catch (IOException  |SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return busStops;
	}
	
	
	public BusEstimationSemantic getBusEstimation(String busLine, String busStop) {
		BusEstimationSemantic busEstimation=new BusEstimationSemantic();
		
		try {
			//http://data.busan.go.kr/openBus/service/busanBIMS2/busStopArr?bstopid=212530103&lineid=5200179000&serviceKey=OQX6Z00oyK1KwR40XLTdxvrSq90gpAsadkdL8Tgn48uArTQIBJzn7UnkUi%2FW7%2BD%2BwwEDyqkM%2Byo%2B2dm7iDocMA%3D%3D
			String url_withLineId="http://data.busan.go.kr/openBus/service/busanBIMS2/busStopArr?bstopid="+busStop+"&lineid="+busLine+"&serviceKey="+Configuration.serviceKey_busan;
			String data_busEstimation = ExistingQueryService.normalquery(url_withLineId);
			document = builder.parse(new InputSource(new StringReader(data_busEstimation)));
			NodeList nList_busEstimation = document.getElementsByTagName("item");
			
			
			
			for (int j = 0; j < nList_busEstimation.getLength(); j++) {
				Node nNodet_refBusStops = nList_busEstimation.item(j);
				Element elementt_busEstimation = (Element) nNodet_refBusStops;
				String station1="00000";
				if(elementt_busEstimation.getElementsByTagName("station1").item(0) != null) {
					station1=elementt_busEstimation.getElementsByTagName("station1").item(0).getFirstChild().getNodeValue();
					busEstimation.setRemainingStations(station1);
					busEstimation.setRemainingDistances("NA");
					busEstimation.setId("urn:epc:id:sgtin:88000269.102."+busStop+"."+busLine);
					busEstimation.setRefBusStop("urn:epc:id:sgtin:88000269.100."+busStop);
					busEstimation.setRefBusLine("urn:epc:id:sgtin:88000269.100."+busLine);
					
					//shortID
					String lineNo="NA";
					if(elementt_busEstimation.getElementsByTagName("lineNo").item(0) != null) {
						lineNo=elementt_busEstimation.getElementsByTagName("lineNo").item(0).getFirstChild().getNodeValue();
					}
					busEstimation.setShortID(lineNo);
					
					//remainingTimes
					String min_counter="min1";
					String min_val="P0Y0M0DT0H0M0S";
					if(elementt_busEstimation.getElementsByTagName(min_counter).item(0) != null) {
						String val=elementt_busEstimation.getElementsByTagName(min_counter).item(0).getFirstChild().getNodeValue();
						min_val=ISO8601.IntervalToString("0", "0", "0", "0", val, "0");
					}
					
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
					
				}
				//System.out.println(station1);
				
				//busStops.add(nodeId);
			}
			
		} catch (IOException  |SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return busEstimation;
		
	}

}

