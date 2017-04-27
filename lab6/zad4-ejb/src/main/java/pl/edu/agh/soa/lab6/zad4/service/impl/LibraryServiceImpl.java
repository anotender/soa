package pl.edu.agh.soa.lab6.zad4.service.impl;

import pl.edu.agh.soa.lab6.zad4.exception.BookAlreadyBorrowedException;
import pl.edu.agh.soa.lab6.zad4.exception.BookAlreadyReservedException;
import pl.edu.agh.soa.lab6.zad4.exception.BookNotFoundException;
import pl.edu.agh.soa.lab6.zad4.model.Book;
import pl.edu.agh.soa.lab6.zad4.repository.BookRepository;
import pl.edu.agh.soa.lab6.zad4.service.api.LibraryService;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Remote(LibraryService.class)
public class LibraryServiceImpl implements LibraryService {

    @EJB
    private BookRepository bookRepository;

    public void borrowBook(String isbn, String pesel) throws BookNotFoundException, BookAlreadyReservedException, BookAlreadyBorrowedException {
        Book book = bookRepository
                .findOneByIsbn(isbn)
                .orElseThrow(BookNotFoundException::new);

        if (!isEmpty(book.getBorrowedBy())) {
            throw new BookAlreadyBorrowedException();
        } else if (isEmpty(book.getReservedBy()) || book.getReservedBy().equals(pesel)) {
            book.setBorrowedBy(pesel);
            book.setReservedBy("");
        } else {
            throw new BookAlreadyReservedException();
        }
    }

    public void reserveBook(String isbn, String pesel) throws BookNotFoundException, BookAlreadyReservedException {
        Book book = bookRepository
                .findOneByIsbn(isbn)
                .orElseThrow(BookNotFoundException::new);

        if (isEmpty(book.getReservedBy()))
            book.setReservedBy(pesel);
        else
            throw new BookAlreadyReservedException();
    }

    public void returnBook(String isbn) throws BookNotFoundException {
        Book book = bookRepository
                .findOneByIsbn(isbn)
                .orElseThrow(BookNotFoundException::new);

        if (!isEmpty(book.getBorrowedBy())) {
            book.setBorrowedBy("");
        }
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    private boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }
}
