package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "us_id")
    private Long id;

    @NotNull
    @Column(name = "us_username")
    private String username;

    @NotNull
    @Column(name = "us_password")
    private String password;

    @NotNull
    @Column(name = "us_role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "us_area_id")
    private Area area;
}
