package pl.edu.agh.soa.lab5.zad2;

import pl.edu.agh.soa.lab5.zad2.model.Book;
import pl.edu.agh.soa.lab5.zad2.model.Books;
import pl.edu.agh.soa.lab5.zad2.model.validator.CustomValidationEventHandler;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("usage");
                return;
            }

            String schemaFilePath = args[0];
            String xmlFilePath = args[1];

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File(schemaFilePath));

            JAXBContext jc = JAXBContext.newInstance(Books.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new CustomValidationEventHandler());

            ((Books) unmarshaller.unmarshal(new File(xmlFilePath)))
                    .getBook()
                    .forEach(App::printBook);
        } catch (Exception ignored) {
        }
    }

    private static void printBook(Book b) {
        b.getTitle().forEach(t -> System.out.println("Tytuł w języku " + t.getLang() + ": " + t.getValue()));

        String authors = b.getAuthor().stream().collect(Collectors.joining(", "));
        System.out.println("Autorzy: " + authors);

        System.out.println("ISBN: " + b.getIsbn());
    }

}
