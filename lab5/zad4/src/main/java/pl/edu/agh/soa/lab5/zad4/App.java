package pl.edu.agh.soa.lab5.zad4;

import org.xml.sax.SAXException;
import pl.edu.agh.soa.lab5.zad4.model.*;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws JAXBException, SAXException, IOException {
//        ObjectFactory of = new ObjectFactory();
//        Pracownicy pracownicy = of.createPracownicy();
//
//        Pracownik pracownik1 = of.createPracownik();
//        pracownik1.setEmail("email@email.com");
//        pracownik1.setId("1");
//        pracownik1.setOkresZatrudnienia("bezterminowo");
//
//
//        Pracownik pracownik2 = of.createPracownik();
//        pracownik2.setEmail("email@email.com");
//        pracownik2.setId("2");
//        pracownik2.setOkresZatrudnienia("bezterminowo");
//
//        Podwladny podwladny = of.createPodwladny();
//        podwladny.setIdRef("1");
//        pracownik2.getPodwladni().add(podwladny);
//
//        pracownicy.getPracownik().add(pracownik1);
//        pracownicy.getPracownik().add(pracownik2);
//
//        File file = new File("pracownicy.xml");
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("pracownicy.xsd"));
//        JAXBContext jaxbContext = JAXBContext.newInstance(Pracownicy.class);
////        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
////
////        // output pretty printed
////        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
////
////        jaxbMarshaller.marshal(pracownicy, file);
//
//        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//        unmarshaller.setSchema(schema);
//        unmarshaller.setEventHandler(event -> System.out.println(event.getMessage()));

        schema.newValidator().validate(new StreamSource("pracownicy.xml"));

//        ((Pracownicy) unmarshaller.unmarshal(new File("pracownicy.xml")))
//                .getPracownik()
//                .forEach(p -> System.out.println(p.getOkresZatrudnienia()));
    }

}
