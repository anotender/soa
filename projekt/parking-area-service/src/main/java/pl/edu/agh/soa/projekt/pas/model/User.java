package pl.edu.agh.soa.projekt.pas.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "us_id")
    private Long id;

    @NotNull
    @Column(name = "us_user_name")
    private String userName;

    @NotNull
    @Column(name = "us_password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "us_area_id")
    private Area area;
}
