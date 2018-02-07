package org.oliot.bis.tutorial;

import java.util.Calendar;

import org.oliot.bis.model.BusEstimationSemantic;
import org.oliot.bis.model.BusLineSematic;
import org.oliot.bis.model.BusStopSemantic;

public class Printer {
	
//	public static void main(String[] args) {
//	System.out.println((Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000))+":00");	
//	}
	
	
public static void printBusEstimationSemantic(BusEstimationSemantic busEstimation) {
		
		System.out.println("id : "+busEstimation.getId());
		System.out.println("refBusStop : "+busEstimation.getRefBusStop());
		System.out.println("refBusLine : "+busEstimation.getRefBusLine());
		System.out.println("remainingDistances : "+busEstimation.getRemainingDistances());
		System.out.println("remainingTimes : "+busEstimation.getRemainingTimes());
		System.out.println("destinationBusLines : "+busEstimation.getDestinationBusLines());
		System.out.println("shortID : "+busEstimation.getShortID());
		System.out.println("remainingStations : "+busEstimation.getRemainingStations());
		System.out.println("companyName : "+busEstimation.getCompanyName());
		System.out.println("location : "+busEstimation.getLocation());
		System.out.println("dateModified : "+busEstimation.getDateModified());
		System.out.println("---------------------------------------------------------");
		
	}
	
	public static void printBusLineSemantic(BusLineSematic busLine) {
	          
		System.out.println("id : "+busLine.getId());
		System.out.println("refBusStops : "+busLine.getRefBusStops());
		System.out.println("localID : "+busLine.getLocalID());
		System.out.println("shortID : "+busLine.getShortID());
		System.out.println("name : "+busLine.getName());
		System.out.println("refStartBusStop : "+busLine.getRefStartBusStop());
		System.out.println("refEndBusStop : "+busLine.getRefEndBusStop());
		System.out.println("busLineType : "+busLine.getBusLineType());
		System.out.println("startTime : "+busLine.getStartTime());
		System.out.println("endTime : "+busLine.getEndTime());
		System.out.println("intervalNorm : "+busLine.getIntervalNorm());
		System.out.println("intervalHoli : "+busLine.getIntervalHoli());
		System.out.println("intervalPeak : "+busLine.getIntervalPeak());
		System.out.println("dateModified : "+busLine.getDateModified());
	}
	
public static void printBusStopSemantic(BusStopSemantic busStop) {
		
		System.out.println("id : "+busStop.getId());
		System.out.println("refBuses : "+busStop.getRefBuses());
		System.out.println("shortID : "+busStop.getShortID());
		System.out.println("busStopCount : "+busStop.getBusStopCount());
		System.out.println("name : "+busStop.getName());
		System.out.println("location : "+busStop.getLocation());
		System.out.println("address : "+busStop.getAddress());
		System.out.println("direction : "+busStop.getDirection());
		System.out.println("refBusLines : "+busStop.getRefBusLines());
		System.out.println("dateModified : "+busStop.getDateModified());
	}

}
