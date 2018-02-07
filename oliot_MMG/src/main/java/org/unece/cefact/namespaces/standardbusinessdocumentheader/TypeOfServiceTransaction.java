//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.14 �ð� 10:10:29 PM KST 
//


package org.unece.cefact.namespaces.standardbusinessdocumentheader;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TypeOfServiceTransaction�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * <p>
 * <pre>
 * &lt;simpleType name="TypeOfServiceTransaction"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="RequestingServiceTransaction"/&gt;
 *     &lt;enumeration value="RespondingServiceTransaction"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TypeOfServiceTransaction")
@XmlEnum
public enum TypeOfServiceTransaction {

    @XmlEnumValue("RequestingServiceTransaction")
    REQUESTING_SERVICE_TRANSACTION("RequestingServiceTransaction"),
    @XmlEnumValue("RespondingServiceTransaction")
    RESPONDING_SERVICE_TRANSACTION("RespondingServiceTransaction");
    private final String value;

    TypeOfServiceTransaction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeOfServiceTransaction fromValue(String v) {
        for (TypeOfServiceTransaction c: TypeOfServiceTransaction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
