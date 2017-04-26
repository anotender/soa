package pl.edu.agh.soa.lab6.zad4;

import pl.edu.agh.soa.lab6.zad4.exception.BookAlreadyReservedException;
import pl.edu.agh.soa.lab6.zad4.exception.BookNotFoundException;
import pl.edu.agh.soa.lab6.zad4.model.Book;
import pl.edu.agh.soa.lab6.zad4.service.api.LibraryService;
import pl.edu.agh.soa.lab6.zad4.service.impl.LibraryServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.List;

@ManagedBean
public class Library {

    private LibraryService libraryService;

    @PostConstruct
    public void init() {
        try {
            libraryService = lookupRemoteLibraryService();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getBooks() {
        return libraryService.getBooks();
    }

    public void reserveBook(String isbn){
        try {
            libraryService.reserveBook(isbn,"123");
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        } catch (BookAlreadyReservedException e) {
            e.printStackTrace();
        }
    }

    private LibraryService lookupRemoteLibraryService() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);

        final String appName = "";
        final String moduleName = "zad4-ejb";
        final String distinctName = "";
        final String beanName = LibraryServiceImpl.class.getSimpleName();
        final String viewClassName = LibraryService.class.getName();

        return (LibraryService) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
    }

}
