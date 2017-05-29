package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "parking_place")
public class ParkingPlace {
    @Id
    @GeneratedValue(strategy = AUTO)
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
