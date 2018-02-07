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
 * <p>GPS complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="GPS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="X" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GPS", propOrder = {
    "x",
    "y"
})
public class GPS {

    @XmlElement(name = "X")
    protected double x;
    @XmlElement(name = "Y")
    protected double y;

    /**
     * x �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public double getX() {
        return x;
    }

    /**
     * x �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setX(double value) {
        this.x = value;
    }

    /**
     * y �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public double getY() {
        return y;
    }

    /**
     * y �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setY(double value) {
        this.y = value;
    }

}
