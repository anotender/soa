package pl.edu.agh.soa.lab8.zad3.controller;

import pl.edu.agh.soa.lab8.zad3.model.Book;
import pl.edu.agh.soa.lab8.zad3.repository.BookRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class BookController {

    @EJB
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void update() {
    }

    public void delete(long id){
        bookRepository.delete(id);
    }

}
