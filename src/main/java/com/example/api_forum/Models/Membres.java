package com.example.api_forum.Models;

import org.springframework.core.serializer.Serializer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="membre")
public class Membres implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(
            name ="pseudo",
            nullable = false,
            columnDefinition = "TEXT")
    private String pseudo;

    public Membres(long id, String pseudo) {
        this.id = id;
        this.pseudo = pseudo;
    }

    public Membres() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
