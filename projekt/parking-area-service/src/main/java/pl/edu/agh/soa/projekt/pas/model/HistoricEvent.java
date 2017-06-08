package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "historic_event")
public class HistoricEvent {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "he_parking_place_id")
    private ParkingPlace parkingPlace;

    @OneToOne
    @JoinColumn(name = "he_ticket_id")
    private Ticket ticket;
}
