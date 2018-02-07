//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.14 �ð� 10:10:29 PM KST 
//


package org.unece.cefact.namespaces.standardbusinessdocumentheader;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ServiceTransaction complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="ServiceTransaction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="TypeOfServiceTransaction" type="{http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader}TypeOfServiceTransaction" /&gt;
 *       &lt;attribute name="IsNonRepudiationRequired" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IsAuthenticationRequired" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IsNonRepudiationOfReceiptRequired" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IsIntegrityCheckRequired" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IsApplicationErrorResponseRequested" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TimeToAcknowledgeReceipt" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TimeToAcknowledgeAcceptance" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TimeToPerform" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Recurrence" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceTransaction")
public class ServiceTransaction
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlAttribute(name = "TypeOfServiceTransaction")
    protected TypeOfServiceTransaction typeOfServiceTransaction;
    @XmlAttribute(name = "IsNonRepudiationRequired")
    protected String isNonRepudiationRequired;
    @XmlAttribute(name = "IsAuthenticationRequired")
    protected String isAuthenticationRequired;
    @XmlAttribute(name = "IsNonRepudiationOfReceiptRequired")
    protected String isNonRepudiationOfReceiptRequired;
    @XmlAttribute(name = "IsIntegrityCheckRequired")
    protected String isIntegrityCheckRequired;
    @XmlAttribute(name = "IsApplicationErrorResponseRequested")
    protected String isApplicationErrorResponseRequested;
    @XmlAttribute(name = "TimeToAcknowledgeReceipt")
    protected String timeToAcknowledgeReceipt;
    @XmlAttribute(name = "TimeToAcknowledgeAcceptance")
    protected String timeToAcknowledgeAcceptance;
    @XmlAttribute(name = "TimeToPerform")
    protected String timeToPerform;
    @XmlAttribute(name = "Recurrence")
    protected String recurrence;

    /**
     * typeOfServiceTransaction �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link TypeOfServiceTransaction }
     *     
     */
    public TypeOfServiceTransaction getTypeOfServiceTransaction() {
        return typeOfServiceTransaction;
    }

    /**
     * typeOfServiceTransaction �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeOfServiceTransaction }
     *     
     */
    public void setTypeOfServiceTransaction(TypeOfServiceTransaction value) {
        this.typeOfServiceTransaction = value;
    }

    /**
     * isNonRepudiationRequired �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsNonRepudiationRequired() {
        return isNonRepudiationRequired;
    }

    /**
     * isNonRepudiationRequired �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsNonRepudiationRequired(String value) {
        this.isNonRepudiationRequired = value;
    }

    /**
     * isAuthenticationRequired �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsAuthenticationRequired() {
        return isAuthenticationRequired;
    }

    /**
     * isAuthenticationRequired �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsAuthenticationRequired(String value) {
        this.isAuthenticationRequired = value;
    }

    /**
     * isNonRepudiationOfReceiptRequired �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsNonRepudiationOfReceiptRequired() {
        return isNonRepudiationOfReceiptRequired;
    }

    /**
     * isNonRepudiationOfReceiptRequired �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsNonRepudiationOfReceiptRequired(String value) {
        this.isNonRepudiationOfReceiptRequired = value;
    }

    /**
     * isIntegrityCheckRequired �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsIntegrityCheckRequired() {
        return isIntegrityCheckRequired;
    }

    /**
     * isIntegrityCheckRequired �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsIntegrityCheckRequired(String value) {
        this.isIntegrityCheckRequired = value;
    }

    /**
     * isApplicationErrorResponseRequested �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsApplicationErrorResponseRequested() {
        return isApplicationErrorResponseRequested;
    }

    /**
     * isApplicationErrorResponseRequested �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsApplicationErrorResponseRequested(String value) {
        this.isApplicationErrorResponseRequested = value;
    }

    /**
     * timeToAcknowledgeReceipt �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeToAcknowledgeReceipt() {
        return timeToAcknowledgeReceipt;
    }

    /**
     * timeToAcknowledgeReceipt �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeToAcknowledgeReceipt(String value) {
        this.timeToAcknowledgeReceipt = value;
    }

    /**
     * timeToAcknowledgeAcceptance �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeToAcknowledgeAcceptance() {
        return timeToAcknowledgeAcceptance;
    }

    /**
     * timeToAcknowledgeAcceptance �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeToAcknowledgeAcceptance(String value) {
        this.timeToAcknowledgeAcceptance = value;
    }

    /**
     * timeToPerform �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeToPerform() {
        return timeToPerform;
    }

    /**
     * timeToPerform �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeToPerform(String value) {
        this.timeToPerform = value;
    }

    /**
     * recurrence �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecurrence() {
        return recurrence;
    }

    /**
     * recurrence �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecurrence(String value) {
        this.recurrence = value;
    }

}
