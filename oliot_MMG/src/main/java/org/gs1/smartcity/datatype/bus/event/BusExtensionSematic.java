
//
//�� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
//<a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
//�� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
//���� ��¥: 2016.10.31 �ð� 09:05:04 PM KST 
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
*       &lt;/sequence&gt;
*     &lt;/restriction&gt;
*   &lt;/complexContent&gt;
* &lt;/complexType&gt;
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusExtensionSematic", propOrder = {
 "registration",
 "driverID",
 "vehicleNumber",
 "busLine",
 "accident",
 "maintenance",
 "mileage",
 "gps",
 "direction"
})
public class BusExtensionSematic {

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

 /**
  * registration �Ӽ��� ���� �����ɴϴ�.
  * 
  * @return
  *     possible object is
  *     {@link BusRegistration }
  *     
  */
 public BusRegistration getRegistration() {
     return registration;
 }

 /**
  * registration �Ӽ��� ���� �����մϴ�.
  * 
  * @param value
  *     allowed object is
  *     {@link BusRegistration }
  *     
  */
 public void setRegistration(BusRegistration value) {
     this.registration = value;
 }

 /**
  * driverID �Ӽ��� ���� �����ɴϴ�.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getDriverID() {
     return driverID;
 }

 /**
  * driverID �Ӽ��� ���� �����մϴ�.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setDriverID(String value) {
     this.driverID = value;
 }

 /**
  * vehicleNumber �Ӽ��� ���� �����ɴϴ�.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getVehicleNumber() {
     return vehicleNumber;
 }

 /**
  * vehicleNumber �Ӽ��� ���� �����մϴ�.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setVehicleNumber(String value) {
     this.vehicleNumber = value;
 }

 /**
  * busLine �Ӽ��� ���� �����ɴϴ�.
  * 
  * @return
  *     possible object is
  *     {@link BusLine }
  *     
  */
 public BusLine getBusLine() {
     return busLine;
 }

 /**
  * busLine �Ӽ��� ���� �����մϴ�.
  * 
  * @param value
  *     allowed object is
  *     {@link BusLine }
  *     
  */
 public void setBusLine(BusLine value) {
     this.busLine = value;
 }

 /**
  * accident �Ӽ��� ���� �����ɴϴ�.
  * 
  * @return
  *     possible object is
  *     {@link Accident }
  *     
  */
 public Accident getAccident() {
     return accident;
 }

 /**
  * accident �Ӽ��� ���� �����մϴ�.
  * 
  * @param value
  *     allowed object is
  *     {@link Accident }
  *     
  */
 public void setAccident(Accident value) {
     this.accident = value;
 }

 /**
  * maintenance �Ӽ��� ���� �����ɴϴ�.
  * 
  * @return
  *     possible object is
  *     {@link Maintenance }
  *     
  */
 public Maintenance getMaintenance() {
     return maintenance;
 }

 /**
  * maintenance �Ӽ��� ���� �����մϴ�.
  * 
  * @param value
  *     allowed object is
  *     {@link Maintenance }
  *     
  */
 public void setMaintenance(Maintenance value) {
     this.maintenance = value;
 }

 /**
  * mileage �Ӽ��� ���� �����ɴϴ�.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getMileage() {
     return mileage;
 }

 /**
  * mileage �Ӽ��� ���� �����մϴ�.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setMileage(String value) {
     this.mileage = value;
 }

 /**
  * gps �Ӽ��� ���� �����ɴϴ�.
  * 
  * @return
  *     possible object is
  *     {@link GPS }
  *     
  */
 public GPS getGPS() {
     return gps;
 }

 /**
  * gps �Ӽ��� ���� �����մϴ�.
  * 
  * @param value
  *     allowed object is
  *     {@link GPS }
  *     
  */
 public void setGPS(GPS value) {
     this.gps = value;
 }

 /**
  * direction �Ӽ��� ���� �����ɴϴ�.
  * 
  * @return
  *     possible object is
  *     {@link Integer }
  *     
  */
 public Integer getDirection() {
     return direction;
 }

 /**
  * direction �Ӽ��� ���� �����մϴ�.
  * 
  * @param value
  *     allowed object is
  *     {@link Integer }
  *     
  */
 public void setDirection(Integer value) {
     this.direction = value;
 }

}
