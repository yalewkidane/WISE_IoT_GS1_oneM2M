//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2016.10.31 시간 09:05:04 PM KST 
//


package org.gs1.smartcity.datatype.bus.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GPS complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
     * x 속성의 값을 가져옵니다.
     * 
     */
    public double getX() {
        return x;
    }

    /**
     * x 속성의 값을 설정합니다.
     * 
     */
    public void setX(double value) {
        this.x = value;
    }

    /**
     * y 속성의 값을 가져옵니다.
     * 
     */
    public double getY() {
        return y;
    }

    /**
     * y 속성의 값을 설정합니다.
     * 
     */
    public void setY(double value) {
        this.y = value;
    }

}
