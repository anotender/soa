package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "parking_meter")
public class ParkingMeter {
    @Id
    @GeneratedValue
    @Column(name = "pm_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pm_street_id")
    private Street street;

    @OneToMany(mappedBy = "parkingMeter")
    private Set<Ticket> tickets;
}
