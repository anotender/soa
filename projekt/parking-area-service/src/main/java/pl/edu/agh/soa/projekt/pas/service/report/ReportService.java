package pl.edu.agh.soa.projekt.pas.service.report;

import pl.edu.agh.soa.projekt.pas.model.HistoricEvent;
import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.repository.HistoricEventRepository;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Map;

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

}
