package pl.edu.agh.soa.projekt.pas.exception;

public class SessionAlreadyExistsException extends Exception {
    public SessionAlreadyExistsException(String message) {
        super(message);
    }
}