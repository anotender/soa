package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @NotNull
    @Column(name = "tk_duration")
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "tk_parking_meter_id")
    private ParkingMeter parkingMeter;

    @OneToOne
    @JoinColumn(name = "tk_parking_place_id")
    private ParkingPlace parkingPlace;
}
