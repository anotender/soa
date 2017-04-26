package pl.edu.agh.soa.lab6.zad4.service.api;

import pl.edu.agh.soa.lab6.zad4.exception.BookAlreadyBorrowedException;
import pl.edu.agh.soa.lab6.zad4.exception.BookAlreadyReservedException;
import pl.edu.agh.soa.lab6.zad4.exception.BookNotFoundException;
import pl.edu.agh.soa.lab6.zad4.model.Book;

import java.util.List;

public interface LibraryService {

    void borrowBook(String isbn, String pesel) throws BookNotFoundException, BookAlreadyReservedException, BookAlreadyBorrowedException;

    void reserveBook(String isbn, String pesel) throws BookNotFoundException, BookAlreadyReservedException;

    void returnBook(String isbn) throws BookNotFoundException;

    List<Book> getBooks();

}
