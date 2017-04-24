package pl.edu.agh.soa.lab5.zad1;

import org.xml.sax.SAXException;
import pl.edu.agh.soa.lab5.zad1.factory.ObjectFactory;
import pl.edu.agh.soa.lab5.zad1.model.Book;
import pl.edu.agh.soa.lab5.zad1.model.Books;
import pl.edu.agh.soa.lab5.zad1.model.Title;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    private static ObjectFactory factory = new ObjectFactory();
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final String XML_FILE_PATH = "books.xml";
    private static final String SCHEMA_FILE_PATH = "books.xsd";

    public static void main(String[] args) {
        try {
            Books books;
            File file = new File(XML_FILE_PATH);
            books = file.exists() && !file.isDirectory() ? read(file) : factory.createBooks();

            String choice;
            while (true) {
                Runtime.getRuntime().exec("clear");
                System.out.println("Czy wprowadzić nową książkę?");
                System.out.print("> ");
                choice = in.readLine();

                if ("nie".equals(choice)) break;

                Book book = readBook();
                books.getBook().add(book);
            }

            save(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Books read(File file) throws JAXBException, SAXException {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(SCHEMA_FILE_PATH));

        JAXBContext jc = JAXBContext.newInstance(Books.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(schema);

        return (Books) unmarshaller.unmarshal(file);
    }

    private static void save(Books books) throws JAXBException {
        File file = new File(XML_FILE_PATH);
        JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(books, file);
    }

    private static Book readBook() throws IOException {
        Book book = factory.createBook();
        boolean isDataValid = false;

        do {
            String author;
            boolean nextAuthor = false;
            do {
                System.out.print("Podaj autora: ");
                author = in.readLine();

                if (isBlank(author)) continue;

                book.getAuthor().add(author);

                System.out.println("Nastepny autor?");
                System.out.print("> ");
                nextAuthor = "tak".equals(in.readLine());
            } while (nextAuthor);

            String title, lang;
            boolean nextTitle = false;
            do {
                System.out.print("Podaj jezyk tytulu: ");
                lang = in.readLine();

                System.out.print("Podaj tytul w tym jezyku: ");
                title = in.readLine();

                if (isBlank(title) || isBlank(lang)) continue;

                Title titleObj = factory.createTitle();
                titleObj.setLang(lang);
                titleObj.setValue(title);
                book.getTitle().add(titleObj);

                System.out.println("Nastepny tytul?");
                System.out.print("> ");
                nextTitle = "tak".equals(in.readLine());
            } while (nextTitle);

            System.out.print("Podaj numer ISBN ksiazki: ");
            String isbn = in.readLine();
            book.setIsbn(isbn);

            System.out.println("Czy dane sa poprawne?");
            System.out.print("> ");
            isDataValid = "tak".equals(in.readLine());
        } while (!isDataValid);

        return book;
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().length() == 0;
    }

}