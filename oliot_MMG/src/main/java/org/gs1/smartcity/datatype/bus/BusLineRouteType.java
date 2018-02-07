package org.gs1.smartcity.datatype.bus;

import org.gs1.smartcity.datatype.bus.master.BusStopListType;

public class BusLineRouteType {

	private String gsrn;
	private BusStopListType stopList;
	
	public BusLineRouteType() {
		
		stopList = new BusStopListType();
	}
	
	public String getGsrn() {
		
		return gsrn;
	}
	
	public void setGsrn(String value) {
		
		this.gsrn = value;
	}
	
	public BusStopListType getStopList() {
		
		return stopList;
	}
	
	public void setStopList(BusStopListType value) {
		
		this.stopList = value;
	}
	
}
