package pl.edu.agh.soa.lab6.przyklad;

public class SeatBookedException extends Exception {

    private final String msg;

    public SeatBookedException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
