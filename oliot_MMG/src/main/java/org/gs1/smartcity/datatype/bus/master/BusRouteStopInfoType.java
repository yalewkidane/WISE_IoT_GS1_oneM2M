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
 * <p>BusRouteStopInfoType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="BusRouteStopInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ns.example.com/epcisapp/bus}BusStopInfoType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusRouteStopInfoType", propOrder = {
    "index"
})
@XmlRootElement(name="BusRouteStop")
public class BusRouteStopInfoType
    extends BusStopInfoType
{

    @XmlElement(name = "Index")
    protected int index;

    /**
     * index �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public int getIndex() {
        return index;
    }

    /**
     * index �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setIndex(int value) {
        this.index = value;
    }

}
