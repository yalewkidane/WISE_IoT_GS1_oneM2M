package org.oliot.bis.capturing.eventdata;

import java.math.BigDecimal;
import java.util.Calendar;

import org.gs1.epcglobal.epcis.EventListType;
import org.oliot.bis.capturing.epcis.EPCISMarshaller;

public class EPCISEventMarshaller extends EPCISMarshaller {

	public EPCISEventMarshaller() {
		
		epcisDoc.setEPCISBody(epcisBody);
		epcisDoc.setCreationDate(Calendar.getInstance());
		epcisDoc.setSchemaVersion(new BigDecimal("1.2"));
	}

	public void make(EventListType eventList) {
		
		epcisBody.setEventList(eventList);
	}

}