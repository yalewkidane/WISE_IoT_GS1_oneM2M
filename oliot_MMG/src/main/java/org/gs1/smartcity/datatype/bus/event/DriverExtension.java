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
 * <p>DriverExtension complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="DriverExtension"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Employed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Unemployed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Bus" type="{http://ns.example.com/epcisapp/bus}Bus" minOccurs="0"/&gt;
 *         &lt;element name="Accident" type="{http://ns.example.com/epcisapp/bus}Accident" minOccurs="0"/&gt;
 *         &lt;element name="Rating" type="{http://ns.example.com/epcisapp/bus}Rating" minOccurs="0"/&gt;
 *         &lt;element name="Check-in" type="{http://ns.example.com/epcisapp/bus}Check" minOccurs="0"/&gt;
 *         &lt;element name="Check-out" type="{http://ns.example.com/epcisapp/bus}Check" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DriverExtension", propOrder = {
    "employed",
    "unemployed",
    "bus",
    "accident",
    "rating",
    "checkIn",
    "checkOut"
})
public class DriverExtension {

    @XmlElement(name = "Employed")
    protected String employed;
    @XmlElement(name = "Unemployed")
    protected String unemployed;
    @XmlElement(name = "Bus")
    protected Bus bus;
    @XmlElement(name = "Accident")
    protected Accident accident;
    @XmlElement(name = "Rating")
    protected Rating rating;
    @XmlElement(name = "Check-in")
    protected Check checkIn;
    @XmlElement(name = "Check-out")
    protected Check checkOut;

    /**
     * employed �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployed() {
        return employed;
    }

    /**
     * employed �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployed(String value) {
        this.employed = value;
    }

    /**
     * unemployed �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnemployed() {
        return unemployed;
    }

    /**
     * unemployed �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnemployed(String value) {
        this.unemployed = value;
    }

    /**
     * bus �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Bus }
     *     
     */
    public Bus getBus() {
        return bus;
    }

    /**
     * bus �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Bus }
     *     
     */
    public void setBus(Bus value) {
        this.bus = value;
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
     * rating �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Rating }
     *     
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * rating �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Rating }
     *     
     */
    public void setRating(Rating value) {
        this.rating = value;
    }

    /**
     * checkIn �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Check }
     *     
     */
    public Check getCheckIn() {
        return checkIn;
    }

    /**
     * checkIn �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Check }
     *     
     */
    public void setCheckIn(Check value) {
        this.checkIn = value;
    }

    /**
     * checkOut �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Check }
     *     
     */
    public Check getCheckOut() {
        return checkOut;
    }

    /**
     * checkOut �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Check }
     *     
     */
    public void setCheckOut(Check value) {
        this.checkOut = value;
    }

}
