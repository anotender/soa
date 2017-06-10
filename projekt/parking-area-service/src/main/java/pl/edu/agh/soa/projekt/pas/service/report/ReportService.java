package pl.edu.agh.soa.projekt.pas.service.report;

import pl.edu.agh.soa.projekt.pas.model.HistoricEvent;
import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.model.Ticket;
import pl.edu.agh.soa.projekt.pas.repository.HistoricEventRepository;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Singleton
@Startup
public class ReportService {

    @EJB
    private HistoricEventRepository historicEventRepository;

    public Map<ParkingPlace, Long> getParkingPlacesPopularity() {
        return historicEventRepository
                .findAll()
                .stream()
                .collect(groupingBy(HistoricEvent::getParkingPlace, counting()));
    }

    public Map<Integer, Long> getDurationPopularity() {
        return historicEventRepository
                .findAll()
                .stream()
                .map(HistoricEvent::getTicket)
                .filter(Objects::nonNull)
                .collect(groupingBy(Ticket::getDuration, counting()));
    }

    public long countParkingPlacesWithoutTicket() {
        return historicEventRepository
                .findAll()
                .stream()
                .map(HistoricEvent::getTicket)
                .filter(Objects::isNull)
                .count();
    }

    public double countAverageDuration() {
        return historicEventRepository
                .findAll()
                .stream()
                .map(HistoricEvent::getTicket)
                .filter(Objects::nonNull)
                .mapToInt(Ticket::getDuration)
                .average()
                .orElse(0);
    }

}
