package org.gs1.smartcity.datatype.bus;

public class BusStopSemantic {
	
	private String id;    //"urn:entity:busan:transport:bus:busId:<busStopId>",
	private String refBuses;    //["urn:entity:busan:transport:bus:bus:<busId>"],
	private String shortID;    //"11161",
	private String busStopCount;    //[1,2],
	private String name;    //"city hall",
	private String location;    //[36.372,127.363],
	/*
	"address": {
				"@type": "PostalAddress",
				"addressLocality": "Denver",
				"addressRegion": "CO",
				"postalCode": "80209",
				"streetAddress": "7 S. Broadway"
				} ,
	*/
	private String address;
	private String refBusLines;    //"The list of all bus lines that pass by the bus stop",
	private String dateModified;    //"2017-02-05T08:15:30-05:09",
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRefBuses() {
		return refBuses;
	}
	public void setRefBuses(String refBuses) {
		this.refBuses = refBuses;
	}
	public String getShortID() {
		return shortID;
	}
	public void setShortID(String shortID) {
		this.shortID = shortID;
	}
	public String getBusStopCount() {
		return busStopCount;
	}
	public void setBusStopCount(String busStopCount) {
		this.busStopCount = busStopCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRefBusLines() {
		return refBusLines;
	}
	public void setRefBusLines(String refBusLines) {
		this.refBusLines = refBusLines;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	
	
	
	
}
