package pl.edu.agh.soa.lab2.zad5.model;

import java.util.UUID;

public class Feedback {

    private final String id = UUID.randomUUID().toString();
    private String name;
    private String email;
    private String comment;

    public Feedback(String name, String email, String comment) {
        this.name = name;
        this.email = email;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
