//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.14 �ð� 10:10:29 PM KST 
//


package org.unece.cefact.namespaces.standardbusinessdocumentheader;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>DocumentIdentification complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="DocumentIdentification"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Standard" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TypeVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="InstanceIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MultipleType" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="CreationDateAndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentIdentification", propOrder = {
    "standard",
    "typeVersion",
    "instanceIdentifier",
    "type",
    "multipleType",
    "creationDateAndTime"
})
public class DocumentIdentification
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "Standard", required = true)
    protected String standard;
    @XmlElement(name = "TypeVersion", required = true)
    protected String typeVersion;
    @XmlElement(name = "InstanceIdentifier", required = true)
    protected String instanceIdentifier;
    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "MultipleType")
    protected Boolean multipleType;
    @XmlElement(name = "CreationDateAndTime", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar creationDateAndTime;

    /**
     * standard �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandard() {
        return standard;
    }

    /**
     * standard �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandard(String value) {
        this.standard = value;
    }

    /**
     * typeVersion �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeVersion() {
        return typeVersion;
    }

    /**
     * typeVersion �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeVersion(String value) {
        this.typeVersion = value;
    }

    /**
     * instanceIdentifier �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceIdentifier() {
        return instanceIdentifier;
    }

    /**
     * instanceIdentifier �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceIdentifier(String value) {
        this.instanceIdentifier = value;
    }

    /**
     * type �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * type �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * multipleType �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMultipleType() {
        return multipleType;
    }

    /**
     * multipleType �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMultipleType(Boolean value) {
        this.multipleType = value;
    }

    /**
     * creationDateAndTime �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getCreationDateAndTime() {
        return creationDateAndTime;
    }

    /**
     * creationDateAndTime �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDateAndTime(Calendar value) {
        this.creationDateAndTime = value;
    }

}
