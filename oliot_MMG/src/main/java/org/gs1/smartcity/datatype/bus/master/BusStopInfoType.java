//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.31 �ð� 09:59:13 PM KST 
//


package org.gs1.smartcity.datatype.bus.master;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BusStopInfoType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="BusStopInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Gln" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="StopID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NameKR" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NameEN" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="GpsX" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="GpsY" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Road" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Addr" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Lines" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusStopInfoType", propOrder = {
    "gln",
    "stopID",
    "number",
    "nameKR",
    "nameEN",
    "gpsX",
    "gpsY",
    "road",
    "addr",
    "lines"
})
@XmlSeeAlso({
    BusRouteStopInfoType.class
})
@XmlRootElement
public class BusStopInfoType {

    @XmlElement(name = "Gln", required = true)
    protected String gln;
    @XmlElement(name = "StopID", required = true)
    protected String stopID;
    @XmlElement(name = "Number", required = true)
    protected String number;
    @XmlElement(name = "NameKR", required = true)
    protected String nameKR;
    @XmlElement(name = "NameEN", required = true)
    protected String nameEN;
    @XmlElement(name = "GpsX", required = true)
    protected String gpsX;
    @XmlElement(name = "GpsY", required = true)
    protected String gpsY;
    @XmlElement(name = "Road", required = true)
    protected String road;
    @XmlElement(name = "Addr", required = true)
    protected String addr;
    @XmlElement(name = "Lines", required = true)
    protected String lines;

    /**
     * gln �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGln() {
        return gln;
    }

    /**
     * gln �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGln(String value) {
        this.gln = value;
    }

    /**
     * stopID �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopID() {
        return stopID;
    }

    /**
     * stopID �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopID(String value) {
        this.stopID = value;
    }

    /**
     * number �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * number �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * nameKR �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameKR() {
        return nameKR;
    }

    /**
     * nameKR �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameKR(String value) {
        this.nameKR = value;
    }

    /**
     * nameEN �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameEN() {
        return nameEN;
    }

    /**
     * nameEN �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameEN(String value) {
        this.nameEN = value;
    }

    /**
     * gpsX �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGpsX() {
        return gpsX;
    }

    /**
     * gpsX �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGpsX(String value) {
        this.gpsX = value;
    }

    /**
     * gpsY �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGpsY() {
        return gpsY;
    }

    /**
     * gpsY �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGpsY(String value) {
        this.gpsY = value;
    }

    /**
     * road �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoad() {
        return road;
    }

    /**
     * road �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoad(String value) {
        this.road = value;
    }

    /**
     * addr �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddr() {
        return addr;
    }

    /**
     * addr �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddr(String value) {
        this.addr = value;
    }

    /**
     * lines �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLines() {
        return lines;
    }

    /**
     * lines �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLines(String value) {
        this.lines = value;
    }

}
