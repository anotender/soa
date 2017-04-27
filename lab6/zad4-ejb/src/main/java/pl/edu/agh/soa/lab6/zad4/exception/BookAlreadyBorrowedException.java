package pl.edu.agh.soa.lab6.zad4.exception;

public class BookAlreadyBorrowedException extends Exception {
    public BookAlreadyBorrowedException() {
        super("Book already borrowed");
    }
}
