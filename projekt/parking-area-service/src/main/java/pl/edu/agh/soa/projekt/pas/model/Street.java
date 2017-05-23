package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "street")
public class Street {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "st_id")
    private long id;

    @NotNull
    @Column(name = "st_name")
    private String name;

    @OneToMany(mappedBy = "street")
    private List<ParkingPlace> parkingPlaces;
}
