//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.14 �ð� 10:10:29 PM KST 
//


package org.gs1.epcglobal.epcis;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>AggregationEventExtensionType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="AggregationEventExtensionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="childQuantityList" type="{urn:epcglobal:epcis:xsd:1}QuantityListType" minOccurs="0"/&gt;
 *         &lt;element name="sourceList" type="{urn:epcglobal:epcis:xsd:1}SourceListType" minOccurs="0"/&gt;
 *         &lt;element name="destinationList" type="{urn:epcglobal:epcis:xsd:1}DestinationListType" minOccurs="0"/&gt;
 *         &lt;element name="extension" type="{urn:epcglobal:epcis:xsd:1}AggregationEventExtension2Type" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AggregationEventExtensionType", propOrder = {
    "childQuantityList",
    "sourceList",
    "destinationList",
    "extension"
})
public class AggregationEventExtensionType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    protected QuantityListType childQuantityList;
    protected SourceListType sourceList;
    protected DestinationListType destinationList;
    protected AggregationEventExtension2Type extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * childQuantityList �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link QuantityListType }
     *     
     */
    public QuantityListType getChildQuantityList() {
        return childQuantityList;
    }

    /**
     * childQuantityList �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityListType }
     *     
     */
    public void setChildQuantityList(QuantityListType value) {
        this.childQuantityList = value;
    }

    /**
     * sourceList �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link SourceListType }
     *     
     */
    public SourceListType getSourceList() {
        return sourceList;
    }

    /**
     * sourceList �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceListType }
     *     
     */
    public void setSourceList(SourceListType value) {
        this.sourceList = value;
    }

    /**
     * destinationList �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link DestinationListType }
     *     
     */
    public DestinationListType getDestinationList() {
        return destinationList;
    }

    /**
     * destinationList �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link DestinationListType }
     *     
     */
    public void setDestinationList(DestinationListType value) {
        this.destinationList = value;
    }

    /**
     * extension �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link AggregationEventExtension2Type }
     *     
     */
    public AggregationEventExtension2Type getExtension() {
        return extension;
    }

    /**
     * extension �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link AggregationEventExtension2Type }
     *     
     */
    public void setExtension(AggregationEventExtension2Type value) {
        this.extension = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
