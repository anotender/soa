
package pl.edu.agh.soa.lab5.zad4.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bezterminowy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="bezterminowy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="bezterminowo"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "bezterminowy")
@XmlEnum
public enum Bezterminowy {

    @XmlEnumValue("bezterminowo")
    BEZTERMINOWO("bezterminowo");
    private final String value;

    Bezterminowy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Bezterminowy fromValue(String v) {
        for (Bezterminowy c: Bezterminowy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
