package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(exclude = {"id", "password", "role", "area"})
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "us_id")
    private Long id;

    @NotNull
    @Column(name = "us_username", unique = true)
    private String username;

    @NotNull
    @Column(name = "us_password")
    private String password;

    @NotNull
    @Column(name = "us_role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "us_area_id")
    private Area area;
}
