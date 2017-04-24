
package pl.edu.agh.soa.lab5.zad4.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pracownik complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pracownik">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="okresZatrudnienia" type="{}okresZatrudnienia"/>
 *         &lt;element name="email">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="podwladni" type="{}podwladny" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pracownik", propOrder = {
    "okresZatrudnienia",
    "email",
    "podwladni"
})
public class Pracownik {

    @XmlElement(required = true)
    protected String okresZatrudnienia;
    @XmlElement(required = true)
    protected String email;
    protected List<Podwladny> podwladni;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * Gets the value of the okresZatrudnienia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOkresZatrudnienia() {
        return okresZatrudnienia;
    }

    /**
     * Sets the value of the okresZatrudnienia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOkresZatrudnienia(String value) {
        this.okresZatrudnienia = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the podwladni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the podwladni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPodwladni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Podwladny }
     * 
     * 
     */
    public List<Podwladny> getPodwladni() {
        if (podwladni == null) {
            podwladni = new ArrayList<Podwladny>();
        }
        return this.podwladni;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
