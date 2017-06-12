package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(exclude = {"street", "ticket"})
@Entity
@Table(name = "parking_place")
public class ParkingPlace {
    @Id
    @GeneratedValue
    @Column(name = "pp_id")
    private Long id;

    @NotNull
    @Column(name = "pp_occupied")
    private boolean occupied;

    @ManyToOne
    @JoinColumn(name = "pp_street_id")
    private Street street;

    @OneToOne(mappedBy = "parkingPlace")
    private Ticket ticket;
}
