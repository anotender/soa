
package pl.edu.agh.soa.lab9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stringStats complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stringStats">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="charCount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="digitCount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lowerCaseLettersCount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="upperCaseLettersCount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="whiteSpacesCount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stringStats", propOrder = {
    "charCount",
    "digitCount",
    "lowerCaseLettersCount",
    "upperCaseLettersCount",
    "whiteSpacesCount"
})
public class StringStats {

    protected long charCount;
    protected long digitCount;
    protected long lowerCaseLettersCount;
    protected long upperCaseLettersCount;
    protected long whiteSpacesCount;

    /**
     * Gets the value of the charCount property.
     * 
     */
    public long getCharCount() {
        return charCount;
    }

    /**
     * Sets the value of the charCount property.
     * 
     */
    public void setCharCount(long value) {
        this.charCount = value;
    }

    /**
     * Gets the value of the digitCount property.
     * 
     */
    public long getDigitCount() {
        return digitCount;
    }

    /**
     * Sets the value of the digitCount property.
     * 
     */
    public void setDigitCount(long value) {
        this.digitCount = value;
    }

    /**
     * Gets the value of the lowerCaseLettersCount property.
     * 
     */
    public long getLowerCaseLettersCount() {
        return lowerCaseLettersCount;
    }

    /**
     * Sets the value of the lowerCaseLettersCount property.
     * 
     */
    public void setLowerCaseLettersCount(long value) {
        this.lowerCaseLettersCount = value;
    }

    /**
     * Gets the value of the upperCaseLettersCount property.
     * 
     */
    public long getUpperCaseLettersCount() {
        return upperCaseLettersCount;
    }

    /**
     * Sets the value of the upperCaseLettersCount property.
     * 
     */
    public void setUpperCaseLettersCount(long value) {
        this.upperCaseLettersCount = value;
    }

    /**
     * Gets the value of the whiteSpacesCount property.
     * 
     */
    public long getWhiteSpacesCount() {
        return whiteSpacesCount;
    }

    /**
     * Sets the value of the whiteSpacesCount property.
     * 
     */
    public void setWhiteSpacesCount(long value) {
        this.whiteSpacesCount = value;
    }

}
