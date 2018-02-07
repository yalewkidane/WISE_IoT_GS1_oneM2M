package org.gs1.smartcity.datatype.bus;

import java.util.Date;
import java.util.List;

public class BusLineSemantic {
	private String id;    //"urn:entity:busan:transport:bus:busId:<busLineId>",
	private List<String> refBusStops;    //["urn:entity:busan:transport:bus:busStop:<busStopId>"],
	private String localID;   //"104",
	private String shortID;    //"5200104000",
	private String name;    //"PENACASTILLO � PLAZA DE ITALIA",
	private String refStartBusStop;    //"urn:entity:busan:transport:bus:busStop:<busStopId>",
	private String refEndBusStop;    //"urn:entity:busan:transport:bus:busStop:<busStopId>",
	private String busLineType;    //"standard",
	private String startTime;    //"2017-02-05T08:15:30-05:09",
	private String endTime;    //"2017-02-05T08:15:30-05:09",
	private String intervalNorm;    //"P3Y6M4DT12H30M5S",
	private String intervalHoli;    //"P3Y6M4DT12H30M5S",
	private String intervalPeak;    //"P3Y6M4DT12H30M5S",
	private String dateModified;    //"2017-02-05T08:15:30-05:09",
	private String companyName;    //"SamHoa"
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getRefBusStops() {
		return refBusStops;
	}
	public void setRefBusStops(List<String> refBusStops) {
		this.refBusStops = refBusStops;
	}
	public String getLocalID() {
		return localID;
	}
	public void setLocalID(String localID) {
		this.localID = localID;
	}
	public String getShortID() {
		return shortID;
	}
	public void setShortID(String shortID) {
		this.shortID = shortID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRefStartBusStop() {
		return refStartBusStop;
	}
	public void setRefStartBusStop(String refStartBusStop) {
		this.refStartBusStop = refStartBusStop;
	}
	public String getRefEndBusStop() {
		return refEndBusStop;
	}
	public void setRefEndBusStop(String refEndBusStop) {
		this.refEndBusStop = refEndBusStop;
	}
	public String getBusLineType() {
		return busLineType;
	}
	public void setBusLineType(String busLineType) {
		this.busLineType = busLineType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getIntervalNorm() {
		return intervalNorm;
	}
	public void setIntervalNorm(String intervalNorm) {
		this.intervalNorm = intervalNorm;
	}
	public String getIntervalHoli() {
		return intervalHoli;
	}
	public void setIntervalHoli(String intervalHoli) {
		this.intervalHoli = intervalHoli;
	}
	public String getIntervalPeak() {
		return intervalPeak;
	}
	public void setIntervalPeak(String intervalPeak) {
		this.intervalPeak = intervalPeak;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
}
