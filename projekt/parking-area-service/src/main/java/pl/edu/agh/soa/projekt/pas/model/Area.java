package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"id", "users", "streets"})
@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue
    @Column(name = "ar_id")
    private Long id;

    @NotNull
    @Column(name = "ar_name", unique = true)
    private String name;

    @OneToMany(mappedBy = "area")
    private Set<User> users;

    @OneToMany(mappedBy = "area")
    private Set<Street> streets;
}
