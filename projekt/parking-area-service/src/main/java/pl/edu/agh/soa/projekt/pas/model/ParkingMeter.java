package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "parking_meter")
public class ParkingMeter {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "pm_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "st_id")
    private Street street;

    @OneToMany(mappedBy = "parkingMeter")
    private List<Ticket> tickets;
}
