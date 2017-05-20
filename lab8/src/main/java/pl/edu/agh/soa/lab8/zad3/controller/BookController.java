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

    private Book newBook = new Book();

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void save() {
        bookRepository.save(newBook);
        newBook = new Book();
    }

    public void update(Book book) {
        bookRepository.update(book.getId(), book);
    }

    public void delete(long id) {
        bookRepository.delete(id);
    }

    public Book getNewBook() {
        return newBook;
    }

    public void setNewBook(Book newBook) {
        this.newBook = newBook;
    }
}
