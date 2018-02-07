package org.oliot.bis.capturingApp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.gs1.epcglobal.EPC;
import org.gs1.epcglobal.epcis.ActionType;
import org.gs1.epcglobal.epcis.BusinessLocationType;
import org.gs1.epcglobal.epcis.BusinessTransactionListType;
import org.gs1.epcglobal.epcis.BusinessTransactionType;
import org.gs1.epcglobal.epcis.EPCISEventExtensionType;
import org.gs1.epcglobal.epcis.EPCListType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.ReadPointType;
import org.oliot.bis.capturing.eventdata.EventDataManager;
import org.oliot.bis.model.BusEstimationSemantic;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CaptureEventEPCIS extends EventDataManager{

	
	
	//Bus Estimation 
	public String capturBusEstimation(List<BusEstimationSemantic> busEstimations, String city) {
		String result="";
		for(int i=0; i<busEstimations.size(); i++ ) {
			BusEstimationSemantic busEstimation=busEstimations.get(i);
			if(busEstimation.getId()!=null) {
				ObjectEventType objectEvent=translateNormal(busEstimation, city);
				this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(objectEvent);
			}
		}
		
		marshaller.make(eventList);
		result = marshaller.marshal();
		//System.out.println("Modeling from : - BusEventDataManager..." +result);
		int status=CaptureUtility.registerEPCIS(result);
		
		System.out.println("status..." +status);
		
		return result;
	}
	
	
	public static ObjectEventType translate(BusEstimationSemantic busEstimation, String city) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		String FormatedID="";
		if(city.equals("santander")) {
			FormatedID=busEstimation.getId().substring(56).replace(":", ".");
		}else if(city.equals("busan")) {
			try {
				FormatedID=busEstimation.getId().substring(30);
			}catch(Exception e) {
				FormatedID=busEstimation.getId();
			}
		}else {
			FormatedID="ID_from_other_city";
		}
		
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
		//recordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
		objectEventType.setEventTime(Calendar.getInstance());
		objectEventType.setRecordTime(Calendar.getInstance());
		objectEventType.setEventTimeZoneOffset((Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000))+":00");

		//objectEventType.setEventTimeZoneOffset("-06:00");

		EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
		epcisEventExtension.setEventID(UUID.randomUUID().toString());
		objectEventType.setBaseExtension(epcisEventExtension);

		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue("urn:epc:id:sgtin:88000269." + FormatedID);	
		objectEventEPCs.getEpcs().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
		eventExtention.setEventID("urn:epc:id:sgtin:88000269." + FormatedID);
		objectEventType.setBaseExtension(eventExtention);

		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:driving");
		
		objectEventType.setDisposition("urn:epcglobal:cbv:disp:on_the line");

		ReadPointType readPoint = new ReadPointType();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		readPoint.setId("urn:epc:id:sgln:8800026900016." + FormatedID);
		objectEventType.setReadPoint(readPoint);

		BusinessLocationType businessLocation = new BusinessLocationType();
		//urn:epc:id:sgln:CompanyPrefix.ItemReference.SerialNumber
		businessLocation.setId("urn:epc:id:sgln:8800026900016.103" + FormatedID);
		objectEventType.setBizLocation(businessLocation);

		BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
		BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
		businessTransaction1.setType("urn:epcglobal:cbv:Bus:status");
		businessTransaction1.setValue("http://transaction.acme.com/po/urn:epcglobal:cbv:bizstep:driving");
		businessTransactionList.getBizTransactions().add(businessTransaction1);
		objectEventType.setBizTransactionList(businessTransactionList);

		List<Object> elementList = new ArrayList<Object>();

		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.newDocument();
//			Element leafElemtStr = doc.createElementNS("http://ns.example.com/StringExample", "BIS:StringExample");
//			leafElemtStr.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
//			leafElemtStr.setTextContent("Sample string");
//			elementList.add(leafElemtStr);

			// id
			Element idElement = doc.createElementNS("http://ns.example.com/id", "BIS:id");
			//idElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			idElement.setTextContent(busEstimation.getId());
			elementList.add(idElement);

			// refBusStop
			Element refBusStopElement = doc.createElementNS("http://ns.example.com/refBusStop", "BIS:refBusStop");
			//refBusStopElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			refBusStopElement.setTextContent(busEstimation.getRefBusStop());
			elementList.add(refBusStopElement);

			// refBusLine
			Element refBusLineElement = doc.createElementNS("http://ns.example.com/refBusLine", "BIS:refBusLine");
			refBusLineElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			refBusLineElement.setTextContent(busEstimation.getRefBusLine());
			elementList.add(refBusLineElement);

			// remainingDistances
			Element remainingDistancesElement = doc.createElementNS("http://ns.example.com/remainingDistances",
					"BIS:remainingDistances");
			remainingDistancesElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			remainingDistancesElement.setTextContent(busEstimation.getRemainingDistances());
			elementList.add(remainingDistancesElement);

			// remainingTimes
			Element remainingTimesElement = doc.createElementNS("http://ns.example.com/remainingTimes",
					"BIS:remainingTimes");
			remainingTimesElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			remainingTimesElement.setTextContent(busEstimation.getRemainingTimes());
			elementList.add(remainingTimesElement);

			// destinationBusLines
			Element destinationBusLinesElement = doc.createElementNS("http://ns.example.com/destinationBusLines",
					"BIS:destinationBusLines");
			destinationBusLinesElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			destinationBusLinesElement.setTextContent(busEstimation.getDestinationBusLines());
			elementList.add(destinationBusLinesElement);

			// shortID
			Element shortIDElement = doc.createElementNS("http://ns.example.com/shortID", "BIS:shortID");
			shortIDElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			shortIDElement.setTextContent(busEstimation.getShortID());
			elementList.add(shortIDElement);

			// remainingStations
			Element remainingStationsElement = doc.createElementNS("http://ns.example.com/remainingStations",
					"BIS:remainingStations");
			remainingStationsElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			remainingStationsElement.setTextContent(busEstimation.getRemainingStations());
			elementList.add(remainingStationsElement);

			// companyName
			Element companyNameElement = doc.createElementNS("http://ns.example.com/companyName", "BIS:companyName");
			companyNameElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			companyNameElement.setTextContent(busEstimation.getCompanyName());
			elementList.add(companyNameElement);

			// location
			Element locationElement = doc.createElementNS("http://ns.example.com/location", "BIS:location");
			locationElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			locationElement.setTextContent(busEstimation.getLocation());
			elementList.add(companyNameElement);

			// dateModified
			Element dateModifiedElement = doc.createElementNS("http://ns.example.com/dateModified", "BIS:dateModified");
			dateModifiedElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			dateModifiedElement.setTextContent(busEstimation.getDateModified());
			elementList.add(dateModifiedElement);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);

		return objectEventType;
	}
	
	public static ObjectEventType translateNormal(BusEstimationSemantic busEstimation, String city) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		String FormatedID="";
		if(city.equals("santander")) {
			FormatedID="202";
			FormatedID+=busEstimation.getId().substring(56).replace(":", ".");
		}else if(city.equals("busan")) {
			try {
				FormatedID="102";
				FormatedID+=busEstimation.getId().substring(30);
			}catch(Exception e) {
				FormatedID="102";
				FormatedID+=busEstimation.getId();
			}
		}else {
			FormatedID=busEstimation.getId();
		}
		
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
		//recordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
		objectEventType.setEventTime(Calendar.getInstance());
		objectEventType.setRecordTime(Calendar.getInstance());
		int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
		//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
		String offset="00";
		if(offsetInt<10 && offsetInt>=0) {
			offset="+0"+offsetInt;
		}else if(offsetInt>-10 && offsetInt<0) {
			offset="-0"+(-offsetInt);
		}
		//System.out.println("offset : "+offset);
		objectEventType.setEventTimeZoneOffset(offset+":00");
		
		//System.out.println(objectEventType.getEventTimeZoneOffset());

		//objectEventType.setEventTimeZoneOffset("-06:00");

		EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
		epcisEventExtension.setEventID(UUID.randomUUID().toString());
		objectEventType.setBaseExtension(epcisEventExtension);

		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue("urn:epc:id:sgtin:88000269." + FormatedID);	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
		eventExtention.setEventID("urn:epc:id:sgtin:88000269." + FormatedID);
		objectEventType.setBaseExtension(eventExtention);

		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:driving");
		
		objectEventType.setDisposition("urn:epcglobal:cbv:disp:on_the line");

		ReadPointType readPoint = new ReadPointType();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		readPoint.setId("urn:epc:id:sgln:8800026900016." + FormatedID);
		objectEventType.setReadPoint(readPoint);

		BusinessLocationType businessLocation = new BusinessLocationType();
		//urn:epc:id:sgln:CompanyPrefix.ItemReference.SerialNumber
		businessLocation.setId("urn:epc:id:sgln:8800026900016.103" + FormatedID);
		objectEventType.setBizLocation(businessLocation);

		BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
		BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
		businessTransaction1.setType("urn:epcglobal:cbv:Bus:status");
		businessTransaction1.setValue("http://transaction.acme.com/po/urn:epcglobal:cbv:bizstep:driving");
		businessTransactionList.getBizTransactions().add(businessTransaction1);
		objectEventType.setBizTransactionList(businessTransactionList);

		List<Object> elementList = new ArrayList<Object>();

		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.newDocument();
//			Element leafElemtStr = doc.createElementNS("http://ns.example.com/StringExample", "BIS:StringExample");
//			leafElemtStr.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
//			leafElemtStr.setTextContent("Sample string");
//			elementList.add(leafElemtStr);

			// id
			Element idElement = doc.createElementNS("http://ns.example.com/id", "BIS:id");
			//idElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			idElement.setTextContent(busEstimation.getId());
			elementList.add(idElement);

			// refBusStop
			Element refBusStopElement = doc.createElementNS("http://ns.example.com/refBusStop", "BIS:refBusStop");
			//refBusStopElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			refBusStopElement.setTextContent(busEstimation.getRefBusStop());
			elementList.add(refBusStopElement);

			// refBusLine
			Element refBusLineElement = doc.createElementNS("http://ns.example.com/refBusLine", "BIS:refBusLine");
			//refBusLineElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			refBusLineElement.setTextContent(busEstimation.getRefBusLine());
			elementList.add(refBusLineElement);

			// remainingDistances
			Element remainingDistancesElement = doc.createElementNS("http://ns.example.com/remainingDistances",
					"BIS:remainingDistances");
			//remainingDistancesElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			remainingDistancesElement.setTextContent(busEstimation.getRemainingDistances());
			elementList.add(remainingDistancesElement);

			// remainingTimes
			Element remainingTimesElement = doc.createElementNS("http://ns.example.com/remainingTimes",
					"BIS:remainingTimes");
			//remainingTimesElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			remainingTimesElement.setTextContent(busEstimation.getRemainingTimes());
			elementList.add(remainingTimesElement);

			// destinationBusLines
			Element destinationBusLinesElement = doc.createElementNS("http://ns.example.com/destinationBusLines",
					"BIS:destinationBusLines");
			//destinationBusLinesElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			destinationBusLinesElement.setTextContent(busEstimation.getDestinationBusLines());
			elementList.add(destinationBusLinesElement);

			// shortID
			Element shortIDElement = doc.createElementNS("http://ns.example.com/shortID", "BIS:shortID");
			//shortIDElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			shortIDElement.setTextContent(busEstimation.getShortID());
			elementList.add(shortIDElement);

			// remainingStations
			Element remainingStationsElement = doc.createElementNS("http://ns.example.com/remainingStations",
					"BIS:remainingStations");
			//remainingStationsElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			remainingStationsElement.setTextContent(busEstimation.getRemainingStations());
			elementList.add(remainingStationsElement);

			// companyName
			Element companyNameElement = doc.createElementNS("http://ns.example.com/companyName", "BIS:companyName");
			//companyNameElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			companyNameElement.setTextContent(busEstimation.getCompanyName());
			elementList.add(companyNameElement);

			// location
			Element locationElement = doc.createElementNS("http://ns.example.com/location", "BIS:location");
			//locationElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			locationElement.setTextContent(busEstimation.getLocation());
			elementList.add(companyNameElement);

			// dateModified
			Element dateModifiedElement = doc.createElementNS("http://ns.example.com/dateModified", "BIS:dateModified");
			//dateModifiedElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "xs:string");
			dateModifiedElement.setTextContent(busEstimation.getDateModified());
			elementList.add(dateModifiedElement);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);

		return objectEventType;
	}
	
}
