package pl.edu.agh.soa.lab8.zad3.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "author_first_name")
    private String authorFirstName;

    @NotNull
    @Column(name = "author_last_name")
    private String authorLastName;

    @NotNull
    @Column(name = "isbn", unique = true)
    private String isbn;

    @NotNull
    @Column(name = "title", unique = true)
    private String title;

    @NotNull
    @Column(name = "year")
    private int year;

    @NotNull
    @Column(name = "price")
    private double price;
}
