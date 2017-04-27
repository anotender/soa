package pl.edu.agh.soa.lab6.zad4.exception;

public class BookNotFoundException extends Exception {
    public BookNotFoundException() {
        super("Book not found");
    }
}
