package pl.edu.agh.soa.projekt.pas.service.historicevent;

import pl.edu.agh.soa.projekt.pas.model.HistoricEvent;
import pl.edu.agh.soa.projekt.pas.repository.HistoricEventRepository;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.Transactional;

@Singleton
@Startup
@Transactional
public class HistoricEventService {

    @EJB
    private HistoricEventRepository historicEventRepository;

    public void saveHistoricEvent(HistoricEvent he) {
        historicEventRepository.save(he);
    }
}
