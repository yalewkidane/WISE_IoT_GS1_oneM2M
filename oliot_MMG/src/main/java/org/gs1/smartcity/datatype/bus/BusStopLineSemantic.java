package org.gs1.smartcity.datatype.bus;


import java.util.List;

public class BusStopLineSemantic {
	
	private List<BusLineSemantic> busLineList;
	private List<BusStopLine> busStopLine ;
	
	
	public List<BusLineSemantic> getBusLineList() {
		return busLineList;
	}
	public void setBusLineList(List<BusLineSemantic> busLineList) {
		this.busLineList = busLineList;
	}
	public List<BusStopLine> getBusStopLine() {
		return busStopLine;
	}
	public void setBusStopLine(List<BusStopLine> busStopLine) {
		this.busStopLine = busStopLine;
	}

}
