package pl.edu.agh.soa.lab6.zad4.repository;

import pl.edu.agh.soa.lab6.zad4.model.Book;
import pl.edu.agh.soa.lab6.zad4.model.Library;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.List;
import java.util.Optional;

@Singleton
@Startup
public class BookRepository {

    private Library library;

    @PostConstruct
    void init() {
        String xmlFileName = System.getProperty("jboss.server.config.dir") + "/books.xml";
        String schemaFileName = System.getProperty("jboss.server.config.dir") + "/books.xsd";

        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File(schemaFileName));

            Unmarshaller unmarshaller = JAXBContext
                    .newInstance(Library.class)
                    .createUnmarshaller();
            unmarshaller.setSchema(schema);

            library = (Library) unmarshaller.unmarshal(new File(xmlFileName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> findAll() {
        return library.getBooks();
    }

    public Optional<Book> findOneByIsbn(String isbn) {
        return findAll()
                .stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst();
    }

}
