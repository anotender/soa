package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "street")
public class Street {
    @Id
    @GeneratedValue
    @Column(name = "st_id")
    private Long id;

    @NotNull
    @Column(name = "st_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "st_area_id")
    private Area area;

    @OneToMany(mappedBy = "street")
    private List<ParkingPlace> parkingPlaces;

    @OneToMany(mappedBy = "street")
    private List<ParkingMeter> parkingMeters;
}
