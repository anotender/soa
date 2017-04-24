
package pl.edu.agh.soa.lab5.zad4.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.agh.soa.lab5.zad4.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.soa.lab5.zad4.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Pracownicy }
     * 
     */
    public Pracownicy createPracownicy() {
        return new Pracownicy();
    }

    /**
     * Create an instance of {@link Pracownik }
     * 
     */
    public Pracownik createPracownik() {
        return new Pracownik();
    }

    /**
     * Create an instance of {@link Podwladny }
     * 
     */
    public Podwladny createPodwladny() {
        return new Podwladny();
    }

}
