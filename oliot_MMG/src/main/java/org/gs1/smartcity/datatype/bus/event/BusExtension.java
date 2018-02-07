//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.31 �ð� 09:05:04 PM KST 
//


package org.gs1.smartcity.datatype.bus.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BusExtension complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="BusExtension"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Registration" type="{http://ns.example.com/epcisapp/bus}BusRegistration" minOccurs="0"/&gt;
 *         &lt;element name="DriverID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VehicleNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BusLine" type="{http://ns.example.com/epcisapp/bus}BusLine" minOccurs="0"/&gt;
 *         &lt;element name="Accident" type="{http://ns.example.com/epcisapp/bus}Accident" minOccurs="0"/&gt;
 *         &lt;element name="Maintenance" type="{http://ns.example.com/epcisapp/bus}Maintenance" minOccurs="0"/&gt;
 *         &lt;element name="Mileage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GPS" type="{http://ns.example.com/epcisapp/bus}GPS" minOccurs="0"/&gt;
 *         &lt;element name="Direction" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusExtension", propOrder = {
    "registration",
    "driverID",
    "vehicleNumber",
    "busLine",
    "accident",
    "maintenance",
    "mileage",
    "gps",
    "direction",
    "refBusStop",
    "refBusLine",
    "busNumber",
    "remainTime",
    "remainDistance",
    "remainStation",
    "gpsTime",
    "companyName"
})
public class BusExtension {

    @XmlElement(name = "Registration")
    protected BusRegistration registration;
    @XmlElement(name = "DriverID")
    protected String driverID;
    @XmlElement(name = "VehicleNumber")
    protected String vehicleNumber;
    @XmlElement(name = "BusLine")
    protected BusLine busLine;
    @XmlElement(name = "Accident")
    protected Accident accident;
    @XmlElement(name = "Maintenance")
    protected Maintenance maintenance;
    @XmlElement(name = "Mileage")
    protected String mileage;
    @XmlElement(name = "GPS")
    protected GPS gps;
    @XmlElement(name = "Direction")
    protected Integer direction;
    
    
    // epc list protected String id;   //"urn:entity:busan:transport:bus:busId:<busId>",
    protected String refBusStop;   //"urn:entity:busan:transport:bus:busStopId:<busStopId>",
    protected String refBusLine;   //"urn:entity:busan:transport:bus:buslineId:<buslineId>",
    protected String busNumber;   // shortID 101,
    //direction;   //"0",
    protected String remainTime;   //"P3Y6M4DT12H30M5S",
    protected String remainDistance;   //100,
    protected String remainStation;   //2,
    protected String gpsTime;   //"2017-11-05T08:15:30-05:00",
    protected String companyName;
	//GPS: "locationCoordinates":[36.372,127.363] "refBusStop"
	public BusRegistration getRegistration() {
		return registration;
	}
	public void setRegistration(BusRegistration registration) {
		this.registration = registration;
	}
	public String getDriverID() {
		return driverID;
	}
	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public BusLine getBusLine() {
		return busLine;
	}
	public void setBusLine(BusLine busLine) {
		this.busLine = busLine;
	}
	public Accident getAccident() {
		return accident;
	}
	public void setAccident(Accident accident) {
		this.accident = accident;
	}
	public Maintenance getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(Maintenance maintenance) {
		this.maintenance = maintenance;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public GPS getGPS() {
		return gps;
	}
	public void setGPS(GPS gps) {
		this.gps = gps;
	}
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	public String getRefBusStop() {
		return refBusStop;
	}
	public void setRefBusStop(String refBusStop) {
		this.refBusStop = refBusStop;
	}
	public String getRefBusLine() {
		return refBusLine;
	}
	public void setRefBusLine(String refBusLine) {
		this.refBusLine = refBusLine;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getRemainTime() {
		return remainTime;
	}
	public void setRemainTime(String remainTime) {
		this.remainTime = remainTime;
	}
	public String getRemainDistance() {
		return remainDistance;
	}
	public void setRemainDistance(String remainDistance) {
		this.remainDistance = remainDistance;
	}
	public String getRemainStation() {
		return remainStation;
	}
	public void setRemainStation(String remainStation) {
		this.remainStation = remainStation;
	}
	public String getGpsTime() {
		return gpsTime;
	}
	public void setGpsTime(String gpsTime) {
		this.gpsTime = gpsTime;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
   

	/**
     * registration �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link BusRegistration }
     *     
     */
   

}
