package pl.edu.agh.soa.projekt.pas.controller;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.service.report.ReportService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.Map;

@ManagedBean
public class ReportController {

    @EJB
    private ReportService reportService;

    public Map<ParkingPlace, Long> getParkingPlacesPopularity() {
        return reportService.getParkingPlacesPopularity();
    }
}
