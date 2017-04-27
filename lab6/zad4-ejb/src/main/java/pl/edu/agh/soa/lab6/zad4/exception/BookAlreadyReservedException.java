package pl.edu.agh.soa.lab6.zad4.exception;

public class BookAlreadyReservedException extends Exception {
    public BookAlreadyReservedException() {
        super("Book already reserved");
    }
}
