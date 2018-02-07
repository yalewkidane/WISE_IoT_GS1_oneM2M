package org.gs1.smartcity.datatype.bus;

import org.gs1.smartcity.datatype.bus.master.BusIntervalType;
import org.gs1.smartcity.datatype.bus.master.BusStopInfoType;
import org.gs1.smartcity.datatype.bus.master.BusTimeType;

public class BusLineInfoType {

	private String gsrn;
	private String lineid;
	private String number;
	private String busType;
	private String company;
	private BusStopInfoType startPoint;
	private BusStopInfoType endPoint;
	private BusStopInfoType turnPoint;
	private BusTimeType startTime;
	private BusTimeType endTime;
	private BusTimeType turnStartTime;
	private BusTimeType turnEndTime;
	private BusIntervalType interval;
	private int stopCount;
	private double halfDistance;
	private int avgRunTime;

	public BusLineInfoType() {
		
		stopCount = 0;
		halfDistance = 0;
		avgRunTime = 0;
	}
	
	public String getGsrn() {

		return gsrn;
	}

	public void setGsrn(String value) {

		this.gsrn = value;
	}

	public String getLineID() {

		return lineid;
	}

	public void setLineID(String value) {

		this.lineid = value;
	}

	public String getNumber() {

		return number;
	}

	public void setNumber(String value) {

		this.number = value;
	}

	public String getBusType() {

		return busType;
	}

	public void setBusType(String value) {

		this.busType = value;
	}

	public String getCompany() {

		return company;
	}

	public void setCompany(String value) {

		this.company = value;
	}

	public BusStopInfoType getStartPoint() {

		return startPoint;
	}

	public void setStartPoint(BusStopInfoType value) {

		this.startPoint = value;
	}

	public BusStopInfoType getEndPoint() {

		return endPoint;
	}

	public void setEndPoint(BusStopInfoType value) {

		this.endPoint = value;
	}

	public BusStopInfoType getTurnPoint() {

		return turnPoint;
	}

	public void setTurnPoint(BusStopInfoType value) {

		this.turnPoint = value;
	}

	public BusTimeType getStartTime() {

		return startTime;
	}

	public void setStartTime(BusTimeType value) {

		this.startTime = value;
	}

	public BusTimeType getEndTime() {

		return endTime;
	}

	public void setEndTime(BusTimeType value) {

		this.endTime = value;
	}

	public BusTimeType getTurnStartTime() {

		return turnStartTime;
	}

	public void setTurnStartTime(BusTimeType value) {

		this.turnStartTime = value;
	}

	public BusTimeType getTurnEndTime() {

		return turnEndTime;
	}

	public void setTurnEndTime(BusTimeType value) {

		this.turnEndTime = value;
	}

	public BusIntervalType getInterval() {

		return interval;
	}

	public void setInterval(BusIntervalType value) {

		this.interval = value;
	}

	public int getStopCount() {

		return stopCount;
	}

	public void setStopCount(int value) {

		this.stopCount = value;
	}

	public double getHalfDistance() {

		return halfDistance;
	}

	public void setHalfDistance(double value) {

		this.halfDistance = value;
	}

	public int getAvgRunTime() {

		return avgRunTime;
	}

	public void setAvgRunTime(int value) {

		this.avgRunTime = value;
	}
}
