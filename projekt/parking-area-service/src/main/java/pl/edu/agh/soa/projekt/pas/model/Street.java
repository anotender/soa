package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"area", "parkingPlaces", "parkingMeters"})
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
    private Set<ParkingPlace> parkingPlaces;

    @OneToMany(mappedBy = "street")
    private Set<ParkingMeter> parkingMeters;
}
