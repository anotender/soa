package pl.edu.agh.soa.projekt.pas.exception;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException() {
        super("Invalid username or password");
    }
}
