package pl.edu.agh.soa.lab6.przyklad;

public class NotEnoughMoneyException extends Exception {
    private final String msg;

    public NotEnoughMoneyException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
