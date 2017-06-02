package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue
    @Column(name = "tk_id")
    private Long id;

    @NotNull
    @Column(name = "tk_exp_time")
    private Long expirationTime;

    @ManyToOne
    @JoinColumn(name = "tk_parking_meter_id")
    private ParkingMeter parkingMeter;

    @OneToOne
    @JoinColumn(name = "tk_parking_place_id")
    private ParkingPlace parkingPlace;
}
