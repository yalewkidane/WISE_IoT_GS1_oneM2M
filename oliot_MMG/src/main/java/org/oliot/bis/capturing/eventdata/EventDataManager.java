package org.oliot.bis.capturing.eventdata;

import org.gs1.epcglobal.epcis.EventListType;

public class EventDataManager {

	protected EPCISEventMarshaller marshaller;
	protected EventListType eventList;
	
	public EventDataManager() {
		
		marshaller = new EPCISEventMarshaller();
		eventList = new EventListType();
	}
	
}