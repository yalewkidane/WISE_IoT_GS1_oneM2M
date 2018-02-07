package org.oliot.bis.capturingApp;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.oliot.bis.capturing.masterdata.MasterDataManager;
import org.oliot.bis.model.BusEstimationSemantic;
import org.oliot.bis.model.BusLineSematic;
import org.oliot.bis.model.BusStopSemantic;
import org.gs1.epcglobal.epcis.ActionType;
import org.gs1.epcglobal.epcis.AttributeType;
import org.gs1.epcglobal.epcis.BusinessLocationType;
import org.gs1.epcglobal.epcis.BusinessTransactionListType;
import org.gs1.epcglobal.epcis.BusinessTransactionType;
import org.oliot.model.epcis.EPC;
import org.gs1.epcglobal.epcis.EPCISEventExtensionType;
import org.gs1.epcglobal.epcis.EPCListType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.ReadPointType;
import org.gs1.epcglobal.epcis.VocabularyElementListType;
import org.gs1.epcglobal.epcis.VocabularyElementType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class CaptureEPCIS extends MasterDataManager{

	public String captureBusStop(List<BusStopSemantic> busStopSemanticList, String city) {
		String result="";
		try {
			VocabularyType voc= new VocabularyType();
			if(city.equals("santander")) {
				voc.setType("urn:gs1:epcis:santander:bus:stop:info");
			}else if(city.equals("busan")) {
				voc.setType("urn:gs1:epcis:busan:bus:stop:info");
			}else {
				voc.setType("urn:gs1:epcis:app:bus:stop:info");
			}
			
			VocabularyElementListType vocElementList = new VocabularyElementListType();
			for(int i = 0; i < busStopSemanticList.size(); i++) {
				BusStopSemantic busStopSemantic=busStopSemanticList.get(i);
				VocabularyElementType vocElement = new VocabularyElementType();
				
				if(city.equals("santander")) {
					try {
						vocElement.setId("urn:epc:id:sgtin:88000269.200."+busStopSemantic.getId().substring(43));
					}catch(Exception e) {
						vocElement.setId(busStopSemantic.getId());
					}
				}else if(city.equals("busan")) {
					vocElement.setId(busStopSemantic.getId());
				}else {
					vocElement.setId("urn:epc:id:gsrn:busStopXXXXXx");
				}
				//id
				if(busStopSemantic.getId()!=null){
					AttributeType id = new AttributeType();
					id.setId("http://epcis.example.com/bus/stop/id");
					id.getContent().add(busStopSemantic.getId());
					vocElement.getAttributes().add(id);
				}
				
				//refBuses
				if(busStopSemantic.getRefBuses() != null) {
					AttributeType refBuses = new AttributeType();
					refBuses.setId("http://epcis.example.com/bus/stop/refBuses");
					refBuses.getContent().add(busStopSemantic.getRefBuses());
					vocElement.getAttributes().add(refBuses);
				}
				
				//shortID
				if(busStopSemantic.getShortID() != null) {
					AttributeType shortID = new AttributeType();
					shortID.setId("http://epcis.example.com/bus/stop/shortID");
					shortID.getContent().add(busStopSemantic.getShortID());
					vocElement.getAttributes().add(shortID);
				}
				
				//busStopCount
				if(busStopSemantic.getBusStopCount() != null) {
					AttributeType busStopCount = new AttributeType();
					busStopCount.setId("http://epcis.example.com/bus/stop/busStopCount");
					busStopCount.getContent().add(busStopSemantic.getBusStopCount());
					vocElement.getAttributes().add(busStopCount);
				}
				
				//name
				if(busStopSemantic.getName() != null) {
					AttributeType name = new AttributeType();
					name.setId("http://epcis.example.com/bus/stop/name");
					name.getContent().add(busStopSemantic.getName());
					vocElement.getAttributes().add(name);
				}
				
				//location
				if(busStopSemantic.getLocation() != null) {
					AttributeType location = new AttributeType();
					location.setId("http://epcis.example.com/bus/stop/location");
					location.getContent().add(busStopSemantic.getLocation());
					vocElement.getAttributes().add(location);
				}
				
				//refBusLines
				if(busStopSemantic.getRefBusLines() != null) {
					AttributeType refBusLines = new AttributeType();
					refBusLines.setId("http://epcis.example.com/bus/stop/refBusLines");
					refBusLines.getContent().add(busStopSemantic.getRefBusLines());
					vocElement.getAttributes().add(refBusLines);
				}
				
				//datemodified
				if(busStopSemantic.getDateModified() != null) {
					AttributeType datemodified = new AttributeType();
					datemodified.setId("http://epcis.example.com/bus/stop/datemodified");
					datemodified.getContent().add(busStopSemantic.getDateModified());
					vocElement.getAttributes().add(datemodified);
				}
				
				//address
				if(busStopSemantic.getAddress() !=null) {
					AttributeType address = new AttributeType();
					address.setId("http://epcis.example.com/bus/stop/address");
					address.getContent().add(busStopSemantic.getAddress());
					vocElement.getAttributes().add(address);
				}
				
				//direction
				if(busStopSemantic.getDirection() !=null) {
					AttributeType direction = new AttributeType();
					direction.setId("http://epcis.example.com/bus/stop/direction");
					direction.getContent().add(busStopSemantic.getDirection());
					vocElement.getAttributes().add(direction);
				}
				
				vocElementList.getVocabularyElements().add(vocElement);
			}
			
			voc.setVocabularyElementList(vocElementList);
			
			headerModeling();
			marshaller.make(sbdh, voc);
			result = marshaller.marshal();
			
			return result;
			
//			List<VocabularyType> vocabularyTypeList =new ArrayList<>();
//			vocabularyTypeList.add(voc);
//			CaptureService captureService=new CaptureService();
//			HashMap<String, Object> retMsg = new HashMap<String, Object>();
//			retMsg=captureService.captureVocabularies(vocabularyTypeList, null);
			
//			result=retMsg.toString();
		}catch(Exception e) {
			result=e.toString();
		}
		
		
		return result;
	}
	
	
	public String captureBusLine(List<BusLineSematic> busLineSematicList, String city) {
		
		String result="";
		try {
			VocabularyType voc= new VocabularyType();
			if(city.equals("santander")) {
				voc.setType("urn:gs1:epcis:santander:bus:line:info");
			}else if(city.equals("busan")) {
				voc.setType("urn:gs1:epcis:busan:bus:line:info");
			}else {
				voc.setType("urn:gs1:epcisapp:bus:line:info");
			}
			
			VocabularyElementListType vocElementList = new VocabularyElementListType();
			for(int i = 0; i < busLineSematicList.size(); i++) {
				BusLineSematic busLineSematic=busLineSematicList.get(i);
				VocabularyElementType vocElement = new VocabularyElementType();
				
				
				
				
				if(city.equals("santander")) {
					try {
						vocElement.setId("urn:epc:id:sgtin:88000269.201."+busLineSematic.getId().substring(43));
					}catch(Exception e) {
						vocElement.setId(busLineSematic.getId());
					}
				}else if(city.equals("busan")) {
					vocElement.setId(busLineSematic.getId());
				}else {
					vocElement.setId("urn:epc:id:gsrn:busStopXXXXXx");
				}
				//id
				if(busLineSematic.getId()!=null){
					AttributeType id = new AttributeType();
					id.setId("http://epcis.example.com/bus/stop/id");
					id.getContent().add(busLineSematic.getId());
					vocElement.getAttributes().add(id);
				}
				
			
				//localID
				if(busLineSematic.getLocalID() != null) {
					AttributeType localID = new AttributeType();
					localID.setId("http://epcis.example.com/bus/line/localID");
					localID.getContent().add(busLineSematic.getLocalID());
					vocElement.getAttributes().add(localID);
				}
				//shortID
				if(busLineSematic.getShortID() != null) {
					AttributeType shortID = new AttributeType();
					shortID.setId("http://epcis.example.com/bus/line/shortID");
					shortID.getContent().add(busLineSematic.getShortID());
					vocElement.getAttributes().add(shortID);
				}
				//name
				if(busLineSematic.getName() != null) {
					AttributeType name = new AttributeType();
					name.setId("http://epcis.example.com/bus/line/name");
					name.getContent().add(busLineSematic.getName());
					vocElement.getAttributes().add(name);
				}
				//refBusStops
				if(busLineSematic.getRefBusStops() != null) {
					AttributeType refBusStops = new AttributeType();
					refBusStops.setId("http://epcis.example.com/bus/line/refBusStops");
					refBusStops.getContent().add(busLineSematic.getRefBusStops());
					vocElement.getAttributes().add(refBusStops);
				}
				//refStartBusStop
				if(busLineSematic.getRefStartBusStop() != null) {
					AttributeType refStartBusStop = new AttributeType();
					refStartBusStop.setId("http://epcis.example.com/bus/line/refStartBusStop");
					refStartBusStop.getContent().add(busLineSematic.getRefStartBusStop());
					vocElement.getAttributes().add(refStartBusStop);
				}
				//refEndBusStop
				if(busLineSematic.getRefEndBusStop() != null) {
					AttributeType refEndBusStop = new AttributeType();
					refEndBusStop.setId("http://epcis.example.com/bus/line/refEndBusStop");
					refEndBusStop.getContent().add(busLineSematic.getRefEndBusStop());
					vocElement.getAttributes().add(refEndBusStop);
				}
				//busLineType
				if(busLineSematic.getBusLineType() != null) {
					AttributeType busLineType = new AttributeType();
					busLineType.setId("http://epcis.example.com/bus/line/busLineType");
					busLineType.getContent().add(busLineSematic.getBusLineType());
					vocElement.getAttributes().add(busLineType);
				}
				//startTime
				if(busLineSematic.getStartTime() != null) {
					AttributeType startTime = new AttributeType();
					startTime.setId("http://epcis.example.com/bus/line/startTime");
					startTime.getContent().add(busLineSematic.getStartTime());
					vocElement.getAttributes().add(startTime);
				}
				//endTime
				if(busLineSematic.getEndTime() != null) {
					AttributeType endTime = new AttributeType();
					endTime.setId("http://epcis.example.com/bus/line/endTime");
					endTime.getContent().add(busLineSematic.getEndTime());
					vocElement.getAttributes().add(endTime);
				}
				//intervalNorm
				if(busLineSematic.getIntervalNorm() != null) {
					AttributeType intervalNorm = new AttributeType();
					intervalNorm.setId("http://epcis.example.com/bus/line/intervalNorm");
					intervalNorm.getContent().add(busLineSematic.getIntervalNorm());
					vocElement.getAttributes().add(intervalNorm);
				}
				//intervalHoli
				if(busLineSematic.getIntervalHoli() != null) {
					AttributeType intervalHoli = new AttributeType();
					intervalHoli.setId("http://epcis.example.com/bus/line/intervalHoli");
					intervalHoli.getContent().add(busLineSematic.getIntervalHoli());
					vocElement.getAttributes().add(intervalHoli);
				}
				//intervalPeak
				if(busLineSematic.getIntervalPeak() != null) {
					AttributeType intervalPeak = new AttributeType();
					intervalPeak.setId("http://epcis.example.com/bus/line/intervalPeak");
					intervalPeak.getContent().add(busLineSematic.getIntervalPeak());
					vocElement.getAttributes().add(intervalPeak);
				}
				//dateModified
				if(busLineSematic.getDateModified() != null) {
					AttributeType datemodified = new AttributeType();
					datemodified.setId("http://epcis.example.com/bus/line/datemodified");
					datemodified.getContent().add(busLineSematic.getDateModified());
					vocElement.getAttributes().add(datemodified);
				}
				vocElementList.getVocabularyElements().add(vocElement);
			}
			
			voc.setVocabularyElementList(vocElementList);
			
			headerModeling();
			marshaller.make(sbdh, voc);
			result = marshaller.marshal();
			
			return result;
			
//			List<VocabularyType> vocabularyTypeList =new ArrayList<>();
//			vocabularyTypeList.add(voc);
//			CaptureService captureService=new CaptureService();
//			HashMap<String, Object> retMsg = new HashMap<String, Object>();
//			retMsg=captureService.captureVocabularies(vocabularyTypeList, null);
//			
//			result=retMsg.toString();
			
		}catch(Exception e) {
			result=e.toString();
		}
		return result;
	}
	
	
	

}