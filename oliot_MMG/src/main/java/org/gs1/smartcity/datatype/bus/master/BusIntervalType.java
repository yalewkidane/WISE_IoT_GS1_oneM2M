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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BusIntervalType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="BusIntervalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Interval" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IntervalNrom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IntervalPeak" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IntervalHoli" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IntervalSat" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IntervalSun" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusIntervalType", propOrder = {
    "interval",
    "intervalNorm",
    "intervalPeak",
    "intervalHoli",
    "intervalSat",
    "intervalSun"
})
@XmlRootElement
public class BusIntervalType {

    @XmlElement(name = "Interval")
    protected String interval;
    @XmlElement(name = "IntervalNorm")
    protected String intervalNorm;
    @XmlElement(name = "IntervalPeak")
    protected String intervalPeak;
    @XmlElement(name = "IntervalHoli")
    protected String intervalHoli;
    @XmlElement(name = "IntervalSat")
    protected String intervalSat;
    @XmlElement(name = "IntervalSun")
    protected String intervalSun;

    /**
     * interval �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterval() {
        return interval;
    }

    /**
     * interval �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterval(String value) {
        this.interval = value;
    }

    /**
     * intervalNrom �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntervalNorm() {
        return intervalNorm;
    }

    /**
     * intervalNrom �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntervalNorm(String value) {
        this.intervalNorm = value;
    }

    /**
     * intervalPeak �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntervalPeak() {
        return intervalPeak;
    }

    /**
     * intervalPeak �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntervalPeak(String value) {
        this.intervalPeak = value;
    }
    
    /**
     * intervalHoli �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntervalHoli() {
        return intervalHoli;
    }

    /**
     * intervalHoli �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntervalHoli(String value) {
        this.intervalHoli = value;
    }

    /**
     * intervalSat �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntervalSat() {
        return intervalSat;
    }

    /**
     * intervalSat �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntervalSat(String value) {
        this.intervalSat = value;
    }

    /**
     * intervalSun �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntervalSun() {
        return intervalSun;
    }

    /**
     * intervalSun �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntervalSun(String value) {
        this.intervalSun = value;
    }

}
