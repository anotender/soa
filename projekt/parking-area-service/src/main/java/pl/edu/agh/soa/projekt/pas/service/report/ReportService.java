package pl.edu.agh.soa.projekt.pas.service.report;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import pl.edu.agh.soa.projekt.pas.model.HistoricEvent;
import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.model.Ticket;
import pl.edu.agh.soa.projekt.pas.repository.HistoricEventRepository;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.OutputStream;
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

    public void preparePdfReport(OutputStream stream) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, stream);
        document.open();

        document.newPage();
        document.add(createParkingPlacesPopularityTable());

        document.newPage();
        document.add(createDurationPopularityTable());

        document.close();
    }

    private PdfPTable createParkingPlacesPopularityTable() {
        PdfPTable table = new PdfPTable(4);

        String title = "Parking places popularity (not paid stops: " + countParkingPlacesWithoutTicket() + ")";
        PdfPCell titleCell = new PdfPCell(new Phrase(title));
        titleCell.setColspan(4);
        table.addCell(titleCell);

        table.addCell("ID");
        table.addCell("Area");
        table.addCell("Street");
        table.addCell("Popularity");

        getParkingPlacesPopularity().forEach((key, value) -> {
            table.addCell(String.valueOf(key.getId()));
            table.addCell(key.getStreet().getArea().getName());
            table.addCell(key.getStreet().getName());
            table.addCell(String.valueOf(value));
        });

        return table;
    }

    private PdfPTable createDurationPopularityTable() {
        PdfPTable table = new PdfPTable(2);

        String title = "Duration popularity in minutes (average: " + countAverageDuration() + ")";
        PdfPCell titleCell = new PdfPCell(new Phrase(title));
        titleCell.setColspan(2);
        table.addCell(titleCell);

        table.addCell("Duration");
        table.addCell("Occurrences");

        getDurationPopularity().forEach((key, value) -> {
            table.addCell(String.valueOf(key));
            table.addCell(String.valueOf(value));
        });

        return table;
    }

}
