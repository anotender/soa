package pl.edu.agh.soa.lab9;

import javax.jws.WebService;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

@WebService(endpointInterface = "pl.edu.agh.soa.lab9.DayCounterService")
public class DayCounterServiceImpl implements DayCounterService {
    public long countDays() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime holidaysStart = LocalDateTime.of(today.getYear(), Month.JULY, 1, 0, 0);
        if (today.isBefore(holidaysStart))
            return ChronoUnit.DAYS.between(today, holidaysStart);
        else
            return ChronoUnit.DAYS.between(today, holidaysStart.withYear(today.getYear() + 1));
    }
}
