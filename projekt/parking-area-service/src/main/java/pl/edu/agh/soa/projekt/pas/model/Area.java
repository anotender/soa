package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ar_id")
    private Long id;

    @NotNull
    @Column(name = "ar_name")
    private String name;

    @OneToMany(mappedBy = "area")
    private List<User> users;

    @OneToMany(mappedBy = "area")
    private List<Street> streets;
}
