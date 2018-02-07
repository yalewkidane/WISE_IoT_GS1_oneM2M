package org.gs1.smartcity.datatype.bus;

public class BusStopLine {
	
	private String id;  //lineid_nodeID
	private String busLine; //lineid
	private String busStop; //nodeID
	private String arsNo;
	private String lineNo;
	private String busStopIndex;
	private String busStopName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBusLine() {
		return busLine;
	}
	public void setBusLine(String busLine) {
		this.busLine = busLine;
	}
	public String getBusStop() {
		return busStop;
	}
	public void setBusStop(String busStop) {
		this.busStop = busStop;
	}
	public String getArsNo() {
		return arsNo;
	}
	public void setArsNo(String arsNo) {
		this.arsNo = arsNo;
	}
	public String getLineNo() {
		return lineNo;
	}
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	public String getBusStopIndex() {
		return busStopIndex;
	}
	public void setBusStopIndex(String busStopIndex) {
		this.busStopIndex = busStopIndex;
	}
	public String getBusStopName() {
		return busStopName;
	}
	public void setBusStopName(String busStopName) {
		this.busStopName = busStopName;
	}
	

	
}
