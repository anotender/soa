package pl.edu.agh.soa.lab6.przyklad;

public interface TheatreBooker {
    String bookSeat(int seatId) throws SeatBookedException, NotEnoughMoneyException;
}
